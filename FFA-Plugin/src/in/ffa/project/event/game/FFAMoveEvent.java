package in.ffa.project.event.game;

import in.ffa.project.FFA;
import in.ffa.project.util.Util;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.PlayerInventory;

public class FFAMoveEvent implements Listener {

    private FFA ffa = FFA.getPlugin(FFA.class);

    @EventHandler
    public void onFFAMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();

        if (player.getLocation().getY() <= ffa.getConfig().getInt("world.arenaY")) {
            if (player.getLocation().getY() >= (ffa.getConfig().getInt("world.arenaY") - 1)) {
                PlayerInventory i = player.getInventory();
                if (!(player.getInventory().contains(Material.DIAMOND_SWORD, 1)))
                    Util.sethand(player, 0, Util.getKit(1, false));
                if (i.getHelmet() == null)
                    Util.helmet(player, Util.getKit(2, true));
                if (i.getChestplate() == null)
                    Util.chestplate(player, Util.getKit(3, true));
                if (i.getLeggings() == null)
                    Util.leggings(player, Util.getKit(4, true));
                if (i.getBoots() == null)
                    Util.boots(player, Util.getKit(5, true));
            }
        }
    }

}
