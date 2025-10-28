package GuardX.commands.plugin;

import GuardX.commands.gamemode.gma;
import GuardX.commands.gamemode.gmc;
import GuardX.commands.gamemode.gms;
import GuardX.commands.gamemode.gmsp;
import GuardX.commands.player.*;
import GuardX.commands.server.serverinfoCMD;
import GuardX.util.MessageUtil;
import GuardX.commands.server.world.*;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class guardxCMD implements CommandExecutor, TabCompleter {

    private final JavaPlugin plugin;
    private final Map<String, CommandExecutor> subcommands = new HashMap<>();

    public guardxCMD(JavaPlugin plugin) {
        this.plugin = plugin;

        // Subcommands routed to their own classes
        subcommands.put("heal", new healCMD());
        subcommands.put("feed", new feedCMD());
        subcommands.put("god", new godCMD());
        subcommands.put("die", new dieCMD());
        subcommands.put("day", new dayCMD());
        subcommands.put("noon", new noonCMD());
        subcommands.put("night", new nightCMD());
        subcommands.put("mnight", new mnightCMD());
        subcommands.put("sinfo", new serverinfoCMD());
        subcommands.put("gma", new gma());
        subcommands.put("gmc", new gmc());
        subcommands.put("gms", new gms());
        subcommands.put("gmsp", new gmsp());
        subcommands.put("help", new helpCMD());
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String @NotNull [] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cOnly players can use GuardX commands.");
            return true;
        }

        if (args.length == 0) {
            player.sendMessage(MessageUtil.format("{prefix}&eUsage: /guardx <reload|heal|feed|...>"));
            return true;
        }

        String sub = args[0].toLowerCase();

        // Inline reload handling
        if (sub.equals("reload")) {
            if (!player.hasPermission("guardx.reload")) {
                player.sendMessage("§8[§5GuardX§8] §cYou don't have permission to use this command!");
                return true;
            }

            player.sendMessage(MessageUtil.format("{prefix}&eReloading plugin..."));
            Bukkit.getScheduler().runTask(plugin, () -> {
                Bukkit.getPluginManager().disablePlugin(plugin);
                Bukkit.getPluginManager().enablePlugin(plugin);

                if (plugin.isEnabled()) {
                    player.sendMessage(MessageUtil.format("{prefix}&6Successfully Reloaded! :D"));
                } else {
                    player.sendMessage(MessageUtil.format("{prefix}&cReload Failed! Check Console :("));
                }
            });

            return true;
        }

        // Delegate other subcommands
        CommandExecutor executor = subcommands.get(sub);
        if (executor == null) {
            player.sendMessage(MessageUtil.format("{prefix}&cUnknown subcommand. Try /guardx help"));
            return true;
        }

        String[] shiftedArgs = Arrays.copyOfRange(args, 1, args.length);
        return executor.onCommand(sender, command, sub, shiftedArgs);
    }

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            String input = args[0].toLowerCase();

            completions.add("reload");
            completions.addAll(subcommands.keySet());

            completions.removeIf(opt -> !opt.startsWith(input));
            return completions;
        }

        return Collections.emptyList();
    }
}
