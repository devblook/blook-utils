package team.devblook.blootils.listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import team.devblook.blootils.managers.signs.SignBalance;
import team.devblook.blootils.managers.signs.SignClear;
import team.devblook.blootils.managers.signs.SignItem;
import team.devblook.blootils.managers.signs.SignRepair;

public class SignInteractListener implements Listener {

    @EventHandler
    private void onSignInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;
        if (
                event.getClickedBlock().getType() != Material.ACACIA_SIGN
                        && event.getClickedBlock().getType() != Material.ACACIA_WALL_SIGN
        ) return;
        Sign sign = (Sign) event.getClickedBlock().getState();
        String line = sign.getLine(1).toLowerCase();
        switch (line) {
            case "balance":
                new SignBalance((Sign) event.getClickedBlock().getState()).handleSign(event);
                break;
            case "clear":
                new SignClear((Sign) event.getClickedBlock().getState()).handleSign(event);
                break;
            case "repair":
                new SignRepair((Sign) event.getClickedBlock().getState()).handleSign(event);
                break;
            case "item":
                new SignItem((Sign) event.getClickedBlock().getState()).handleSign(event);
                break;
            default:
                break;
        }

    }
}
