package team.devblook.blootils.managers.signs;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import team.devblook.blootils.Blootils;
import team.devblook.blootils.managers.SignManager;
import team.devblook.blootils.managers.TypeSign;


public class SignBalance extends SignManager {

    public SignBalance(Sign sign) {
        super(sign);
    }

    @Override
    public TypeSign typeSign() {
        return TypeSign.BALANCE;
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
        if (!player.isOp() || !player.hasPermission(permission())) return;
            Economy economy = Blootils.getEconomy();
            double balance = economy.getBalance(player);
            player.sendMessage(ChatColor.GREEN + "Your balance is: " + ChatColor.GOLD + balance);


    }
}