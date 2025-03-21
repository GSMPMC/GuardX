package GuardX.Commands.Player;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class godCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p) {
            if (p.hasPermission("guardx.admin.cmd.god")){
                if (p.isInvulnerable()) {
                    p.setInvulnerable(false);
                    p.sendMessage(ChatColor.RED + "God mode disabled!");
                } else {
                    p.setInvulnerable(true);
                    p.sendMessage(ChatColor.GREEN + "God mode enabled!");
                }
            }else{
                p.sendMessage(ChatColor.RED + "Access Denied " + ChatColor.BLUE + "-" + ChatColor.RED + " Missing " + ChatColor.GOLD + "guardx.admin.cmd.god " + ChatColor.RED + "Permission");
            }
        }
        return true;
    }
}
