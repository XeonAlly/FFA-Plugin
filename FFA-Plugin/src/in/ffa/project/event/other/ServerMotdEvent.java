package in.ffa.project.event.other;

import in.ffa.project.FFA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import static in.ffa.project.util.Util.*;

public class ServerMotdEvent implements Listener {

    private FFA ffa = FFA.getPlugin(FFA.class);

    @EventHandler
    public void onMotd(ServerListPingEvent event) {
        event.setMotd(getColor("&bTheFFA Club ┃ &f[1.8]\n&f▶ Added Personal FFA &b┃ &b&l:)"));
    }

}
