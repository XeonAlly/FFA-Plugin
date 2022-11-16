package in.ffa.project.event.game;

import in.ffa.project.board.Leaderboard;
import in.ffa.project.shop.ui.UI;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import static in.ffa.project.util.Util.*;

public class FFANPCEvent implements Listener {

    @EventHandler
    public void onFFANPC(PlayerInteractEntityEvent event) {
        if (event.getRightClicked() instanceof Villager) {
            Player player = event.getPlayer();
            String name = event.getRightClicked().getName();
            if (name.contains("아이템 상점")) {
                new UI(player, getColor("&6&l아이템 상점"), 27).open("ITEM");
            }
            if (name.contains("게임 순위")) {
                new Leaderboard(player);
            }
        }
    }

}
