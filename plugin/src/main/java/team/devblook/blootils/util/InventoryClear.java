package team.devblook.blootils.util;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InventoryClear {

    public static void clearInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 54, "Clear Inventory");
        player.openInventory(inventory);
    }

}

