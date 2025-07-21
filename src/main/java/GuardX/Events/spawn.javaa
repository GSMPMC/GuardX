package GuardX.Events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class spawn implements Listener {

    @EventHandler
    public void onCactusBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if (e.getBlock().getType() == Material.OAK_SIGN){
            World overworld = Bukkit.getWorlds().stream()
                    .filter(world -> world.getEnvironment() == World.Environment.NORMAL)
                    .findFirst()
                    .orElse(null);

            if (overworld != null){
                Location spawnLocation = new Location(overworld, 0, overworld.getHighestBlockYAt(0, 0) + 1, 0);
                p.teleport(spawnLocation);
                p.sendMessage(ChatColor.YELLOW + "Teleported to the " + ChatColor.RED + "Nether");
            }else{
                p.sendMessage(ChatColor.RED + "Error encountered while running the event.");
            }
        }
    }
}
