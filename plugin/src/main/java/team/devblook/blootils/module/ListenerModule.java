package team.devblook.blootils.module;

import team.devblook.blootils.listener.PlayerDeathListener;
import team.devblook.blootils.listener.PlayerJoinListener;
import team.devblook.blootils.listener.PlayerLeaveListener;
import team.unnamed.inject.AbstractModule;
import org.bukkit.event.Listener;

import javax.inject.Singleton;

@Singleton
public class ListenerModule extends AbstractModule {

    @Override
    protected void configure() {
        //here register your listeners
        multibind(Listener.class).asSet()
                .to(PlayerDeathListener.class)
                .to(PlayerJoinListener.class)
                .to(PlayerLeaveListener.class);
    }
}
