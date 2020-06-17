package me.dayton.BetterVanilla;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.dayton.BetterVanilla.Commands.BetterVanillaCMD;
import me.dayton.BetterVanilla.Commands.SpawnCMD;
import me.dayton.BetterVanilla.Config.Config;
import me.dayton.BetterVanilla.Events.PlayerChat;
import me.dayton.BetterVanilla.Events.PlayerJoin;
import me.dayton.BetterVanilla.Events.PlayerQuit;
import me.dayton.BetterVanilla.Events.PlayerRespawn;
import me.dayton.BetterVanilla.Events.ServerPing;

public class Main extends JavaPlugin {
	
	private static Main instance;
	
	private File spawnFile = new File(getDataFolder(), "spawn.yml");
	public YamlConfiguration spawn = YamlConfiguration.loadConfiguration(this.spawnFile);
	
	public void onEnable() {
		instance = this;
		
		Config c = new Config(this);
		c.createConfig();
		
		if (!spawnFile.exists()) {
			saveSpawnFile();
			getLogger().warning("spawn.yml not found, creating one for you!");
		}
		
		loadCommands();
		loadEvents();
	}
	
	public void onDisable() {
		
	}
	
	public void loadCommands() {
		getCommand("vanillaplus").setExecutor(new BetterVanillaCMD());
		getCommand("spawn").setExecutor(new SpawnCMD());
		getCommand("setspawn").setExecutor(new SpawnCMD());
	}
	
	public void loadEvents() {
		PluginManager pm = getServer().getPluginManager();
		
		pm.registerEvents(new PlayerChat(), this);
		pm.registerEvents(new PlayerJoin(), this);
		pm.registerEvents(new PlayerQuit(), this);
		pm.registerEvents(new ServerPing(), this);
		pm.registerEvents(new PlayerRespawn(), this);
	}
	
	public void saveSpawnFile() {
		try {
			this.spawn.save(this.spawnFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static FileConfiguration getConfiguration() {
		return getInstance().getConfig();
	}
	
	public static Main getInstance() {
		return instance;
	}
}