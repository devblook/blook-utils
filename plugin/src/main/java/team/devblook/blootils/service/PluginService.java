package team.devblook.blootils.service;

import org.bukkit.plugin.java.JavaPlugin;
import team.devblook.blootils.api.Service;

public class PluginService implements Service {

    private JavaPlugin plugin;

    public PluginService(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        plugin.onEnable();
    }

    @Override
    public void stop() {
        plugin.onDisable();
    }

}
