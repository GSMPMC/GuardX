package GuardX.Commands.Gamemode;

import GuardX.Util.MessageUtil;
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
            if (p.hasPermission("guardx.admin.gma")){
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ChatColor.YELLOW + "Gamemode changed to " + ChatColor.BLUE + "Adventure");
            }else{
                p.sendMessage(MessageUtil.format("{prefix}&cAccess Denied &1- &cMissing &6guardx.admin.gma&c Permission"));
            }
        }
        return true;
    }
}
