package team.devblook.blootils;

import org.bukkit.plugin.java.JavaPlugin;
import team.devblook.blootils.api.Service;
import team.devblook.blootils.module.PluginModule;
import team.unnamed.inject.Injector;

import javax.inject.Inject;
import java.util.Set;

public class Blootils extends JavaPlugin {
    @Inject
    private Set<Service> services;

    @Override
    public void onLoad() {
        Injector injector = Injector.create(new PluginModule(this));
        injector.injectMembers(this);
    }

    @Override
    public void onEnable() {
        services.forEach(Service::start);
    }


    @Override
    public void onDisable() {
        services.forEach(Service::stop);
    }


}
