package GuardX.Commands.Server.World;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class nightCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p) {
            p.getWorld().setTime(13000L);
            p.sendMessage(ChatColor.GREEN + "Time set to " + ChatColor.LIGHT_PURPLE + "Night");
        }
        return true;
    }
}
