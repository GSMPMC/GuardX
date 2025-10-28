package GuardX.Util;

import org.bukkit.ChatColor;

public class MessageUtil {
    private static final String PREFIX = ChatColor.YELLOW + "[" + ChatColor.DARK_PURPLE + "GuardX" + ChatColor.YELLOW + "] " + ChatColor.RESET;

    public static String format(String message){
        return ChatColor.translateAlternateColorCodes('&', message.replace("{prefix}", PREFIX));
    }
}