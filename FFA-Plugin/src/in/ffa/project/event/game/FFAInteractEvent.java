package in.ffa.project.event.game;

import in.ffa.project.ui.UI;
import in.ffa.project.util.FileScript;
import in.ffa.project.util.Item;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static in.ffa.project.util.Util.*;

public class FFAInteractEvent implements Listener {

    @EventHandler
    public void onFFAInteract(PlayerInteractEvent event) {
        try {
            Block b = event.getClickedBlock();
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK && b.getType() == Material.ANVIL) {
                for (File f : new FileScript("boxes").listFiles()) {
                    if (b.getLocation().getBlockX() == new FileScript("boxes/" + f.getName()).getLocation().getBlockX()
                    || b.getLocation().getBlockY() == new FileScript("boxes/" + f.getName()).getLocation().getBlockY()
                    || b.getLocation().getBlockZ() == new FileScript("boxes/" + f.getName()).getLocation().getBlockZ()) {
                        event.setCancelled(true);
                        new UI(event.getPlayer(), "&e&l[ &f랜덤상자 열기 &e&l]", 27).setItem(14, new Item().getItem(Material.CHEST, 1, "", new ArrayList<>(Arrays.asList(
                                getColor("&1"),
                                getColor("&f등급: "),
                                getColor("&f보상: &6" + getBalance((int) new FileScript("boxes/" + f.getName()).get("box.reward.min")) + " &f~ &6" + getBalance((int) new FileScript("boxes/" + f.getName()).get("box.reward.max"))),
                                getColor("&2"),
                                getColor("&e&l")
                        ))));
                    }
                }
            }
        } catch (Exception e) {return;}
    }

}
