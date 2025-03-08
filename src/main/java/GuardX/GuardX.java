package GuardX;

import GuardX.EventListener.Commands.feedCMD;
import GuardX.EventListener.Commands.godCMD;
import GuardX.EventListener.ShearSheep;
import GuardX.EventListener.XPBottleBreak;
import org.bukkit.ChatColor;
import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class GuardX extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        //Plugin Logger
        getLogger().info("GuardX Online without any issues");
        //Plugin Events
        getServer().getPluginManager().registerEvents(this, this);
        getServer().getPluginManager().registerEvents(new XPBottleBreak(), this);
        getServer().getPluginManager().registerEvents(new ShearSheep(), this);
        //Plugin Commands
        getCommand("god").setExecutor(new godCMD());
        getCommand("feed").setExecutor(new feedCMD());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String @NotNull [] args) {

        if (command.getName().equalsIgnoreCase("die")){

            if (sender instanceof Player p){
                p.setHealth(0);
                p.sendMessage(ChatColor.RED + "You killed yourself lol.");
            }else if (sender instanceof ConsoleCommandSender){
                getLogger().warning("Console Blocked! This command can only be ran by a player!");
            }else if (sender instanceof BlockCommandSender){
                getLogger().warning("CMDBlock Blocked! This command can only be ran by a player!");
            }

        }

        return true;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GOLD + "Welcome " + player.getName() + " to Gaming SMP!");
    }

    @Override
    public void onDisable() {
        getLogger().info("GuardX Offline");
    }
}