package GuardX.Commands.Gamemode;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gma implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p){
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage(ChatColor.YELLOW + "Gamemode changed to " + ChatColor.BLUE + ChatColor.BOLD + "Adventure");
        }

        return true;
    }
}
