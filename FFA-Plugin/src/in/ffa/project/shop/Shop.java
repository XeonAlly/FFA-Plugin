package in.ffa.project.shop;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class Shop {

    private String name;
    private ArrayList<String> lore;
    private Material material;
    private int amount;
    private Enchantment enchantment;
    private int count;
    private boolean hideEnchants;

    public Shop(String name, Material material, int amount) {
        this.name = name;
        this.material = material;
        this.amount = amount;
    }

    public Shop(String name, Material material, int amount, boolean hideEnchants) {
        this.name = name;
        this.material = material;
        this.amount = amount;
        this.hideEnchants = hideEnchants;
    }

    public Shop(String name, ArrayList<String> lore, Material material, int amount) {
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.amount = amount;
    }

    public Shop(String name, ArrayList<String> lore, Material material, int amount, boolean hideEnchants) {
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.amount = amount;
        this.hideEnchants = hideEnchants;
    }

    public Shop(String name, Material material, int amount, Enchantment enchantment, int count) {
        this.name = name;
        this.material = material;
        this.amount = amount;
        this.enchantment = enchantment;
        this.count = count;
    }

    public Shop(String name, Material material, int amount, Enchantment enchantment, int count, boolean hideEnchants) {
        this.name = name;
        this.material = material;
        this.amount = amount;
        this.enchantment = enchantment;
        this.count = count;
        this.hideEnchants = hideEnchants;
    }

    public Shop(String name, ArrayList<String> lore, Material material, int amount, Enchantment enchantment, int count) {
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.amount = amount;
        this.enchantment = enchantment;
        this.count = count;
    }

    public Shop(String name, ArrayList<String> lore, Material material, int amount, Enchantment enchantment, int count, boolean hideEnchants) {
        this.name = name;
        this.lore = lore;
        this.material = material;
        this.amount = amount;
        this.enchantment = enchantment;
        this.count = count;
        this.hideEnchants = hideEnchants;
    }

    public ItemStack getItem() {
        ItemStack item = new ItemStack(this.material, this.amount);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(this.name);
        if (this.lore != null)
            meta.setLore(this.lore);
        if (this.enchantment != null)
            meta.addEnchant(this.enchantment, this.amount, false);
        if (this.hideEnchants)
            meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

}
