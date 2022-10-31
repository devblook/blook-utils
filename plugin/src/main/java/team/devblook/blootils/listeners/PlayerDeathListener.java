package team.devblook.blootils.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent event){

        Player player = event.getEntity();

        if(event.getEntity().getPlayer().isDead()){
            event.setDeathMessage(ChatColor.RED + player.getName() + ChatColor.GRAY + "has died");

            }
        }
    }