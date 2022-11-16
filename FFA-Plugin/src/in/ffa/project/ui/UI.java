package in.ffa.project.ui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static in.ffa.project.util.Util.*;

public class UI {

    private Player player;
    private Inventory inventory;

    public UI(Player player, String title, int i) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, i, getColor(title));
    }

    public void Open() {
        this.player.openInventory(this.inventory);
    }

    public void Close() {
        this.player.closeInventory();
    }

    public void setItem(int i, ItemStack itemStack) {
        this.inventory.setItem(i, itemStack);
    }

}
