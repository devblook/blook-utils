package team.devblook.blootils;

import org.bukkit.plugin.java.JavaPlugin;
import team.devblook.blootils.command.*;

import team.devblook.blootils.managers.UsersData;

public class Blootils extends JavaPlugin {


    private UsersData usersData;

    @Override
    public void onEnable() {

        this.usersData = new UsersData();
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("feed").setExecutor(new FeedCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("sign").setExecutor(new SignCommand());

    }

    @Override
    public void onDisable() {

    }

    public UsersData getUsersData() {
        return usersData;
    }
}
