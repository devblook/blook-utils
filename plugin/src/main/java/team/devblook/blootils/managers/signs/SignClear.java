package team.devblook.blootils.managers.signs;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import team.devblook.blootils.Blootils;
import team.devblook.blootils.managers.SignManager;
import team.devblook.blootils.managers.TypeSign;
import team.devblook.blootils.utils.InventoryClear;

public class SignClear extends SignManager {
    public SignClear(Sign sign) {
        super(sign);
    }

    @Override
    public TypeSign typeSign() {
        return TypeSign.CLEAR;
    }

    @Override
    public int line() {
        return 1;
    }

    @Override
    public String text() {
        return "Clear";
    }

    @Override
    public String permission() {
        return "blootils.sign.clear";
    }

    @Override
    public void handleSign(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!player.isOp() || !player.hasPermission(permission())) return;
            Economy economy = Blootils.getEconomy();
            int cost = 100;
            if (economy.getBalance(player) >= cost) {
                InventoryClear.clearInventory(player);
                economy.withdrawPlayer(player, cost);
            } else {
                player.sendMessage(ChatColor.RED + "You do not have enough money to clear your inventory! " + ChatColor.GOLD + "You need " + (cost - economy.getBalance(player)));
            }



    }
}
