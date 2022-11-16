package in.ffa.project.util;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;

import static in.ffa.project.util.Util.*;

public class RandomBox {

    public static void spawnHologram(Location location) {
        location.getBlock().setType(Material.ANVIL);
        ArmorStand as = (ArmorStand) location.getWorld().spawnEntity(location.subtract(0, 1.1, 0), EntityType.ARMOR_STAND);
        as.setGravity(false);
        as.setCanPickupItems(false);
        as.setCustomName(getColor("&e&l[ &f랜덤 상자 &e&l]"));
        as.setCustomNameVisible(true);
        as.setVisible(false);

        FileScript fileScript = new FileScript("boxes/" + location.getX() + location.getY() + location.getZ() + ".yml");
        fileScript.set("box.location", location);
        fileScript.set("box.rank", "일반");
        fileScript.set("box.reward.min", 0);
        fileScript.set("box.reward.max", 1000);
        fileScript.Save();
    }

}
