package team.devblook.blootils.listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import team.devblook.blootils.managers.SignManager;
import team.devblook.blootils.managers.signs.SignBalance;
import team.devblook.blootils.managers.signs.SignClear;
import team.devblook.blootils.managers.signs.SignRepair;

public class SignInteractListener implements Listener {

    @EventHandler
    private void onSignInteract(PlayerInteractEvent event) {
        if (event.getClickedBlock() == null) return;
        if (
                event.getClickedBlock().getType() != Material.ACACIA_SIGN
                        && event.getClickedBlock().getType() != Material.ACACIA_WALL_SIGN
        ) return;

        SignManager signBalance = new SignBalance((Sign) event.getClickedBlock().getState());
        signBalance.handleSign(event);
        SignManager singClear = new SignClear((Sign) event.getClickedBlock().getState());
        singClear.handleSign(event);
        SignManager signRepair = new SignRepair((Sign) event.getClickedBlock().getState());
        signRepair.handleSign(event);
        //SignManager signEnchant = new SignEnchant((Sign) e.getClickedBlock().getState());
        //signEnchant.handleSign(e);
    }
}
