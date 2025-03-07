package GuardX.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ExpBottleEvent;

public class XPBottleBreak implements Listener {

    @EventHandler
    public void onXPBottleBreak(ExpBottleEvent e) {
        e.setShowEffect(false);
        e.setExperience(900000000);
    }

}