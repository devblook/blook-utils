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
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (!p.hasPermission("blootils.fly")) {
                p.sendMessage(ChatColor.RED + "You don't have the enough permissions to access this command.");
                p.playSound(p.getLocation(), Sound.ENTITY_ITEM_BREAK, 1, 1);
                return true;
            }else{
                if (p.getAllowFlight() == true) {
                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.RED + "Fly disabled.");
                    p.playSound(p.getLocation(), Sound.BLOCK_LEVER_CLICK, 1, 1);
                    return true;
                }
                if(p.getAllowFlight() == false) {
                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.GREEN + "Fly enabled.");
                    p.playSound(p.getLocation(), Sound.BLOCK_LEVER_CLICK, 1, 1);
                    return true;
                    }
                }
            }
        return false;
    }
}
