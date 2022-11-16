package in.ffa.project.event.game;

import in.ffa.project.FFA;
import in.ffa.project.user.User;
import in.ffa.project.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class FFADeathEvent implements Listener {

    private FFA ffa = FFA.getPlugin(FFA.class);

    @EventHandler
    public void onFFADeath(PlayerDeathEvent event) {
        if (event.getEntity().getPlayer() instanceof Player) {
            if (event.getDeathMessage().contains("fell out") && event.getEntity().getKiller() == null) {
                new User(event.getEntity().getPlayer()).setDeaths(new User(event.getEntity().getPlayer()).getDeaths() + 1);
                event.setDeathMessage(Util.getColor(FFA.getInstance().getPrefix() + "&8➜ &a[" + event.getEntity().getPlayer().getName() + "&a]&f이(가) 사망했습니다."));
            } else if (event.getDeathMessage().contains("slain by") && event.getEntity().getKiller() != null) {
                if (event.getEntity().getKiller() instanceof Player) {
                    event.getEntity().getKiller().setHealth(20);

                    new User(event.getEntity().getKiller()).setMinExperience(new User(event.getEntity().getKiller()).getMinExperience() + 5);
                    new User(event.getEntity().getKiller()).setPoints(new User(event.getEntity().getKiller()).getPoints() + Util.getRandomInRange(50, 200));
                    new User(event.getEntity().getKiller()).setKills(new User(event.getEntity().getKiller()).getKills() + 1);

                    new User(event.getEntity().getPlayer()).setDeaths(new User(event.getEntity().getPlayer()).getDeaths() + 1);
                    event.setDeathMessage(Util.getColor(FFA.getInstance().getPrefix() + "&8➜ &a[" + event.getEntity().getPlayer().getName() + "&a]&f이(가) &a[" + event.getEntity().getKiller().getName() + "&a]&f에 의해 살해당했습니다."));
                }
            } else {
                event.setDeathMessage("");
            }
        }
        Util.respawn(event.getEntity().getPlayer());
        Util.clear(event.getEntity().getPlayer());
        event.getEntity().getPlayer().teleport(new Location(Bukkit.getWorld(ffa.getConfig().getString("world.location.spawn.world")),
                ffa.getConfig().getInt("world.location.spawn.x"), ffa.getConfig().getInt("world.location.spawn.y"), ffa.getConfig().getInt("world.location.spawn.z"),
                ffa.getConfig().getInt("world.location.spawn.yaw"), ffa.getConfig().getInt("world.location.spawn.pitch")));
    }

}
