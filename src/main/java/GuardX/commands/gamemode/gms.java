package GuardX.commands.gamemode;

import GuardX.util.MessageUtil;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class gms implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p) {
            if (p.hasPermission("guardx.admin.gms")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.YELLOW + "Gamemode changed to " + ChatColor.BLUE + "Survival");
            }else{
                p.sendMessage(MessageUtil.format("{prefix}&cAccess Denied &1- &cMissing &6guardx.admin.gms&c Permission"));
            }
        }
        return true;
    }
}
