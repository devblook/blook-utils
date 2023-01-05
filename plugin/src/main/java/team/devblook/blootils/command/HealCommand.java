package team.devblook.blootils.command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (!player.hasPermission("blootils.heal") || player.isOp()) {
                player.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
            } else {
                //TODO: create a new path config to configure the heal level
                player.setHealth(20);
                player.playSound(player.getLocation(), Sound.ENTITY_SPLASH_POTION_BREAK, 1, 1);
                player.sendMessage(ChatColor.GREEN + "You have healed");
            }
        }
        return true;
    }
}
