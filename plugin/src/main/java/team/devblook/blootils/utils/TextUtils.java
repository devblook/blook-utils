package team.devblook.blootils.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class TextUtils {

    public static String parseLegacyColors(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static List<String> parseLegacyColors(String... lines) {
        List<String> list = new ArrayList<>(List.of(lines));
        list.replaceAll(TextUtils::parseLegacyColors);
        return list;
    }

}
