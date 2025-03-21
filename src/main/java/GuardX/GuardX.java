package GuardX;

import GuardX.Commands.Gamemode.gma;
import GuardX.Commands.Gamemode.gmc;
import GuardX.Commands.Gamemode.gms;
import GuardX.Commands.Gamemode.gmsp;
import GuardX.Commands.Player.dieCMD;
import GuardX.Commands.Player.feedCMD;
import GuardX.Commands.Player.godCMD;
import GuardX.Commands.Player.healCMD;
import GuardX.Commands.Server.serverinfoCMD;
import GuardX.Commands.Server.World.dayCMD;
import GuardX.Commands.Server.World.mnightCMD;
import GuardX.Commands.Server.World.nightCMD;
import GuardX.Commands.Server.World.noonCMD;
import GuardX.Events.BreakBlock;
import GuardX.Events.PlayerJoin;
import GuardX.Events.ShearSheep;
import GuardX.Events.XPBottleBreak;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GuardX extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        //Logger
        getLogger().info("GuardX Online without any issues");
        getLogger().warning("This plugin is not recommended to be used in a functioning server/public server as it may cause unexpected issues.");
        //Events
        getServer().getPluginManager().registerEvents(new XPBottleBreak(), this);
        getServer().getPluginManager().registerEvents(new ShearSheep(), this);
        getServer().getPluginManager().registerEvents(new BreakBlock(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
    //Commands
        //Gamemode
        Objects.requireNonNull(getCommand("gmc")).setExecutor(new gmc());
        Objects.requireNonNull(getCommand("gma")).setExecutor(new gma());
        Objects.requireNonNull(getCommand("gms")).setExecutor(new gms());
        Objects.requireNonNull(getCommand("gmsp")).setExecutor(new gmsp());
    //Player
        //Health
        Objects.requireNonNull(getCommand("god")).setExecutor(new godCMD());
        Objects.requireNonNull(getCommand("feed")).setExecutor(new feedCMD());
        Objects.requireNonNull(getCommand("heal")).setExecutor(new healCMD());
        Objects.requireNonNull(getCommand("die")).setExecutor(new dieCMD());
    //Server
        Objects.requireNonNull(getCommand("sinfo")).setExecutor(new serverinfoCMD());
        // World
        Objects.requireNonNull(getCommand("day")).setExecutor(new dayCMD());
        Objects.requireNonNull(getCommand("noon")).setExecutor(new noonCMD());
        Objects.requireNonNull(getCommand("night")).setExecutor(new nightCMD());
        Objects.requireNonNull(getCommand("mnight")).setExecutor(new mnightCMD());
    }

    @Override
    public void onDisable() {
        getLogger().info("GuardX Offline");
    }
}