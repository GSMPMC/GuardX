package GuardX.Commands.Gamemode;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gmc implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p){
            if (p.hasPermission("guardx.admin.gmc")){
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.YELLOW + "Gamemode changed to " + ChatColor.BLUE + "Creative");
            }else{
                p.sendMessage(ChatColor.RED + "Access Denied " + ChatColor.BLUE + "-" + ChatColor.RED + " Missing " + ChatColor.GOLD + "guardx.admin.gmc " + ChatColor.RED + "Permission");
            }
        }
        return true;
    }
}
