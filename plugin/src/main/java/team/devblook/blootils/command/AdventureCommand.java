package team.devblook.blootils.command;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AdventureCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (!player.hasPermission("blootils.command.adventure") || !player.isOp()) {
                player.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
                return true;
            } else {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(ChatColor.GRAY + "Gamemode set to " + ChatColor.BLUE + "adventure"
                        + ChatColor.GRAY + ".");
                player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1, 1);
                return true;
            }
        }
        return false;
    }
}
