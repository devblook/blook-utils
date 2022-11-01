package team.devblook.blootils.command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class EnderChestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (!player.hasPermission("blootils.enderchest") || player.isOp()) {
                player.sendMessage(ChatColor.GREEN + "Opening Enderchest...");
                player.openInventory(player.getEnderChest());
                player.playSound(player.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 1, 1);
                return true;
            }else{
                player.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
                player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1,1);
                return true;
            }
        }
        return false;
    }
}
