package team.devblook.blootils.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeave implements Listener {

    public void onJoin(PlayerQuitEvent event){

        //TODO: create a new path to configure the leave message and motd when a player leaves the server
        Player player = event.getPlayer();

         event.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4-] &C"
                + player.getName() + " &fhas left the server."));
        Bukkit.getOnlinePlayers().forEach(players -> players.playSound(players.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1));

    }
}
