package GuardX.Commands.Player;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class feedCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p){
            if (p.hasPermission("guardx.admin.cmd.feed")){
                if (p.getFoodLevel() == 20){
                    p.sendMessage(ChatColor.RED + "You're still full!");
                }else{
                    p.setFoodLevel(20);
                    p.sendMessage(ChatColor.GREEN + "You're now full! :D");
                }
            }else{
                p.sendMessage(ChatColor.RED + "Access Denied " + ChatColor.BLUE + "-" + ChatColor.RED + " Missing " + ChatColor.GOLD + "guardx.admin.cmd.feed " + ChatColor.RED + "Permission");
            }
        }
        return true;
    }
}
