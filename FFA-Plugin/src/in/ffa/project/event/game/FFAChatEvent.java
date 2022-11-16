package in.ffa.project.event.game;

import in.ffa.project.FFA;
import in.ffa.project.user.User;
import in.ffa.project.util.Util;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class FFAChatEvent implements Listener {

    private FFA ffa = FFA.getPlugin(FFA.class);

    @EventHandler
    public void onFFAChat(PlayerChatEvent event) {
        Player player = event.getPlayer();

        boolean enabled = ffa.getConfig().getBoolean("chat.enabled");
        String format = ffa.getConfig().getString("chat.format").replace("%LEVEL%", Util.getLevel(new User(player).getLevel())).replace("%PLAYER-NAME%", player.getName()).replace("%MESSAGE%", event.getMessage()).replace("%PREFIX% ", new User(player).getPrefix()).replace("_", " ");

        if (enabled)
            event.setFormat(Util.getColor(format));
    }

}
