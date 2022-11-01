package team.devblook.blootils.listeners;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

import static team.devblook.blootils.utils.TextUtils.parseLegacyColors;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        //TODO: create a new path to configure the join message and motd when a player joins to the server
        Player player = event.getPlayer();

        event.setJoinMessage(parseLegacyColors("&8[&3+] &b" + player.getName() + " &fhas joined to the server."));

        List<String> welcomeMessage = parseLegacyColors(
                "&8&m----------------------------------",
                "",
                "            &b&lBLOOK &3&lUTILS",
                "    &7&oWelcome to the server " + player.getName(),
                "",
                "&8&m-----------------------------"
        );

        welcomeMessage.forEach(player::sendMessage);
        player.playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 10, 10);

    }
}
