package me.dayton.BetterVanilla.Commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dayton.BetterVanilla.Spawn;
import me.dayton.BetterVanilla.Config.ConfigUtil;

public class SpawnCMD implements CommandExecutor {
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("spawn")) {
			if(p.hasPermission("vanillaplus.spawn") || !p.isOp()) {
				if(Spawn.getLocation() == null) {
					p.sendMessage(ConfigUtil.getSpawnNULL());
				} else {
					Spawn.spawn(p);
				}
			} else {
				sender.sendMessage(ConfigUtil.getNoPermission());
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("setspawn")) {
			if(p.hasPermission("vanillaplus.setspawn") || p.isOp()) {
				Location spawnLocation = p.getLocation();
				
				Spawn.setLocation(spawnLocation);
				p.getWorld().setSpawnLocation((int) spawnLocation.getX(), (int) spawnLocation.getY(), (int) spawnLocation.getZ());
				p.sendMessage(ConfigUtil.getSetSpawn());
			}
			else {
				p.sendMessage(ConfigUtil.getNoPermission());
			}
		}
		return false;
	}
}