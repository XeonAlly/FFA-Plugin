package in.ffa.project.shop.ui;

import in.ffa.project.shop.Shop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Arrays;

import static in.ffa.project.util.Util.*;

public class UI {

    private Player player;
    private Inventory inventory;

    public UI(Player player, String title, int count) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, count, title);
    }

    public void open(String type) {
        if (type.equalsIgnoreCase("ITEM")) {
            this.inventory.setItem(10, new Shop(getColor("&a&l[SHOP] &f다이아몬드 검"), new ArrayList<>(Arrays.asList(
                    getColor("&8분류: 다이아몬드, 검"),
                    getColor("&1"),
                    getColor("&7상점 포인트: &a[1,000P]"),
                    getColor("&c주의! 재접속 & 사망시 초기화됩니다."),
                    getColor("&1"),
                    getColor("&a구입하려면 클릭하세요!")
            )), Material.DIAMOND_SWORD, 1).getItem());
            this.inventory.setItem(12, new Shop(getColor("&a&l[SHOP] &f다이아몬드 갑옷"), new ArrayList<>(Arrays.asList(
                    getColor("&8분류: 다이아몬드, 갑옷"),
                    getColor("&1"),
                    getColor("&7상점 포인트: &a[5,000P]"),
                    getColor("&c주의! 재접속 & 사망시 초기화됩니다."),
                    getColor("&1"),
                    getColor("&a구입하려면 클릭하세요!")
            )), Material.DIAMOND_CHESTPLATE, 1).getItem());
            this.inventory.setItem(14, new Shop(getColor("&a&l[SHOP] &f블럭"), new ArrayList<>(Arrays.asList(
                    getColor("&8분류: 블럭"),
                    getColor("&1"),
                    getColor("&7상점 포인트: &a[500P]"),
                    getColor("&c주의! 재접속 & 사망시 초기화됩니다."),
                    getColor("&1"),
                    getColor("&a구입하려면 클릭하세요!")
            )), Material.SANDSTONE, 16).getItem());

            this.player.openInventory(this.inventory);
        } else if (type.equalsIgnoreCase("KEY")) {
            this.inventory.setItem(10, new Shop(getColor("&a&l[SHOP] &f귀중한 열쇠"), new ArrayList<>(Arrays.asList(
                    getColor("&8분류: 인공 열쇠"),
                    getColor("&1"),
                    getColor("&7열쇠 등급: &6[레전드]"),
                    getColor("&7상점 포인트: &a[30,000P]"),
                    getColor("&1"),
                    getColor("&a구입하려면 클릭하세요!")
            )), Material.TRIPWIRE_HOOK, 1, Enchantment.DURABILITY, 1, true).getItem());

            this.player.openInventory(this.inventory);
        }
    }

}
