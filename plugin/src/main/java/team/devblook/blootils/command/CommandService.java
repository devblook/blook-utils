package team.devblook.blootils.command;

import team.devblook.blootils.Blootils;
import team.devblook.blootils.api.Service;

public class CommandService implements Service {

    private final Blootils plugin;

    public CommandService(Blootils plugin) {
        this.plugin = plugin;
    }

    @Override
    public void start() {
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
