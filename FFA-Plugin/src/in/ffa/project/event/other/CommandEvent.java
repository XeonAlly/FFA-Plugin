package in.ffa.project.event.other;

import in.ffa.project.FFA;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import static in.ffa.project.util.Util.*;

public class CommandEvent implements Listener {

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event) {
        if (event.getMessage().contains("plugins")
        || event.getMessage().contains("pl")
        || event.getMessage().contains("bukkit:plugins")
        || event.getMessage().contains("bukkit:pl")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(getColor(FFA.getInstance().getPrefix() + "&a[" + event.getMessage().replace("/", "") + "&a] &f명령어는 사용 금지된 명령어입니다."));
        }
    }

}
