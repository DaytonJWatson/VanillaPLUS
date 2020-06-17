package me.dayton.BetterVanilla;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Utils {
	public static String chat(String s) {
		return ChatColor.translateAlternateColorCodes('&', s);
	}
	
	public static boolean verifyIfIsAPlayer(CommandSender sender) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("");
			return true;
		}
		else {
			return false;
		}
	}
}
