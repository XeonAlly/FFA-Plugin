package in.ffa.project.ui;

import in.ffa.project.util.Utils;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.material.MaterialData;

import java.util.ArrayList;
import java.util.List;

public class ItemManage implements Utils {

    private final ItemStack is;

    public ItemManage(final Material mat) {
        is = new ItemStack(mat);
    }

    public ItemManage(final ItemStack is) {
        this.is = is;
    }


    public ItemManage amount(final int amount) {
        is.setAmount(amount);
        return this;
    }


    public ItemManage name(final String name) {
        final ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(name);
        is.setItemMeta(meta);
        return this;
    }


    public ItemManage lore(final String name) {
        final ItemMeta meta = is.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new ArrayList<String>();
        }
        lore.add(name);
        meta.setLore(lore);
        is.setItemMeta(meta);
        return this;
    }

    public ItemManage loreColor(final String name) {
        final ItemMeta meta = is.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new ArrayList<String>();
        }
        lore.add(getColor(name));
        meta.setLore(lore);
        is.setItemMeta(meta);
        return this;
    }

    public ItemManage lore(final ArrayList<String> lore) {
        final ItemMeta meta = is.getItemMeta();
        meta.setLore(lore);
        is.setItemMeta(meta);
        return this;
    }


    public ItemManage durability(final int durability) {
        is.setDurability((short) durability);
        return this;
    }


    @SuppressWarnings("deprecation")
    public ItemManage data(final int data) {
        is.setData(new MaterialData(is.getType(), (byte) data));
        return this;
    }


    public ItemManage enchantment(final Enchantment enchantment, final int level) {
        is.addUnsafeEnchantment(enchantment, level);
        return this;
    }


    public ItemManage enchantment(final Enchantment enchantment) {
        is.addUnsafeEnchantment(enchantment, 1);
        return this;
    }


    public ItemManage type(final Material material) {
        is.setType(material);
        return this;
    }


    public ItemManage clearLore() {
        final ItemMeta meta = is.getItemMeta();
        meta.setLore(new ArrayList<String>());
        is.setItemMeta(meta);
        return this;
    }


    public ItemManage clearEnchantments() {
        for (final Enchantment e : is.getEnchantments().keySet()) {
            is.removeEnchantment(e);
        }
        return this;
    }

    public ItemManage color(Color color) {
        if (is.getType() == Material.LEATHER_BOOTS || is.getType() == Material.LEATHER_CHESTPLATE || is.getType() == Material.LEATHER_HELMET
                || is.getType() == Material.LEATHER_LEGGINGS) {
            LeatherArmorMeta meta = (LeatherArmorMeta) is.getItemMeta();
            meta.setColor(color);
            is.setItemMeta(meta);
            return this;
        } else {
            throw new IllegalArgumentException("color() only applicable for leather armor!");
        }
    }

    public ItemManage setUnbreakable(boolean unbreak){
        ItemMeta meta = is.getItemMeta();
        meta.spigot().setUnbreakable(true);
        is.setItemMeta(meta);
        return this;
    }

    public ItemManage setHideEnchants(boolean hide) {
        ItemMeta meta = is.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        is.setItemMeta(meta);
        return this;
    }

    public ItemManage setOwner(String name) {
        SkullMeta meta = (SkullMeta) is.getItemMeta();
        meta.setOwner(name);
        is.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return is;
    }

}
