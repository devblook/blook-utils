package team.devblook.blootils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import team.devblook.blootils.command.*;

import team.devblook.blootils.listeners.InteractListener;
import team.devblook.blootils.managers.UsersData;
public class Blootils extends JavaPlugin {
    private static Economy econ = null;
    private static Blootils instance;
    private UsersData usersData;

    @Override
    public void onEnable() {
        instance = this;
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.usersData = new UsersData();
        this.getCommand("fly").setExecutor(new FlyCommand());
        this.getCommand("feed").setExecutor(new FeedCommand());
        this.getCommand("heal").setExecutor(new HealCommand());
        this.getCommand("sign").setExecutor(new SignCommand());
        this.getServer().getPluginManager().registerEvents(new InteractListener(),this);



    }


    public static Blootils getInstance() {
        return instance;
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    @Override
    public void onDisable() {

    }

    public static Economy getEcon() {
        return econ;
    }

    public UsersData getUsersData() {
        return usersData;
    }
}
