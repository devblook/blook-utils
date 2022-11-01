package team.devblook.blootils.managers.signs;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import team.devblook.blootils.managers.SignManager;
import team.devblook.blootils.managers.TypeSign;

public class SignRepair extends SignManager {
    public SignRepair(Sign sign) {
        super(sign);
    }

    @Override
    public TypeSign typeSign() {
        return TypeSign.REPAIR;
    }

    @Override
    public int line() {
        return 1;
    }


    @Override
    public String text() {
        return "Repair";
    }

    @Override
    public String permission() {
        return "blootils.sign.repair";
    }

    @Override
    public void handleSign(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (!player.isOp() || !player.hasPermission(permission())) return;
            ItemStack item = player.getInventory().getItemInMainHand();
            if (item.getType() == Material.AIR) {
                player.sendMessage(ChatColor.RED + "You must be holding an item to repair!");
                return;
            }
            ItemMeta meta = item.getItemMeta();
            Damageable damageable = (Damageable) meta;
            int damage = damageable.getDamage();
            if (damage == 0) {
                player.sendMessage(ChatColor.RED + "This item is not damaged!");
                return;
            }
            damageable.setDamage(0);
            item.setItemMeta((ItemMeta) damageable);
            player.sendMessage(ChatColor.GREEN + "Your item has been repaired!");



    }
}