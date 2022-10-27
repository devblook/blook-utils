package team.devblook.blootils.managers.signs;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import team.devblook.blootils.Blootils;
import team.devblook.blootils.managers.SignManager;
import team.devblook.blootils.utils.InventoryClear;

public class SignRepair extends SignManager {
    public SignRepair(Sign sign) {
        super(sign);
    }

    @Override
    public String typeSign() {
        return "Repair";
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
    public void handleSign(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Block block = e.getClickedBlock();
        if (player.isOp() || player.hasPermission(permission())) {
            if (block == null) return;
            if (block.getType() == Material.ACACIA_SIGN || block.getType() == Material.ACACIA_WALL_SIGN) {
                Sign finalSign = (Sign) block.getState();
                String lineStrip = finalSign.getLine(line());
                if (lineStrip.equalsIgnoreCase(text())) {
                    Economy economy = Blootils.getEcon();
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
        }
    }
}
