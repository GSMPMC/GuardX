package GuardX.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlock implements Listener {

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        e.getPlayer().sendMessage(ChatColor.YELLOW + "You broke a " + ChatColor.GOLD + e.getBlock().getType());
    }
}
