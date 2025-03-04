package GuardX;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
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
        event.setJoinMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Welcome " + player.getName() + " to Gaming SMP!");
    }
    @EventHandler
    public void onPlayerBedLeave(PlayerBedLeaveEvent event) {

    }

    @Override
    public void onDisable() {
        getLogger().info("GuardX Offline");
    }
}
