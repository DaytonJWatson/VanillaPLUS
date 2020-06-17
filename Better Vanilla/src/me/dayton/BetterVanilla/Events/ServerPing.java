package me.dayton.BetterVanilla.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.dayton.BetterVanilla.Config.ConfigUtil;

public class ServerPing implements Listener {
	@EventHandler
	public void onServerPing(ServerListPingEvent e) {
		
		e.setMaxPlayers(ConfigUtil.getMaxPlayers());
		e.setMotd(ConfigUtil.getServerMotd());
	}
}
