package team.devblook.blootils.command;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (!player.hasPermission("blootils.feed") || player.isOp()) {
                player.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
                return true;
            }
            //TODO: generate path in config for foodlevel
            player.setFoodLevel(20);
            player.playSound(player.getLocation(), Sound.ENTITY_PLAYER_BURP, 1, 1);
            player.sendMessage(ChatColor.GREEN + "You have fed");
        }
        return true;
    }
}


