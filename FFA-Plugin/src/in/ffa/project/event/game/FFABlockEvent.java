package in.ffa.project.event.game;

import in.ffa.project.FFA;
import in.ffa.project.util.BuildUtil;
import in.ffa.project.util.Util;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FFABlockEvent implements Listener {

    private FFA ffa = FFA.getPlugin(FFA.class);

    @EventHandler
    public void onFFABlockPlace(BlockPlaceEvent event) {

        Player player = event.getPlayer();
        if (BuildUtil.getBuilds().contains(player)) {
            return;
        }

        if (player.getLocation().getBlockY() > ffa.getConfig().getInt("world.blockPlace-MaxY")) {
            event.setCancelled(true);
            player.sendMessage(Util.getColor(FFA.getInstance().getPrefix() + "&f블럭 설치 최대 높이는 &a[" + Util.getBalance(ffa.getConfig().getInt("world.blockPlace-MaxY")) + "&am]&f입니다."));
        }

        new BukkitRunnable() {

            @Override
            public void run() {
                event.getBlockPlaced().setType(Material.AIR);
            }
        }.runTaskLater(ffa, 80L);

    }

    @EventHandler
    public void onFFABlockBreak(BlockBreakEvent event) {

        Player player = event.getPlayer();
        if (BuildUtil.getBuilds().contains(player)) {
            return;
        }
        event.setCancelled(true);

    }

}
