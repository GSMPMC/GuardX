package GuardX.Events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearSheep implements Listener {

    @EventHandler
    public void onSheepShear(PlayerShearEntityEvent e) {

        Player p = e.getPlayer();
        Entity entity = e.getEntity();

        if (entity.getType() == EntityType.SHEEP){
            p.sendMessage("This is a sheep, you can't shear it. Poor sheep :(");
            e.setCancelled(true);
        }else{
            p.sendMessage("This is not a sheep.");
        }
    }
}