package GuardX.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class InvOn implements Listener {

    public void onPDeath(PlayerDeathEvent e){
        Player p = e.getPlayer();
        e.setKeepLevel(true);
        e.setKeepInventory(true);
        e.setDeathMessage(ChatColor.YELLOW + p.getName() + "Access Denied to their Life Support!");
    }
}
