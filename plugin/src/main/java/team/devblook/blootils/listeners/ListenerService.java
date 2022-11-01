package team.devblook.blootils.listeners;

import org.bukkit.event.Listener;
import team.devblook.blootils.Blootils;
import team.devblook.blootils.api.Service;

import java.util.Arrays;

public class ListenerService implements Service {

    private final Blootils plugin;

    public ListenerService(Blootils plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
        for (Listener listener : Arrays.asList(
                new PlayerDeathListener(),
                new PlayerJoin(),
                new PlayerLeave(),
                new PlayerRegisterDataListener(plugin.getUsersData()),
                new SignInteractListener()
        )) {
            plugin.getServer().getPluginManager().registerEvents(listener, plugin);
        }

    }
}
