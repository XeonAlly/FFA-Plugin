package in.ffa.project.util;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import static in.ffa.project.util.Util.getColor;

public class Item {

    public Item() {}

    public ItemStack getItem(Material material, int a) {
        return new ItemStack(material, a);
    }

    public ItemStack getItem(Material material, int a, short s) {
        return new ItemStack(material, a, s);
    }

    public ItemStack getItem(Material material, int a, String displayname) {
        ItemStack i = new ItemStack(material, a);
        i.getItemMeta().setDisplayName(getColor(displayname));
        return i;
    }

    public ItemStack getItem(Material material, int a, short s, String displayname) {
        ItemStack i = new ItemStack(material, a, s);
        i.getItemMeta().setDisplayName(getColor(displayname));
        return i;
    }

    public ItemStack getItem(Material material, int a, String displayname, ArrayList<String> lores) {
        ItemStack i = new ItemStack(material, a);
        i.getItemMeta().setDisplayName(getColor(displayname));
        i.getItemMeta().setLore(lores);
        return i;
    }

    public ItemStack getItem(Material material, int a, short s, String displayname, ArrayList<String> lores) {
        ItemStack i = new ItemStack(material, a, s);
        i.getItemMeta().setDisplayName(getColor(displayname));
        i.getItemMeta().setLore(lores);
        return i;
    }

    public ItemStack getItem(Material material, int a, String displayname, ArrayList<String> lores, Enchantment enchantment, int em, boolean hide) {
        ItemStack i = new ItemStack(material, a);
        i.getItemMeta().setDisplayName(getColor(displayname));
        i.getItemMeta().setLore(lores);
        i.getItemMeta().addEnchant(enchantment, em, false);
        if (hide) i.getItemMeta().addItemFlags(ItemFlag.HIDE_ENCHANTS);
        return i;
    }

}
