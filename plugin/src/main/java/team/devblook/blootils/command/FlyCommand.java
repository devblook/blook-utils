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
        if (sender instanceof Player player) {
            if (!player.hasPermission("blootils.fly")) {
                player.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
                player.playSound(player.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
                return true;
            }else{
                if (!player.getAllowFlight()) {
                    player.setAllowFlight(true);
                    player.sendMessage(ChatColor.GREEN + "Fly Enabled.");
                    player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1, 1);

                }
                else if (player.getAllowFlight()) {
                    player.setAllowFlight(false);
                    player.sendMessage(ChatColor.RED + "Fly Disabled.");
                    player.playSound(player.getLocation(), Sound.BLOCK_LEVER_CLICK, 1, 1);
                    return true;
                }
                }
            }
        return false;
    }
}
