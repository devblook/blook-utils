package team.devblook.blootils.module;


import team.devblook.blootils.Blootils;
import team.unnamed.inject.AbstractModule;

import javax.inject.Inject;

import net.milkbowl.vault.economy.Economy;

public class EconomyModule extends AbstractModule {
    @Inject
    private Blootils plugin;
    private Economy economy;

    public EconomyModule(Economy economy) {
        this.economy = plugin.getServer().getServicesManager().getRegistration(Economy.class).getProvider();
    }

    @Override
    protected void configure() {
        bind(Economy.class).toInstance(economy);

    }
}



