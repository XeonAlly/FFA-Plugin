package in.ffa.project.ui;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvManage {

    private Player player;

    private Inventory inventory;
    private ItemStack is;

    public InvManage(Player player) {
        this.player = player;
    }

    public Inventory inventory(String title, int slot) {
        return Bukkit.createInventory(null, slot, title);
    }

}
