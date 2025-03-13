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
            if (p.getFoodLevel() == 20){
                p.sendMessage(ChatColor.RED + "You're still full!");
            }else{
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.GREEN + "You're now full! :D");
            }
        }
        return true;
    }
}
