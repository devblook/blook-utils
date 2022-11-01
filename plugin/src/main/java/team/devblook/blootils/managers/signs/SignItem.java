package team.devblook.blootils.managers.signs;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import team.devblook.blootils.managers.SignManager;
import team.devblook.blootils.managers.TypeSign;

public class SignItem extends SignManager {
    public SignItem(Sign sign) {
        super(sign);
    }

    @Override
    public TypeSign typeSign() {
        return TypeSign.ITEM;
    }

    @Override
    public int line() {
        return 1;
    }

    @Override
    public String text() {
        return "Item";
    }

    @Override
    public String permission() {
        return "blootils.sign.item";
    }

    @Override
    public void handleSign(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!player.isOp() || !player.hasPermission(permission())) return;
        player.sendMessage("Item");

    }
}
