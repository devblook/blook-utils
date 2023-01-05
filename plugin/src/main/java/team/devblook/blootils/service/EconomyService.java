package team.devblook.blootils.service;

import team.devblook.blootils.Blootils;
import team.devblook.blootils.api.Service;

import javax.inject.Inject;

public class EconomyService implements Service {
    @Inject
    private Blootils plugin;

    @Override
    public void start() {
        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            plugin.getLogger().info("Vault not found, disabling economy features");
            return;
        }

    }
}
