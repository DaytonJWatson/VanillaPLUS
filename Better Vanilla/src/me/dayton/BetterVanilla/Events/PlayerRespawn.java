package me.dayton.BetterVanilla.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import me.dayton.BetterVanilla.Spawn;
import me.dayton.BetterVanilla.Config.ConfigUtil;

public class PlayerRespawn implements Listener {
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		Player p = e.getPlayer();
		
		if(p.getBedSpawnLocation() == null) {
			e.setRespawnLocation(Spawn.getLocation());
			p.sendMessage(ConfigUtil.getBedNULL());
		} else {
			p.sendMessage(ConfigUtil.getGoBed());
		}
	}
}