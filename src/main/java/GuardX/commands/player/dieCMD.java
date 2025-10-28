package GuardX.commands.player;

import GuardX.util.MessageUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class dieCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p){
            if (p.hasPermission("guardx.admin.cmd.die")){
                p.setHealth(0);
                p.sendMessage(ChatColor.RED + "You killed yourself!");
            }else{
                p.sendMessage(MessageUtil.format("{prefix}&cAccess Denied &1- &cMissing &6guardx.admin.cmd.die&c Permission"));
            }
        }
        return true;
    }
}
