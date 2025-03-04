package GuardX;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerBedLeaveEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GuardX extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("GuardX Online without any issues");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        event.setJoinMessage(ChatColor.GOLD + "Welcome " + player.getName() + " to Gaming SMP!");
    }

    @EventHandler
    public void onBedLeave(PlayerBedLeaveEvent event) {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "GuardX System" + ChatColor.DARK_GRAY + "]" + " " + ChatColor.DARK_RED + ">" + " " + ChatColor.YELLOW + "You left your bed here!");
        player.setFlying(true);
        player.setGameMode(GameMode.SURVIVAL);
    }

    @EventHandler
    public void onBreakBlock(BlockBreakEvent event) {
        // No code yet, will be added soon.
    }

    @Override
    public void onDisable() {
        getLogger().info("GuardX Offline");
    }
}