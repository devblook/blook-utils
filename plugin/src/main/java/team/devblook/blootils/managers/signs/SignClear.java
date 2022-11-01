package team.devblook.blootils.managers.signs;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import team.devblook.blootils.Blootils;
import team.devblook.blootils.managers.SignManager;
import team.devblook.blootils.utils.InventoryClear;

public class SignClear extends SignManager {
    public SignClear(Sign sign) {
        super(sign);
    }

    @Override
    public String typeSign() {
        return "Clear";
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
    public void handleSign(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (player.isOp() || player.hasPermission(permission())) {
            if (block == null) return;
            if (block.getType() == Material.ACACIA_SIGN || block.getType() == Material.ACACIA_WALL_SIGN) {
                Sign finalSign = (Sign) block.getState();
                if (finalSign.getLine(line()).equalsIgnoreCase(text())) {
                    Economy economy = Blootils.getEconomy();
                    int cost = 100;
                    if (economy.getBalance(player) >= cost) {
                        InventoryClear.clearInventory(player);
                        economy.withdrawPlayer(player, cost);
                        player.sendMessage(ChatColor.GREEN + "Your inventory has been cleared for " + ChatColor.GOLD + cost + ChatColor.GREEN + "!");
                    } else {
                        player.sendMessage(ChatColor.RED + "You do not have enough money to clear your inventory!" + ChatColor.GOLD + "You need" + (cost - economy.getBalance(player)));
                    }



                }



            }
        }
    }
}
