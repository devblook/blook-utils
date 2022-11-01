package team.devblook.blootils.managers;


import org.bukkit.block.Sign;
import org.bukkit.event.player.PlayerInteractEvent;

public abstract class SignManager{
    protected Sign sign;

    public SignManager(Sign sign) {
        this.sign = sign;
    }

    public abstract String typeSign();
    public abstract int line();
    public abstract String text();
    public abstract String permission();
    public abstract void handleSign(PlayerInteractEvent e);



}
