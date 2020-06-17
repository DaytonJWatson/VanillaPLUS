package me.dayton.BetterVanilla.Config;

import me.dayton.BetterVanilla.Main;
import me.dayton.BetterVanilla.Utils;

public class ConfigUtil {
	public static String getServerName() {
		return Utils.chat(Main.getConfiguration().getString("serverSettings.serverName"));
	}
	
	public static String getServerMotd() {
		return Utils.chat(Main.getConfiguration().getString("serverSettings.serverMotd"));
	}
	
	public static int getMaxPlayers() {
		return Main.getConfiguration().getInt("serverSettings.maxPlayers");
	}
	
	public static String getWorldName() {
		return Utils.chat(Main.getConfiguration().getString("serverSettings.worldName"));
	}
	
	public static boolean getHeaderEnabled() {
		return Main.getConfiguration().getBoolean("serverSettings.tabListHeader.enabled");
	}
	
	public static String getHeader() {
		return Utils.chat(Main.getConfiguration().getString("serverSettings.tabListHeader.header"));
	}
	
	public static boolean getFooterEnabled() {
		return Main.getConfiguration().getBoolean("serverSettings.tabListFooter.enabled");
	}
	
	public static String getFooter() {
		return Utils.chat(Main.getConfiguration().getString("serverSettings.tabListFooter.footer"));
	}
	
	public static String getChatFormat() {
		return Utils.chat(Main.getConfiguration().getString("chatSettings.chatFormat"));
	}
	
	public static String getNewPrefix() {
		return Utils.chat(Main.getConfiguration().getString("chatSettings.newPlayerPrefix"));
	}
	
	public static String getFirstJoinMessage() {
		return Utils.chat(Main.getConfiguration().getString("chatSettings.firstJoinMessage"));
	}
	
	public static String getJoinMessage() {
		return Utils.chat(Main.getConfiguration().getString("chatSettings.joinMessage"));
	}
	
	public static String getQuitMessage() {
		return Utils.chat(Main.getConfiguration().getString("chatSettings.quitMessage"));
	}
	
	public static String getNoPermission() {
		return Utils.chat(Main.getConfiguration().getString("messageSettings.noPermission"));
	}
	
	public static String getGoSpawn() {
		return Utils.chat(Main.getConfiguration().getString("messageSettings.goSpawn"));
	}
	
	public static String getSetSpawn() {
		return Utils.chat(Main.getConfiguration().getString("messageSettings.setSpawn"));
	}
	
	public static String getSpawnNULL() {
		return Utils.chat(Main.getConfiguration().getString("messageSettings.spawnNULL"));
	}
	
	public static String getBedNULL() {
		return Utils.chat(Main.getConfiguration().getString("messageSettings.bedNULL"));
	}
	
	public static String getGoBed() {
		return Utils.chat(Main.getConfiguration().getString("messageSettings.goBed"));
	}
}