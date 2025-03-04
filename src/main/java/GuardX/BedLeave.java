package GuardX;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedLeaveEvent;

public final class BedLeave implements Listener {


    @EventHandler
    public void onBedLeave(PlayerBedLeaveEvent event) throws InterruptedException {
        Player player = event.getPlayer();
        player.sendMessage(ChatColor.DARK_GRAY + "[" + ChatColor.DARK_PURPLE + ChatColor.BOLD + "GuardX System" + ChatColor.DARK_GRAY + "]" + ChatColor.DARK_RED + ">" + ChatColor.YELLOW + "You left your bed here!");
        wait(5000);
        player.setHealth(0);
    }
}