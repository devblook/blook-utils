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
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!p.hasPermission("blootils.feed")) {
                p.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
            }else{
                p.setFoodLevel(20);
                p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_BURP, 1, 1);
                p.sendMessage(ChatColor.GREEN + "You have fed");
            }
        }
        return true;
    }
}
