package GuardX.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(ChatColor.GOLD + e.getPlayer().getName() + ChatColor.GREEN + " Has joined the server!");
    }
}
