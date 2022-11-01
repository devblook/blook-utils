package team.devblook.blootils.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        //TODO: create a new path to configure the join message and motd when a player joins to the server
        Player player = event.getPlayer();


        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&8[&3+] &b"
                + player.getName() + " &fhas joined to the server."));
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&m------------------" +
                "&8&m----------------"));
        player.sendMessage(ChatColor.WHITE + " ");
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "            &b&lBLOOK " +
                "&3&lUTILS"));
        player.sendMessage(ChatColor.WHITE + " ");
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "    &7&oWelcome to the" +
                " server " + player.getName()));
        player.sendMessage(ChatColor.WHITE + " ");
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8&m------------------" +
                "&8&m----------------"));
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 10);

    }
}
