package team.devblook.blootils.module;

import team.devblook.blootils.Blootils;
import team.devblook.blootils.api.Service;
import team.devblook.blootils.service.CommandService;
import team.devblook.blootils.service.EconomyService;
import team.devblook.blootils.service.ListenerService;
import team.devblook.blootils.service.PluginService;
import team.unnamed.inject.AbstractModule;

public class PluginModule extends AbstractModule {
    private final Blootils plugin;

    public PluginModule(Blootils plugin) {
        this.plugin = plugin;
    }

    @Override
    protected void configure() {
        bind(Blootils.class).toInstance(plugin);
        multibind(Service.class).asSet().
                to(ListenerService.class)
                .to(CommandService.class)
                .to(EconomyService.class)
                .to(PluginService.class);
        install(new ListenerModule());
    }
}
