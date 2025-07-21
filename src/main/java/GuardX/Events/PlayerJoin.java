package GuardX.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(ChatColor.GOLD + e.getPlayer().getName() + ChatColor.GREEN + " Has joined the server!");
    }
    @EventHandler
    public void onBuffyJoin(PlayerJoinEvent p){
        if (p.getPlayer().getName().matches("BuffyOfficial")){
            p.setJoinMessage(ChatColor.RED + "[Owner]" +p.getPlayer().getName() + ChatColor.GREEN + " Has joined the server!");
        }
    }
}
