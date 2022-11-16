package in.ffa.project.util;

import org.bukkit.ChatColor;

public interface Utils {

    default String getColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

}
