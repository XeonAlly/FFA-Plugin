package in.ffa.project.killeffect;

import in.ffa.project.shop.Shop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Arrays;

import static in.ffa.project.util.Util.*;

public class KillEffect {

    private Player player;
    private Inventory inventory;

    public KillEffect(Player player) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, 27, getColor("&c&l[ &f킬효과 상점 &c&l]"));
    }

    public void openGUI() {
        this.inventory.setItem(10, new Shop(getColor("&a&l[SHOP] &f번개 효과"), new ArrayList<>(Arrays.asList(
                getColor("&8분류: 킬효과, 번개"),
                getColor("&1"),
                getColor("&7상점 포인트: &a[20,000P]"),
                getColor("&7설명: &a사람을 킬할 시 번개가 칩니다."),
                getColor("&1"),
                getColor("&a구입하려면 클릭하세요!")
        )), Material.GLASS, 1).getItem());

        this.player.openInventory(this.inventory);
    }

}
