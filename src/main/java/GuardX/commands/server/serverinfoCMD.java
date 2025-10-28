package GuardX.commands.server;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class serverinfoCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        if (commandSender instanceof Player p){
            Server server = p.getServer();
            boolean onlineMode = Bukkit.getServer().getOnlineMode();
            p.sendMessage(ChatColor.YELLOW + server.getName() + " Info");
            p.sendMessage(ChatColor.GREEN + "Server Version: " + ChatColor.GOLD + server.getVersion());
            p.sendMessage(ChatColor.GREEN + "Server IP: " + ChatColor.GOLD + Bukkit.getServer().getIp());
            if (onlineMode){
                p.sendMessage(ChatColor.GREEN + "Server Online-Mode: " + ChatColor.GOLD + "Enabled");
            }else{
                p.sendMessage(ChatColor.GREEN + "Server Online-Mode: " + ChatColor.RED + "Disabled" + ChatColor.DARK_RED + " !!!Security Risk!!!");
            }
            p.sendMessage(ChatColor.GREEN + "Players: " + ChatColor.GOLD + server.getOnlinePlayers().size() + "/" + server.getMaxPlayers());
        }
        return true;
    }
}