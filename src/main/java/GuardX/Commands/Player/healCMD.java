package GuardX.Commands.Player;

import GuardX.Util.MessageUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class healCMD implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if (commandSender instanceof Player p){
            if (p.hasPermission("guardx.admin.cmd.heal")){
                if (p.getHealth() == 20){
                    p.sendMessage(ChatColor.RED + "Your health is still full!");
                }else{
                    p.setHealth(20);
                    p.sendMessage(ChatColor.GREEN + "Healed!");
                }
            }else{
                p.sendMessage(MessageUtil.format("{prefix}&cAccess Denied &1- &cMissing &6guardx.admin.cmd.heal&c Permission"));
            }
        }
        return true;
    }
}
