package GuardX;

import GuardX.commands.gamemode.gma;
import GuardX.commands.gamemode.gmc;
import GuardX.commands.gamemode.gms;
import GuardX.commands.gamemode.gmsp;
import GuardX.commands.player.*;
import GuardX.commands.plugin.helpCMD;
import GuardX.commands.plugin.guardxCMD;
import GuardX.commands.server.serverinfoCMD;
import GuardX.commands.server.world.dayCMD;
import GuardX.commands.server.world.mnightCMD;
import GuardX.commands.server.world.nightCMD;
import GuardX.commands.server.world.noonCMD;
import GuardX.events.*;
import GuardX.util.MessageUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class GuardX extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
    //Logger
        getLogger().info("GuardX Online");
        getLogger().warning("This plugin is not recommended to be used in a functioning server/public server as it may cause unexpected issues.");
    //MainCMD Register
        guardxCMD reloadCMD = new guardxCMD(this);
        Objects.requireNonNull(getCommand("guardx")).setExecutor(new guardxCMD(this));
        Objects.requireNonNull(getCommand("guardx")).setTabCompleter(reloadCMD);
    //Events
        getServer().getPluginManager().registerEvents(new onlineMode(), this);
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
        //No Commands
    //Server
        Objects.requireNonNull(getCommand("sinfo")).setExecutor(new serverinfoCMD());
        // World
        Objects.requireNonNull(getCommand("day")).setExecutor(new dayCMD());
        Objects.requireNonNull(getCommand("noon")).setExecutor(new noonCMD());
        Objects.requireNonNull(getCommand("night")).setExecutor(new nightCMD());
        Objects.requireNonNull(getCommand("mnight")).setExecutor(new mnightCMD());
    //Plugin
        Objects.requireNonNull(getCommand("gxhelp")).setExecutor(new helpCMD());
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(MessageUtil.format("{prefix}&c[GuardX] Plugin going offline..."));
    }
}