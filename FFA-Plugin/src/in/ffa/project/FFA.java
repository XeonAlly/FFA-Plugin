package in.ffa.project;

import in.ffa.project.board.Board;
import in.ffa.project.command.CommandManager;
import in.ffa.project.event.game.*;
import in.ffa.project.event.other.CommandEvent;
import in.ffa.project.event.other.ServerMotdEvent;
import in.ffa.project.killeffect.EffectInventory;
import in.ffa.project.user.User;
import in.ffa.project.util.Util;
import lombok.Getter;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

@Getter
public class FFA extends JavaPlugin {

    @Getter public static FFA instance;
    public String prefix = "&a[THE FFA] &r&f";
    public CommandManager commandManager;

    @Override
    public void onEnable() {

        instance = this;
        new File(getDataFolder().toString() + "").mkdir();
        new File(getDataFolder().toString() + "/users").mkdir();
        new File(getDataFolder().toString() + "/boxes").mkdir();

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        addEvent(this, new FFAJoinEvent());
        addEvent(this, new FFAQuitEvent());
        addEvent(this, new FFADamageEvent());
        addEvent(this, new FFADeathEvent());
        addEvent(this, new FFAChatEvent());
        addEvent(this, new FFABlockEvent());
        addEvent(this, new FFAMoveEvent());
        addEvent(this, new FFANPCEvent());
        addEvent(this, new FFAInvEvent());
        addEvent(this, new FFADropEvent());
        addEvent(this, new CommandEvent());
        addEvent(this, new EffectInventory());
        addEvent(this, new ServerMotdEvent());
        addEvent(this, new FFAInteractEvent());

        this.commandManager = new CommandManager();

        new BukkitRunnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() <= 0) return;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    new Board(player).create();
                    player.setPlayerListName(Util.getColor(Util.getLevel(new User(player).getLevel()) + " &f" + player.getName() + " &e(" + Math.round(player.getHealth()) + "&e)"));
                }
            }
        }.runTaskTimer(this, 0L, 10L);

        new BukkitRunnable() {
            @Override
            public void run() {
                if (Bukkit.getOnlinePlayers().size() <= 0) return;
                for (Player player : Bukkit.getOnlinePlayers()) {
                    User user = new User(player);
                    if (user.getMinExperience() >= user.getMaxExperience()) {
                        int level = user.getLevel();
                        int next_level = user.getLevel() + 1;

                        int exp = user.getMaxExperience();
                        new User(player).setLevel(new User(player).getLevel() + 1);
                        new User(player).setMinExperience(new User(player).getMinExperience() - new User(player).getMaxExperience());
                        new User(player).setMaxExperience(next_level * 10);
                        int next_exp = next_level * 10;

                        if (getConfig().getBoolean("levelup.sound.enabled")) {
                            player.getWorld().playSound(player.getLocation(), Sound.valueOf(getConfig().getString("levelup.sound.type")), 1, 2);
                        }
                        if (getConfig().getBoolean("levelup.message")) {
                            String message = FFA.getInstance().getPrefix() + "&f성공적으로 레벨업하셨습니다.";
                            String textcom = "&7레벨: &r" + Util.getLevel(level) + " &7-> &r" + Util.getLevel(next_level) + "\n&7경험치: &a" + Util.getBalance(exp) + " &7-> &a" + Util.getBalance(next_exp);

                            TextComponent textComponent = new TextComponent(Util.getColor(message));
                            textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder((Util.getColor(textcom))).create()));

                            player.spigot().sendMessage(textComponent);
                        }
                    }
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION,  999999, 255, true));
                }
            }
        }.runTaskTimer(this, 0L, 20L);

    }

    @Override
    public void onDisable() {

        commandManager.removeCommand();

    }

    public void addEvent(Plugin plugin, Listener listener) {
        getServer().getPluginManager().registerEvents(listener, plugin);
    }
}
