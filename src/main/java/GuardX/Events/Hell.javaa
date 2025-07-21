package GuardX.Events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class Hell implements Listener {

    @EventHandler
    public void onCactusBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if (e.getBlock().getType() == Material.CACTUS){
            World nether = Bukkit.getWorlds().stream()
                    .filter(world -> world.getEnvironment() == World.Environment.NETHER)
                    .findFirst()
                    .orElse(null);

            if (nether != null){
                Location spawnLocation = new Location(nether, -150, 74, 13);
                p.teleport(spawnLocation);
                p.sendMessage(ChatColor.RED + "YOU DARE DISRESPECT THE CACTUS CLAN! " + ChatColor.DARK_RED + ChatColor.BOLD + "Welcome to Hell.");
                p.getInventory().clear();
            }else{
                p.sendMessage(ChatColor.RED + "Error encountered while running the event.");
            }
        }
    }
}