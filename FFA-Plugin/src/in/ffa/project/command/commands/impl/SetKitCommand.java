package in.ffa.project.command.commands.impl;

import in.ffa.project.FFA;
import in.ffa.project.shop.Shop;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import static in.ffa.project.util.Util.*;

public class SetKitCommand {

    private FFA ffa = FFA.getPlugin(FFA.class);
    private FileConfiguration config = ffa.getConfig();

    public void execute(String[] args, String s, CommandSender commandSender) {
        Player player = (Player) commandSender;

        KitPlayer kitPlayer = new KitPlayer(player);
        kitPlayer.openGUI();
    }

    public class KitPlayer {

        private Player player;
        private Inventory inventory;

        public KitPlayer(Player player) {
            this.player = player;
            this.inventory = Bukkit.createInventory(null, 27, getColor("&a&l[ &fTHE FFA - 킷 수정 &a&l]"));
        }

        public void openGUI() {
            for (int i = 0; i <= 26; i++) {
                if (i == 11)
                    i += 5;

                this.inventory.setItem(i, new Shop(getColor("&f"), Material.STAINED_GLASS_PANE, 1).getItem());
            }

            this.inventory.setItem(11, new Shop(getColor("&f" + config.getString("world.kits.item-1.type").replace("_", " ")), Material.valueOf(config.getString("world.kits.item-1.type")), config.getInt("world.kits.item-1.amount")).getItem());
            this.inventory.setItem(12, new Shop(getColor("&f" + config.getString("world.kits.item-2.type").replace("_", " ")), Material.valueOf(config.getString("world.kits.item-2.type")), config.getInt("world.kits.item-2.amount")).getItem());
            this.inventory.setItem(13, new Shop(getColor("&f" + config.getString("world.kits.item-3.type").replace("_", " ")), Material.valueOf(config.getString("world.kits.item-3.type")), config.getInt("world.kits.item-3.amount")).getItem());
            this.inventory.setItem(14, new Shop(getColor("&f" + config.getString("world.kits.item-4.type").replace("_", " ")), Material.valueOf(config.getString("world.kits.item-4.type")), config.getInt("world.kits.item-4.amount")).getItem());
            this.inventory.setItem(15, new Shop(getColor("&f" + config.getString("world.kits.item-5.type").replace("_", " ")), Material.valueOf(config.getString("world.kits.item-5.type")), config.getInt("world.kits.item-5.amount")).getItem());

            this.player.openInventory(this.inventory);
        }

    }

}
