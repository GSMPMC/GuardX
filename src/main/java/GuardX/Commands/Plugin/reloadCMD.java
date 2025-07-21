package GuardX.Commands.Plugin;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class reloadCMD implements CommandExecutor, TabCompleter {

    private final JavaPlugin plugin;

    public reloadCMD(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("guardx.reload")) {
            sender.sendMessage("§8[§5GuardX§8] §cYou don't have permission to use this command!");
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            sender.sendMessage("§8[§5GuardX§8] §6Reloading plugin...");

            Bukkit.getScheduler().runTask(plugin, () -> {
                Bukkit.getPluginManager().disablePlugin(plugin);
                Bukkit.getPluginManager().enablePlugin(plugin);

                if (plugin.isEnabled()) {
                    sender.sendMessage("§8[§5GuardX§8] §aSuccessfully reloaded.");
                } else {
                    sender.sendMessage("§8[§5GuardX§8] §cReload failed. Check console for errors.");
                }
            });

            return true;
        }

        sender.sendMessage("§8[§5GuardX§8] §eUsage: /guardx reload");
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            List<String> subcommands = new ArrayList<>();

            if (sender.hasPermission("guardx.reload")) {
                subcommands.add("reload");
            }

            String input = args[0].toLowerCase();
            subcommands.removeIf(sub -> !sub.startsWith(input));

            return subcommands;
        }

        return Collections.emptyList();
    }
}
