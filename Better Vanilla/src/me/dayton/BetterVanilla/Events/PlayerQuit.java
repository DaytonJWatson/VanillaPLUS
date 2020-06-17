package me.dayton.BetterVanilla.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import me.dayton.BetterVanilla.Config.ConfigUtil;

public class PlayerQuit implements Listener {
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e)	{
		Player p = e.getPlayer();
		String quitMessage = ConfigUtil.getQuitMessage();
		quitMessage = quitMessage.replace("<player>", p.getName());
		
		e.setQuitMessage(quitMessage);
	}
}