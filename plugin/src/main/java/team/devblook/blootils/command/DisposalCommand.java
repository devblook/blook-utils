package team.devblook.blootils.command;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class DisposalCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (!player.hasPermission("blootils.disposal") || player.isOp()) {
                Inventory inv = Bukkit.createInventory(null, 9, ChatColor.DARK_GRAY + "Disposal");
                player.openInventory(inv);
                player.sendMessage(ChatColor.GREEN + "Opening disposal...");
                player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1, 1);
                return true;
            } else {
                player.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1, 1);
                return true;
            }
        }
        return false;
    }
}
