package team.devblook.blootils;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import team.devblook.blootils.command.*;

import team.devblook.blootils.listeners.SignInteractListener;
import team.devblook.blootils.listeners.PlayerDeathListener;
import team.devblook.blootils.listeners.PlayerJoin;
import team.devblook.blootils.listeners.PlayerLeave;
import team.devblook.blootils.managers.UsersData;

import java.util.Objects;

public class Blootils extends JavaPlugin {
    private static Economy economy = null;
    private static Blootils instance;
    private UsersData usersData;

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

        setupCommand("fly", new FlyCommand());
        setupCommand("heal", new HealCommand());
        setupCommand("feed", new FeedCommand());
        setupCommand("gma", new AdventureCommand());
        setupCommand("gmc", new CreativeCommand());
        setupCommand("gms", new SurvivalCommand());
        setupCommand("gmsp", new SpectatorCommand());
        setupCommand("sign", new SignCommand());
        setupCommand("disposal", new DisposalCommand());
        setupCommand("enderchest", new EnderChestCommand());

        setupListeners(
                new SignInteractListener(),
                new PlayerDeathListener(),
                new PlayerJoin(),
                new PlayerLeave()
        );
    }


    private void setupCommand(String name, CommandExecutor commandExecutor) {
        if (getCommand(name) != null) {
            Objects.requireNonNull(getCommand(name)).setExecutor(commandExecutor);
        }
    }

    private void setupListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
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

    }

    public static Economy getEconomy() {
        return economy;
    }

    public UsersData getUsersData() {
        return usersData;
    }
}
