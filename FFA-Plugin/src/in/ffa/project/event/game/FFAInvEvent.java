package in.ffa.project.event.game;

import in.ffa.project.FFA;
import in.ffa.project.shop.ui.UI;
import in.ffa.project.user.User;
import in.ffa.project.util.BuildUtil;
import in.ffa.project.util.Util;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;

import static in.ffa.project.util.Util.*;

public class FFAInvEvent implements Listener {

    private FFA main = FFA.getPlugin(FFA.class);
    private FileConfiguration config = main.getConfig();

    @EventHandler
    public void onFFAInv(InventoryClickEvent event) {
        try {
            Player player = (Player) event.getWhoClicked();
            if (player.getOpenInventory().getTitle().contains("아이템 상점")) {
                event.setCancelled(true);
                if (event.isLeftClick()) {
                    if (event.getCurrentItem().getType() == Material.DIAMOND_SWORD && event.getCurrentItem().getItemMeta().getDisplayName().contains("다이아몬드 검")) {
                        if (player.getInventory().contains(Material.DIAMOND_SWORD, 1)) {
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f이미 &a[다이아몬드 검]&f을(를) 구입하셨습니다."));
                            return;
                        }

                        if (new User(player).getPoints() >= 1000) {
                            player.closeInventory();
                            player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 2);
                            Util.sethand(player, 0, new ItemStack(Material.DIAMOND_SWORD, 1));
                            new User(player).setPoints(new User(player).getPoints() - 1000);
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f성공적으로 &a[다이아몬드 검]&f을(를) 구매하셨습니다."));
                            return;
                        } else {
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f보유 중인 금액이 부족합니다. &7(부족한 금액: " + getBalance(1000 - new User(player).getPoints()) + "&7P)"));
                            return;
                        }
                    }
                    if (event.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE && event.getCurrentItem().getItemMeta().getDisplayName().contains("다이아몬드 갑옷")) {
                        if (player.getInventory().getChestplate() != null && player.getInventory().getChestplate().getType().equals(Material.DIAMOND_CHESTPLATE)) {
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f이미 &a[다이아몬드 갑옷]&f을(를) 구입하셨습니다."));
                            return;
                        }

                        if (new User(player).getPoints() >= 5000) {
                            player.closeInventory();
                            player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 2);
                            Util.chestplate(player, new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
                            new User(player).setPoints(new User(player).getPoints() - 5000);
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f성공적으로 &a[다이아몬드 갑옷]&f을(를) 구매하셨습니다."));
                            return;
                        } else {
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f보유 중인 금액이 부족합니다. &7(부족한 금액: " + getBalance(5000 - new User(player).getPoints()) + "&7P)"));
                            return;
                        }
                    }
                    if (event.getCurrentItem().getType() == Material.SANDSTONE && event.getCurrentItem().getItemMeta().getDisplayName().contains("블럭")) {
                        if (new User(player).getPoints() >= 500) {
                            player.closeInventory();
                            player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 2);
                            Util.addhand(player, new ItemStack(Material.SANDSTONE, 16));
                            new User(player).setPoints(new User(player).getPoints() - 500);
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f성공적으로 &a[블럭]&f을(를) 구매하셨습니다."));
                            return;
                        } else {
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f보유 중인 금액이 부족합니다. &7(부족한 금액: " + getBalance(500 - new User(player).getPoints()) + "&7P)"));
                            return;
                        }
                    }
                }
            } else if (player.getOpenInventory().getTitle().contains("기본템 설정")) {
                if (event.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) event.setCancelled(true);
            } else if (player.getOpenInventory().getTitle().contains("게임 순위")) {
                event.setCancelled(true);
            }
        } catch (Exception e) {return;}
    }

    @EventHandler
    public void onFFAInvClose(InventoryCloseEvent event) {
        try {
            Player player = (Player) event.getPlayer();
            if (player.getOpenInventory().getTitle().contains("기본템 설정")) {
                config.set("world.kits.item-1.type", event.getInventory().getItem(11).getType().toString());
                config.set("world.kits.item-1.amount", event.getInventory().getItem(11).getAmount());
                config.set("world.kits.item-2.type", event.getInventory().getItem(12).getType().toString());
                config.set("world.kits.item-2.amount", event.getInventory().getItem(12).getAmount());
                config.set("world.kits.item-3.type", event.getInventory().getItem(13).getType().toString());
                config.set("world.kits.item-3.amount", event.getInventory().getItem(13).getAmount());
                config.set("world.kits.item-4.type", event.getInventory().getItem(14).getType().toString());
                config.set("world.kits.item-4.amount", event.getInventory().getItem(14).getAmount());
                config.set("world.kits.item-5.type", event.getInventory().getItem(15).getType().toString());
                config.set("world.kits.item-5.amount", event.getInventory().getItem(15).getAmount());
                config.save(new File(main.getDataFolder() + "/config.yml"));
                player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f성공적으로 킷을 저장하셨습니다."));
            }
        } catch (Exception e) {return;}
    }

}
