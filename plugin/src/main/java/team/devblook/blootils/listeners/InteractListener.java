package team.devblook.blootils.listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import team.devblook.blootils.managers.SignManager;
import team.devblook.blootils.managers.signs.SignBalance;
import team.devblook.blootils.managers.signs.SignClear;
import team.devblook.blootils.managers.signs.SignEnchant;
import team.devblook.blootils.managers.signs.SignRepair;

public class InteractListener implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        if (e.getClickedBlock() == null) return;
        if (e.getClickedBlock().getType()!= Material.ACACIA_SIGN && e.getClickedBlock().getType()!= Material.ACACIA_WALL_SIGN) return;
    SignManager signBalance = new SignBalance((Sign) e.getClickedBlock().getState());
    signBalance.handleSign(e);
    SignManager singClear = new SignClear((Sign) e.getClickedBlock().getState());
    singClear.handleSign(e);
    SignManager signRepair = new SignRepair((Sign) e.getClickedBlock().getState());
    signRepair.handleSign(e);
    SignManager signEnchant = new SignEnchant((Sign) e.getClickedBlock().getState());
    signEnchant.handleSign(e);







    }
}
