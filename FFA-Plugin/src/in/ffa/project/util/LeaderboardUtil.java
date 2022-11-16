package in.ffa.project.util;

import in.ffa.project.user.User;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;

import java.io.File;
import java.util.*;

public class LeaderboardUtil {

    private String name1 = "없음", name2 = "없음", name3 = "없음", name4 = "없음", name5 = "없음", name6 = "없음", name7 = "없음", name8 = "없음", name9 = "없음", name10 = "없음";
    private int score1 = 0, score2 = 0, score3 = 0, score4 = 0, score5 = 0, score6 = 0, score7 = 0, score8 = 0, score9 = 0, score10 = 0;


    public LeaderboardUtil() {
        HashMap<String, Integer> map = new HashMap<>();
        map.clear();
        for (File uuidstr : new FileScript("users").listFiles()) {
            String uuid = uuidstr.getName().replace(".yml", "");
            OfflinePlayer op = Bukkit.getOfflinePlayer(UUID.fromString(uuid));
            map.put(op.getName(), new User(op.getUniqueId()).getLevel());
        }
        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));
        int entry = 0;
        for (Map.Entry<String, Integer> e : reverseSortedMap.entrySet()) {
            if (entry == 0) {
                name1 = e.getKey();
                score1 = e.getValue();
            } else if (entry == 1) {
                name2 = e.getKey();
                score2 = e.getValue();
            } else if (entry == 2) {
                name3 = e.getKey();
                score3 = e.getValue();
                break;
            } else if (entry == 3) {
                name4 = e.getKey();
                score4 = e.getValue();
                break;
            } else if (entry == 4) {
                name5 = e.getKey();
                score5 = e.getValue();
                break;
            } else if (entry == 5) {
                name6 = e.getKey();
                score6 = e.getValue();
                break;
            } else if (entry == 6) {
                name7 = e.getKey();
                score7 = e.getValue();
                break;
            } else if (entry == 7) {
                name8 = e.getKey();
                score8 = e.getValue();
                break;
            } else if (entry == 8) {
                name9 = e.getKey();
                score9 = e.getValue();
                break;
            } else if (entry == 9) {
                name10 = e.getKey();
                score10 = e.getValue();
                break;
            }
            entry++;
        }
    }

    public String getName(int num) {
        if (num == 0)
            return name1;
        if (num == 1)
            return name2;
        if (num == 2)
            return name3;
        if (num == 3)
            return name4;
        if (num == 4)
            return name5;
        if (num == 5)
            return name6;
        if (num == 6)
            return name7;
        if (num == 7)
            return name8;
        if (num == 8)
            return name9;
        if (num == 9)
            return name10;
        return "없음";
    }

    public int getScore(int num) {
        if (num == 0)
            return score1;
        if (num == 1)
            return score2;
        if (num == 2)
            return score3;
        if (num == 3)
            return score4;
        if (num == 4)
            return score5;
        if (num == 5)
            return score6;
        if (num == 6)
            return score7;
        if (num == 7)
            return score8;
        if (num == 8)
            return score9;
        if (num == 9)
            return score10;
        return 0;
    }

}
