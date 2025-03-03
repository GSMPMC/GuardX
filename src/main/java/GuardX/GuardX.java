package GuardX;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class GuardX extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        System.out.print("GuardX Online without any issues.");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        System.out.print("A Player has joined the server!");
    }

    @Override
    public void onDisable() {
        System.out.print("GuardX Offline.");
    }
}
