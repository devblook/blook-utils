package team.devblook.blootils;

import org.bukkit.plugin.java.JavaPlugin;
import team.devblook.blootils.managers.UsersData;

public class Blootils extends JavaPlugin {


    private UsersData usersData;

    @Override
    public void onEnable() {
        this.usersData = new UsersData();
        // Plugin startup logic
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public UsersData getUsersData() {
        return usersData;
    }
}
