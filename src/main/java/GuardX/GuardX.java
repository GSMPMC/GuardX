package GuardX;

import GuardX.Commands.Gamemode.gma;
import GuardX.Commands.Gamemode.gmc;
import GuardX.Commands.Gamemode.gms;
import GuardX.Commands.Gamemode.gmsp;
import GuardX.Commands.Player.*;
import GuardX.Commands.Plugin.reloadCMD;
import GuardX.Commands.Server.serverinfoCMD;
import GuardX.Commands.Server.World.dayCMD;
import GuardX.Commands.Server.World.mnightCMD;
import GuardX.Commands.Server.World.nightCMD;
import GuardX.Commands.Server.World.noonCMD;
import GuardX.Events.*;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GuardX extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
    //MainCMD Register
        reloadCMD reloadCMD = new reloadCMD(this);
        getCommand("guardx").setExecutor(new reloadCMD(this));
        getCommand("guardx").setTabCompleter(reloadCMD);
        //Logger
        getLogger().info("GuardX Online without any issues");
        getLogger().warning("This plugin is not recommended to be used in a functioning server/public server as it may cause unexpected issues.");
        //Events
        //  getServer().getPluginManager().registerEvents(new XPBottleBreak(), this);
        //  getServer().getPluginManager().registerEvents(new ShearSheep(), this);
        //  getServer().getPluginManager().registerEvents(new BreakBlock(), this);
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        //  getServer().getPluginManager().registerEvents(new Hell(), this);
        //  getServer().getPluginManager().registerEvents(new spawn(), this);
        //  getServer().getPluginManager().registerEvents(new InvOn(), this);
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
            //Misc
        Objects.requireNonNull(getCommand("allenchant")).setExecutor(new aenchantCMD());
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