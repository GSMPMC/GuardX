package GuardX.events;

import GuardX.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onlineMode implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();

        if (p.hasPermission("guardx.admin.notify")) {
            boolean onlineMode = Bukkit.getServer().getOnlineMode();
            if (!onlineMode) {
                p.sendMessage(MessageUtil.format("{prefix}&cThis server is operating without &eOnline-Mode&c turned on. For safety purposes please turn on &eOnline-Mode&c in &aserver.properties&c."));
            }
        }
    }
}
