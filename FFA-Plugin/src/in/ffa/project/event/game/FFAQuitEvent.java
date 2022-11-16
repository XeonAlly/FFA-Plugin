package in.ffa.project.event.game;

import in.ffa.project.FFA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class FFAQuitEvent implements Listener {

    private FFA ffa = FFA.getPlugin(FFA.class);

    @EventHandler
    public void onFFAQuit(PlayerQuitEvent event) {
        event.setQuitMessage("");
    }

}
