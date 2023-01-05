package team.devblook.blootils.service;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import team.devblook.blootils.Blootils;
import team.devblook.blootils.api.Service;
import team.unnamed.inject.InjectAll;

import java.util.Set;

@InjectAll
public class ListenerService implements Service {
    private Blootils plugin;
    private Set<Listener> listeners;

    @Override
    public void start() {
        PluginManager pluginManager = plugin.getServer().getPluginManager();
        listeners.forEach(listener -> pluginManager.registerEvents(listener, plugin));

    }
}
