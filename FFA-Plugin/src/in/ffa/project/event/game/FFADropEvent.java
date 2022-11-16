package in.ffa.project.event.game;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class FFADropEvent implements Listener {

    @EventHandler
    public void onFFADrop(PlayerDropItemEvent event) {
        Material type = event.getItemDrop().getItemStack().getType();
        if (type == Material.IRON_SWORD
        || type == Material.DIAMOND_SWORD
        || type == Material.IRON_HELMET
        || type == Material.IRON_CHESTPLATE
        || type == Material.IRON_LEGGINGS
        || type == Material.IRON_BOOTS
        || type == Material.DIAMOND_CHESTPLATE) {
            event.setCancelled(true);
        }
    }

}
