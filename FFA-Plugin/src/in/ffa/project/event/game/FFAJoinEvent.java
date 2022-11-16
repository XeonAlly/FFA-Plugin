package in.ffa.project.event.game;

import in.ffa.project.FFA;
import in.ffa.project.board.Board;
import in.ffa.project.user.User;
import in.ffa.project.util.TitleUtil;
import in.ffa.project.util.Util;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class FFAJoinEvent implements Listener {

    private FFA ffa = FFA.getPlugin(FFA.class);

    @EventHandler
    public void onFFAJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        event.setJoinMessage("");

        new User(player).createPlayer();

        Util.clear(player);
        player.teleport(new Location(Bukkit.getWorld(ffa.getConfig().getString("world.location.spawn.world")),
                ffa.getConfig().getInt("world.location.spawn.x"), ffa.getConfig().getInt("world.location.spawn.y"), ffa.getConfig().getInt("world.location.spawn.z"),
                ffa.getConfig().getInt("world.location.spawn.yaw"), ffa.getConfig().getInt("world.location.spawn.pitch")));

        /**ffa.getServer().getScheduler().runTaskTimer(ffa, new BukkitRunnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() <= 0) return;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    new Board(player).create();
                }
            }
        }, 0, 10L);

        ffa.getServer().getScheduler().runTaskTimer(ffa, new BukkitRunnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() <= 0) return;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (user.getMinExperience() >= user.getMaxExperience()) {
                        int level = user.getLevel();
                        int next_level = user.getLevel() + 1;

                        int exp = user.getMaxExperience();
                        new User(player).setLevel(new User(player).getLevel() + 1);
                        new User(player).setMinExperience(0);
                        new User(player).setMaxExperience(user.getLevel() * 10);
                        int next_exp = user.getLevel() * 10;

                        if (ffa.getConfig().getBoolean("levelup.sound.enabled")) {
                            player.getWorld().playSound(player.getLocation(), Sound.valueOf(ffa.getConfig().getString("levelup.sound.type")), 1, 2);
                        }
                        if (ffa.getConfig().getBoolean("levelup.message")) {
                            String message = FFA.getInstance().getPrefix() + "&f성공적으로 레벨업하셨습니다.";
                            String textcom = "&7레벨: &r" + Util.getLevel(level) + " &7-> &r" + Util.getLevel(next_level) + "\n&7경험치: &a" + Util.getBalance(exp) + " &7-> &a" + Util.getBalance(next_exp);

                            TextComponent textComponent = new TextComponent(Util.getColor(message));
                            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder((Util.getColor(textcom))).create()));

                            player.spigot().sendMessage(textComponent);
                        }
                    }
                }
            }
        }, 0, 20L);**/
    }

}
