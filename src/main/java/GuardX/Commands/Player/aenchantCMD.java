package GuardX.Commands.Player;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

public class aenchantCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String @NotNull [] strings){
        if (!(sender instanceof Player)){
            sender.sendMessage("Player can only run this command!");
            return true;
        }

        Player p = (Player) sender;

        if (!p.hasPermission("guardx.admin.cmd.allenchant")){
            p.sendMessage("§cAccess Denied - Insufficient Permission");
            return true;
        }

        ItemStack item = p.getInventory().getItemInMainHand();

        if (item == null || item.getType().isAir()){
            p.sendMessage("§cYou must be holding an item to enchant it!");
            return true;
        }

        for (Enchantment ench : Enchantment.values()){
            if (ench != null && ench.canEnchantItem(item)){
                item.addUnsafeEnchantment(ench, 255);
            }
        }

        p.sendMessage("§aAll Enchaments has been applied to your item!");
        return true;
    }
}
