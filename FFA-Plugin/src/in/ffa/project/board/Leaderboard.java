package in.ffa.project.board;

import in.ffa.project.ui.ItemManage;
import in.ffa.project.util.LeaderboardUtil;
import in.ffa.project.util.Util;
import in.ffa.project.util.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Leaderboard implements Utils {

    private Player player;
    private Inventory inventory;
    private LeaderboardUtil util;

    public Leaderboard(Player player) {
        this.player = player;
        this.inventory = Bukkit.createInventory(null, 9, getColor("&a&l게임 순위"));
        this.util = new LeaderboardUtil();

        this.inventory.setItem(4, new ItemManage(Material.DIAMOND).name(getColor("&a레벨 순위"))
                .lore(getColor("&a1. &f" + util.getName(0) + " &a- &7" + Util.getLevel(util.getScore(0))).replace("null", getColor("&f없음")))
                .lore(getColor("&a2. &f" + util.getName(1) + " &a- &7" + Util.getLevel(util.getScore(1))).replace("null", getColor("&f없음")))
                .lore(getColor("&a3. &f" + util.getName(2) + " &a- &7" + Util.getLevel(util.getScore(2))).replace("null", getColor("&f없음")))
                .lore(getColor("&a4. &f" + util.getName(3) + " &a- &7" + Util.getLevel(util.getScore(3))).replace("null", getColor("&f없음")))
                .lore(getColor("&a5. &f" + util.getName(4) + " &a- &7" + Util.getLevel(util.getScore(4))).replace("null", getColor("&f없음")))
                .lore(getColor("&a6. &f" + util.getName(5) + " &a- &7" + Util.getLevel(util.getScore(5))).replace("null", getColor("&f없음")))
                .lore(getColor("&a7. &f" + util.getName(6) + " &a- &7" + Util.getLevel(util.getScore(6))).replace("null", getColor("&f없음")))
                .lore(getColor("&a8. &f" + util.getName(7) + " &a- &7" + Util.getLevel(util.getScore(7))).replace("null", getColor("&f없음")))
                .lore(getColor("&a9. &f" + util.getName(8) + " &a- &7" + Util.getLevel(util.getScore(8))).replace("null", getColor("&f없음")))
                .lore(getColor("&a10. &f" + util.getName(9) + " &a- &7" + Util.getLevel(util.getScore(9))).replace("null", getColor("&f없음")))
                .build()
        );

        this.player.openInventory(this.inventory);
    }

}
