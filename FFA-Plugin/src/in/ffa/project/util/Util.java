package in.ffa.project.util;

import in.ffa.project.FFA;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.PacketPlayInClientCommand;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import java.awt.*;
import java.lang.reflect.Constructor;
import java.security.SecureRandom;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class Util {

    public static String getColor(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public static TextComponent getText(String message, String description) {
        net.md_5.bungee.api.chat.TextComponent textComponent = new TextComponent(getColor(message));
        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder((getColor(description))).create()));
        return textComponent;
    }

    public static String getText1(String message, String description) {
        net.md_5.bungee.api.chat.TextComponent textComponent = new TextComponent(getColor(message));
        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder((getColor(description))).create()));
        return String.valueOf(textComponent);
    }

    public static BaseComponent getBaseComponent(String text) {
        BaseComponent baseComponent = new TextComponent("");
        return baseComponent;
    }

    public static String getRandomString(int length) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for(int i = 0; i < length; i++) {

            int index = random.nextInt(alphabet.length());
            char randomChar = alphabet.charAt(index);

            sb.append(randomChar);
        }

        String randomString = sb.toString();
        return randomString;
    }

    public static void send(Player player, int fadeInTime, int showTime, int fadeOutTime, String title, String subtitle) {
        try {
            Object chatTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class)
                    .invoke(null, "{\"text\": \"" + title + "\"}");
            Constructor<?> titleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(
                    getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"),
                    int.class, int.class, int.class);
            Object packet = titleConstructor.newInstance(
                    getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("TITLE").get(null), chatTitle,
                    fadeInTime, showTime, fadeOutTime);

            Object chatsTitle = getNMSClass("IChatBaseComponent").getDeclaredClasses()[0].getMethod("a", String.class)
                    .invoke(null, "{\"text\": \"" + subtitle + "\"}");
            Constructor<?> stitleConstructor = getNMSClass("PacketPlayOutTitle").getConstructor(
                    getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0], getNMSClass("IChatBaseComponent"),
                    int.class, int.class, int.class);
            Object spacket = stitleConstructor.newInstance(
                    getNMSClass("PacketPlayOutTitle").getDeclaredClasses()[0].getField("SUBTITLE").get(null), chatsTitle,
                    fadeInTime, showTime, fadeOutTime);

            sendPacket(player, packet);
            sendPacket(player, spacket);
        } catch (Exception ex) {return;}
    }

    public static void sendPacket(Player player, Object packet) {
        try {
            Object handle = player.getClass().getMethod("getHandle").invoke(player);
            Object playerConnection = handle.getClass().getField("playerConnection").get(handle);
            playerConnection.getClass().getMethod("sendPacket", getNMSClass("Packet")).invoke(playerConnection, packet);
        } catch (Exception ex) {return;}
    }

    public static Class<?> getNMSClass(String name) {
        try {
            return Class.forName("net.minecraft.server"
                    + Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3] + "." + name);
        } catch (ClassNotFoundException ex) {}
        return null;
    }

    public static String getBalance(double balance) {
        NumberFormat format = NumberFormat.getInstance(Locale.ENGLISH);
        format.setMaximumFractionDigits(2);
        format.setMinimumFractionDigits(0);
        return format.format(balance);
    }

    public static String getDate() {
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy");
        String date = format.format(now);
        return date;
    }

    public static String getLevel(int level) {
        if (level >= 1)
            if (level <= 19)
                return "&7[" + level + "&7✫]";
        if (level >= 20)
            if (level <= 29)
                return "&f[" + level + "&f✫]";
        if (level >= 30)
            if (level <= 39)
                return "&f[" + level + "&f✩]";
        if (level >= 40)
            if (level <= 49)
                return "&e[" + level + "&e❉]";
        if (level >= 50)
            if (level <= 59)
                return "&6[" + level + "&6❊]";
        if (level >= 60)
            if (level <= 69)
                return "&b[" + level + "&b❋]";
        if (level >= 70)
            if (level <= 79)
                return "&3[" + level + "&3✱]";
        if (level >= 80)
            if (level <= 89)
                return "&9[" + level + "&9☯]";
        if (level >= 90)
            if (level <= 99)
                return "&a[" + level + "&a❦]";
        if (level >= 100)
            if (level <= 109)
                return "&2[" + level + "&2❖]";
        if (level >= 110)
            if (level <= 119)
                return "&c[" + level + "&c✝]";
        if (level >= 120)
            if (level <= 129)
                return "&4[" + level + "&4✞]";
        if (level >= 130)
            if (level <= 139)
                return "&7[&f" + level + "&7✟]";
        if (level >= 140)
            if (level <= 149)
                return "&6[&e" + level + "&6✠]";
        if (level >= 150)
            if (level <= 159)
                return "&9[&b" + level + "&9✡]";
        if (level >= 160)
            if (level <= 169)
                return "&4[&c" + level + "&4✢]";
        if (level >= 170)
            if (level <= 179)
                return "&5[" + String.valueOf(level).substring(0, 2) + "&d" + String.valueOf(level).substring(2) + "&d✣]";
        if (level >= 180)
            if (level <= 189)
                return "&9[" + String.valueOf(level).substring(0, 2) + "&b" + String.valueOf(level).substring(2) + "&b✤]";
        if (level >= 190)
            if (level <= 199)
                return "&4[" + String.valueOf(level).substring(0, 2) + "&c" + String.valueOf(level).substring(2) + "&c❀]";
        if (level >= 200)
            if (level <= 209)
                return "&6[" + String.valueOf(level).substring(0, 2) + "&e" + String.valueOf(level).substring(2) + "&e✰]";
        if (level >= 210)
            if (level <= 219)
                return "&5[" + String.valueOf(level).substring(0, 2) + "&d" + String.valueOf(level).substring(2) + "&d✬]";
        if (level >= 220)
            if (level <= 229)
                return "&1[" + String.valueOf(level).substring(0, 2) + "&9" + String.valueOf(level).substring(2) + "&9✮]";
        if (level >= 230)
            if (level <= 239)
                return "&2[" + String.valueOf(level).substring(0, 2) + "&a" + String.valueOf(level).substring(2) + "&a✯]";
        if (level >= 240)
            if (level <= 249)
                return "&7&k[&f&l" + String.valueOf(level).substring(0, 1) + "&a&l" + String.valueOf(level).substring(1, 2) + "&2&l" + String.valueOf(level).substring(2, 3) + "&b❃&3&k]&r";
        if (level >= 250)
            if (level <= 259)
                return "&7&k[&f&l" + String.valueOf(level).substring(0, 1) + "&b&l" + String.valueOf(level).substring(1, 2) + "&3&l" + String.valueOf(level).substring(2, 3) + "&e❢&6&k]&r";
        if (level >= 260)
            if (level <= 269)
                return "&7&k[&f&l" + String.valueOf(level).substring(0, 1) + "&e&l" + String.valueOf(level).substring(1, 2) + "&6&l" + String.valueOf(level).substring(2, 3) + "&d❦&5&k]&r";
        if (level >= 270)
            if (level <= 279)
                return "&7&k[&f&l" + String.valueOf(level).substring(0, 1) + "&d&l" + String.valueOf(level).substring(1, 2) + "&5&l" + String.valueOf(level).substring(2, 3) + "&c✌&4&k]&r";
        if (level >= 280)
            if (level <= 289)
                return "&7&k[&f&l" + String.valueOf(level).substring(0, 1) + "&c&l" + String.valueOf(level).substring(1, 2) + "&4&l" + String.valueOf(level).substring(2, 3) + "&3ღ&9&k]&r";
        if (level >= 290)
            if (level <= 299)
                return "&c&k[&7&l" + String.valueOf(level).substring(0, 1) + "&f&l" + String.valueOf(level).substring(1, 2) + "&e&l" + String.valueOf(level).substring(2, 3) + "&6ಠ_ಠ&c&k]&r";
        if (level >= 300)
            return "&c&k[&6&l" + level + "&cಠ_ಠ&k]&r";

        return null;
    }

    public static ItemStack getKit(int id, boolean armor) {
        FFA ffa = FFA.getPlugin(FFA.class);
        ItemStack i = new ItemStack(Material.getMaterial(ffa.getConfig().getString("world.kits.item-" + id + ".type")), ffa.getConfig().getInt("world.kits.item-" + id + ".amount"));
        ItemMeta im = i.getItemMeta();
        im.spigot().setUnbreakable(true);
        if (ffa.getConfig().getBoolean("world.kits.item-" + id + ".enchanted"))
            if (armor)
                im.addEnchant(Enchantment.getById(0), 1, false);
            else
                im.addEnchant(Enchantment.getById(16), 1, false);
        i.setItemMeta(im);
        return i;
    }

    public static void shopItem(Player player, ItemStack itemStack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        itemStack.setItemMeta(itemMeta);
        player.getInventory().addItem(itemStack);
    }

    public static void clear(Player player) {
        PlayerInventory i = player.getInventory();
        i.clear();
        i.setHelmet(new ItemStack(Material.AIR));
        i.setChestplate(new ItemStack(Material.AIR));
        i.setLeggings(new ItemStack(Material.AIR));
        i.setBoots(new ItemStack(Material.AIR));
    }

    public static void addhand(Player player, ItemStack item) {
        PlayerInventory i = player.getInventory();
        i.addItem(item);
    }

    public static void sethand(Player player, int slot, ItemStack item) {
        PlayerInventory i = player.getInventory();
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        i.setItem(slot, item);
    }

    public static void helmet(Player player, ItemStack item) {
        PlayerInventory i = player.getInventory();
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        i.setHelmet(item);
    }

    public static void chestplate(Player player, ItemStack item) {
        PlayerInventory i = player.getInventory();
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        i.setChestplate(item);
    }

    public static void leggings(Player player, ItemStack item) {
        PlayerInventory i = player.getInventory();
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        i.setLeggings(item);
    }

    public static void boots(Player player, ItemStack item) {
        PlayerInventory i = player.getInventory();
        ItemMeta itemMeta = item.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        item.setItemMeta(itemMeta);
        i.setBoots(item);
    }

    public static void firework(Player player) {
        Firework fw = (Firework) player.getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta fwm = fw.getFireworkMeta();

        Random r = new Random();
        int rt = r.nextInt(4) + 1;

        FireworkEffect.Type type = FireworkEffect.Type.BALL;
        if (rt == 1) type = FireworkEffect.Type.BALL;
        if (rt == 2) type = FireworkEffect.Type.BALL_LARGE;
        if (rt == 3) type = FireworkEffect.Type.BURST;
        if (rt == 4) type = FireworkEffect.Type.CREEPER;
        if (rt == 5) type = FireworkEffect.Type.STAR;

        int r1i = r.nextInt(14) + 1;
        int r2i = r.nextInt(14) + 1;
        Color c1 = getColor(r1i);
        Color c2 = getColor(r2i);

        FireworkEffect effect = FireworkEffect.builder().flicker(r.nextBoolean()).withColor((Iterable<?>) c1).withFade((Iterable<?>) c2).with(type).trail(r.nextBoolean()).build();
        fwm.addEffect(effect);

        int rp = r.nextInt(2) + 1;
        fwm.setPower(rp);
        fw.setFireworkMeta(fwm);
    }

    private static Color getColor(int i) {
        Color c = null;
        if (i == 1){
            c = Color.CYAN;
        }
        if (i == 2){
            c = Color.BLACK;
        }
        if (i == 3){
            c = Color.BLUE;
        }
        if (i == 5){
            c = Color.GRAY;
        }
        if (i == 6){
            c = Color.GREEN;
        }
        if (i == 7) {
            c = Color.MAGENTA;
        }
        if (i == 8) {
            c = Color.PINK;
        }
        if (i == 9) {
            c = Color.DARK_GRAY;
        }
        if (i == 10) {
            c = Color.LIGHT_GRAY;
        }
        if (i == 11){
            c = Color.ORANGE;
        }
        if (i == 12) {
            c = Color.ORANGE;
        }
        if (i == 13){
            c = Color.RED;
        }
        if (i == 14){
            c = Color.WHITE;
        }
        if (i == 15){
            c = Color.YELLOW;
        }

        return c;
    }

    public static void respawn(Player player) {
        PacketPlayInClientCommand packet = new PacketPlayInClientCommand(PacketPlayInClientCommand.EnumClientCommand.PERFORM_RESPAWN);
        CraftPlayer craftPlayer = (CraftPlayer)player;
        craftPlayer.getHandle().playerConnection.a(packet);
    }

    public static String getProgressBar(int currentXp, int requiredXp) {
        double l1 = ((requiredXp - currentXp) / (double) (requiredXp)) * 10;
        int locked = (int) l1;
        int unlocked = 10 - locked;
        if (locked < 0 || unlocked < 0) {
            locked = 10;
            unlocked = 0;
        }
        String progressBar = ChatColor.translateAlternateColorCodes('&', "&8[{progress}&8]".replace("{progress}", "&a" + String.valueOf(new char[unlocked]).replace("\0", "■") + "&f" + String.valueOf(new char[locked]).replace("\0", "■")));
        return progressBar;
    }

    public static int getRandomInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static float getRandomInRange(float min, float max) {
        SecureRandom random = new SecureRandom();
        return random.nextFloat() * (max - min) + min;
    }

    public static double getRandomInRange(double min, double max) {
        SecureRandom random = new SecureRandom();
        return random.nextDouble() * (max - min) + min;
    }

}
