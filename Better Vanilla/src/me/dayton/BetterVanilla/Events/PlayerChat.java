package me.dayton.BetterVanilla.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.dayton.BetterVanilla.Config.ConfigUtil;

public class PlayerChat implements Listener {
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String message = ConfigUtil.getChatFormat();
		message = message.replace("<player>", p.getName());
		message = message.replace("<message>", e.getMessage());
		
		e.setFormat(message);
	}
}