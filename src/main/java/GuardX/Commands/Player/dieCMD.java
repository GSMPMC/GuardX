package GuardX.Commands.Player;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class dieCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p){
            if (p.getGameMode() == GameMode.CREATIVE){
                p.sendMessage(ChatColor.RED + "Creative players can't be killed!");
            }else{
                p.setHealth(0);
                p.sendMessage(ChatColor.RED + "You killed yourself!");
            }
        }
        return true;
    }
}
