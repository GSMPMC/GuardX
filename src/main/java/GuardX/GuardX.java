package GuardX;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class GuardX extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("GuardX Online without any issues");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("GuardX Offline");
    }
}