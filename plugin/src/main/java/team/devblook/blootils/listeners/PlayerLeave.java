package team.devblook.blootils.listeners;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerLeave implements Listener {

    public void onJoin(PlayerJoinEvent event){

        //TODO: create a new path to configure the leave message and motd when a player leaves the server
        Player player = event.getPlayer();

        event.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&8[&4-] &C"
                + player.getName() + " &fhas left the server."));
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 5);

    }
}
