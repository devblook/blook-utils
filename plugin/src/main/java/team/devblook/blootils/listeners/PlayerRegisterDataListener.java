package team.devblook.blootils.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import team.devblook.blootils.api.User;
import team.devblook.blootils.managers.UsersData;

public class PlayerRegisterDataListener implements Listener{

    private final UsersData usersData;

    public PlayerRegisterDataListener(UsersData usersData) {
        this.usersData = usersData;
    }

    @EventHandler
    private void onPlayerRegisterData(PlayerJoinEvent event) {
        usersData.addUser(new User(event.getPlayer().getUniqueId()));
        usersData.getUser(event.getPlayer().getUniqueId());
    }

}
