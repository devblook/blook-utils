package team.devblook.blootils.util;

import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;


public class PlayerView {
    public static void viewBlockActual(Player player, Integer line, String text) {
        Block block = player.getTargetBlockExact(5);


        Sign sign = (Sign) block.getState();
        String[] lines = sign.getLines();
        sign.setLine(line, text);
        sign.update();


    }

    public static void clearAll(Player p) {
        Block block = p.getTargetBlockExact(5);
        Sign sign = (Sign) block.getState();
        String[] lines = sign.getLines();
        sign.setLine(0, "");
        sign.setLine(1, "");
        sign.setLine(2, "");
        sign.setLine(3, "");
        sign.update();
    }

    public static String returnText(Player p, int line) {
        Block block = p.getTargetBlockExact(5);
        Sign sign = (Sign) block.getState();
        String text = sign.getLine(line);

        return text;
    }


}

