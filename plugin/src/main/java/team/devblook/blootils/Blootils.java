package team.devblook.blootils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import team.devblook.blootils.api.Service;
import team.devblook.blootils.command.*;

import team.devblook.blootils.listeners.*;
import team.devblook.blootils.managers.UsersData;

import java.util.Arrays;

public class Blootils extends JavaPlugin {
    private static Economy economy = null;
    private static Blootils instance;
    private UsersData usersData;

    private CommandService commandService = new CommandService(this);
    private ListenerService listenerService = new ListenerService(this);

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();

        instance = this;
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        this.usersData = new UsersData();

        for (Service service : Arrays.asList(commandService, listenerService)) {
            service.start();
        }
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
        economy = rsp.getProvider();
        return economy != null;
    }



    @Override
    public void onDisable() {
        for (Service service : Arrays.asList(commandService, listenerService)) {
            service.stop();
        }
    }

    public static Economy getEconomy() {
        return economy;
    }

    public UsersData getUsersData() {
        return usersData;
    }
}
