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

public class SignBalance extends SignManager {

    public SignBalance(Sign sign) {
        super(sign);
    }

    @Override
    public String typeSign() {
        return "Balance";
    }

    @Override
    public int line() {
        return 1;
    }

    @Override
    public String text() {
        return "Balance";
    }

    @Override
    public String permission() {
        return "blootils.sign.balance";
    }

    @Override
    public void handleSign(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (!player.isOp() || !player.hasPermission(permission())) {
            return;
        }
        if (block == null) return;
        if (block.getType() != Material.ACACIA_SIGN || block.getType() != Material.ACACIA_WALL_SIGN) return;

        Sign finalSign = (Sign) block.getState();
        String lineStrip = finalSign.getLine(line());
        lineStrip = ChatColor.stripColor(lineStrip);
        if (lineStrip.equalsIgnoreCase(text())) {
            Economy economy = Blootils.getEconomy();
            double balance = economy.getBalance(player);
            player.sendMessage(ChatColor.GREEN + "Your balance is: " + ChatColor.GOLD + balance);
        }
    }
}

