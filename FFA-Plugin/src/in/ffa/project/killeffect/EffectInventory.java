package in.ffa.project.killeffect;

import in.ffa.project.FFA;
import in.ffa.project.user.User;
import in.ffa.project.util.Util;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import static in.ffa.project.util.Util.getBalance;
import static in.ffa.project.util.Util.getColor;

public class EffectInventory implements Listener {

    private FFA main = FFA.getPlugin(FFA.class);
    private FileConfiguration config = main.getConfig();

    @EventHandler
    public void onEffectInventory(InventoryClickEvent event) {
        try {
            Player player = (Player) event.getWhoClicked();
            if (player.getOpenInventory().getTitle().contains("킬효과 상점")) {
                event.setCancelled(true);
                if (event.isLeftClick()) {
                    if (event.getCurrentItem().getType() == Material.GLASS && event.getCurrentItem().getItemMeta().getDisplayName().contains("번개 효과")) {
                        if (player.getInventory().getChestplate().getType().equals(Material.DIAMOND_CHESTPLATE)) {
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f이미 &a[번개 효과]&f을(를) 구입하셨습니다."));
                            return;
                        }

                        if (new User(player).getPoints() >= 20000) {
                            player.closeInventory();
                            player.getWorld().playSound(player.getLocation(), Sound.LEVEL_UP, 1, 2);
                            new User(player).setPoints(new User(player).getPoints() - 20000);
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f성공적으로 &a[번개 효과]&f을(를) 구매하셨습니다."));
                            return;
                        } else {
                            player.sendMessage(getColor(FFA.getInstance().getPrefix() + "&f보유 중인 금액이 부족합니다. &7(부족한 금액: " + getBalance(20000 - new User(player).getPoints()) + "&7P)"));
                            return;
                        }
                    }
                }
            }
        } catch (Exception e) {return;}
    }

}
