package GuardX.Commands.Plugin;

import GuardX.Util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class helpCMD implements CommandExecutor {

    private static final int COMMANDS_PER_PAGE = 6;

    private static final List<CommandHelp> COMMAND_LIST = List.of(
            new CommandHelp("/guardx reload", "Main GuardX Command"),
            new CommandHelp("/gmc", "Change your mode to Creative"),
            new CommandHelp("/gms", "Change your mode to Survival"),
            new CommandHelp("/gma", "Change your mode to Adventure"),
            new CommandHelp("/gmsp", "Change your mode to Spectator"),
            new CommandHelp("/die", "Easy way to kill your player"),
            new CommandHelp("/god", "Easy way to God your player"),
            new CommandHelp("/heal", "Easy way to heal your player"),
            new CommandHelp("/feed", "Easy way to feed your player"),
            new CommandHelp("/day", "Change time to day"),
            new CommandHelp("/noon", "Change time to noon"),
            new CommandHelp("/night", "Change time to night"),
            new CommandHelp("/mnight", "Change time to midnight"),
            new CommandHelp("/sinfo", "Shows server info"),
            new CommandHelp("/allenchant", "Applies all enchantments to your item"),
            new CommandHelp("/verify <pin>", "Verify your GuardX PIN")
    );

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("§cOnly players can use this command.");
            return true;
        }

        int page = 1;

        if (args.length >= 1) {
            try {
                page = Integer.parseInt(args[0]);
            } catch (NumberFormatException ignored) {
                player.sendMessage(MessageUtil.format("{prefix}&cInvalid page number."));
                return true;
            }
        }

        int totalPages = (int) Math.ceil((double) COMMAND_LIST.size() / COMMANDS_PER_PAGE);
        if (page < 1 || page > totalPages) {
            player.sendMessage(MessageUtil.format("{prefix}&cPage must be between 1 and " + totalPages));
            return true;
        }

        player.sendMessage(MessageUtil.format("&8=== &6GuardX Help &7(Page " + page + " of " + totalPages + ") &8==="));

        int start = (page - 1) * COMMANDS_PER_PAGE;
        int end = Math.min(start + COMMANDS_PER_PAGE, COMMAND_LIST.size());

        for (int i = start; i < end; i++) {
            CommandHelp entry = COMMAND_LIST.get(i);
            player.sendMessage(MessageUtil.format("&e" + entry.command + " &7- &f" + entry.description));
        }

        player.sendMessage(MessageUtil.format("&7Use &e/guardx help <page> &7to navigate."));
        return true;
    }

    private static class CommandHelp {
        String command;
        String description;

        CommandHelp(String command, String description) {
            this.command = command;
            this.description = description;
        }
    }
}
