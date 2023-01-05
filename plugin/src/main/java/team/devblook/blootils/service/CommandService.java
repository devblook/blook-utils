package team.devblook.blootils.service;

import team.devblook.blootils.Blootils;
import team.devblook.blootils.api.Service;
import team.devblook.blootils.command.AdventureCommand;
import team.devblook.blootils.command.FeedCommand;
import team.devblook.blootils.command.FlyCommand;
import team.devblook.blootils.command.HealCommand;
import team.devblook.blootils.command.CreativeCommand;
import team.devblook.blootils.command.SurvivalCommand;
import team.devblook.blootils.command.SpectatorCommand;
import team.devblook.blootils.command.SignCommand;
import team.devblook.blootils.command.DisposalCommand;
import team.devblook.blootils.command.EnderChestCommand;

import javax.inject.Inject;

public class CommandService implements Service {
    @Inject
    private Blootils plugin;

    @Override
    public void start() {
        //here register commands
        plugin.getCommand("fly").setExecutor(new FlyCommand());
        plugin.getCommand("heal").setExecutor(new HealCommand());
        plugin.getCommand("feed").setExecutor(new FeedCommand());
        plugin.getCommand("gma").setExecutor(new AdventureCommand());
        plugin.getCommand("gmc").setExecutor(new CreativeCommand());
        plugin.getCommand("gms").setExecutor(new SurvivalCommand());
        plugin.getCommand("gmsp").setExecutor(new SpectatorCommand());
        plugin.getCommand("sign").setExecutor(new SignCommand());
        plugin.getCommand("disposal").setExecutor(new DisposalCommand());
        plugin.getCommand("enderchest").setExecutor(new EnderChestCommand());
    }
}
