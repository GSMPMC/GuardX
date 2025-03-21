package GuardX.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BreakBlock implements Listener {

    @EventHandler
    public void onBreakBlock(BlockBreakEvent e) {
        if (!e.getPlayer().hasPermission("guardx.world.breakblock")){
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.RED + "Access Denied " + ChatColor.BLUE + "-" + ChatColor.RED + " Missing " + ChatColor.GOLD + "guardx.admin.world.blockbreak " + ChatColor.RED + "Permission");
        }
    }
}
