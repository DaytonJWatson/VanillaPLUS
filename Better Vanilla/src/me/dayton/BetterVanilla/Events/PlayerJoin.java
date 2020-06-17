package me.dayton.BetterVanilla.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.dayton.BetterVanilla.Spawn;
import me.dayton.BetterVanilla.Utils;
import me.dayton.BetterVanilla.Config.ConfigUtil;

public class PlayerJoin implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		String joinMessage = ConfigUtil.getJoinMessage();
		joinMessage = joinMessage.replace("<player>", p.getName());
		
		String firstJoinMessage = ConfigUtil.getFirstJoinMessage();
		firstJoinMessage = firstJoinMessage.replace("<player>", p.getName());
		firstJoinMessage = firstJoinMessage.replace("<server>", ConfigUtil.getServerName());
		
		String headerText = ConfigUtil.getHeader();
		headerText = headerText.replace("<server>", ConfigUtil.getServerName());
		headerText = headerText.replace("<motd>", ConfigUtil.getServerMotd());
		
		String footerText = ConfigUtil.getFooter();
		footerText = footerText.replace("<server>", ConfigUtil.getServerName());
		footerText = footerText.replace("<motd>", ConfigUtil.getServerMotd());
		
		if(p.hasPlayedBefore()) {
			// Played before
			e.setJoinMessage(null);
			Bukkit.broadcastMessage(joinMessage);
			p.setPlayerListName(p.getName());
		} else {
			// First time playing
			Spawn.teleport(p, true, null);
			e.setJoinMessage(firstJoinMessage);
			p.setPlayerListName(Utils.chat(ConfigUtil.getNewPrefix() + p.getName()));
		}
		
		if(ConfigUtil.getHeaderEnabled()) {
			p.setPlayerListHeader(headerText);
		} else {
			return;
		}
		
		if(ConfigUtil.getFooterEnabled()) {
			p.setPlayerListFooter(footerText);
		} else {
			return;
		}
	}
}