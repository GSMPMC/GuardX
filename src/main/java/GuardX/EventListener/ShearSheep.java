package GuardX.EventListener;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerShearEntityEvent;

public class ShearSheep implements Listener {

    @EventHandler
    public void onSheepShear(PlayerShearEntityEvent e) {

        Player player = e.getPlayer();
        Entity entity = e.getEntity();

        if (entity.getType() == EntityType.SHEEP){
            player.sendMessage("This is a sheep, you can't shear it. Poor sheep :(");
            e.setCancelled(true);
        }else{
            player.sendMessage("This is not a sheep.");
        }
    }
}