package team.devblook.blootils.command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player player)) {
            return true;
        }

        if (!player.hasPermission("blootils.fly") || player.isOp()) {
            player.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
            player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
            return true;
        }

        if (!player.getAllowFlight() || !player.isFlying()) {
            player.setAllowFlight(true);
            player.setFlying(true);
            player.sendMessage(ChatColor.GREEN + "Fly enabled.");
            player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1, 1);
            return true;
        }

        player.setAllowFlight(false);
        player.setFlying(false);
        player.sendMessage(ChatColor.RED + "Fly disabled.");
        player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1, 1);
        return true;
    }
}
