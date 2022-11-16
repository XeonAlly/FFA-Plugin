package in.ffa.project.util;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class BuildUtil {

    public static ArrayList<Player> builds = new ArrayList<>();

    public static void add(Player player) {
        builds.add(player);
    }

    public static void remove(Player player) {
        builds.remove(player);
    }

    public static ArrayList<Player> getBuilds() {
        return builds;
    }

}
