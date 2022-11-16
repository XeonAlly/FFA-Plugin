package in.ffa.project.board;

import in.ffa.project.FFA;
import in.ffa.project.user.User;
import in.ffa.project.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Board {

    private Player player;

    private String date;
    private Objective object;
    private Scoreboard scoreboard;
    private ScoreboardManager scoreboardManager;
    private FFA main;

    public Board(Player player) {
        this.player = player;
        this.main = FFA.getPlugin(FFA.class);
    }

    public void create() {
        this.scoreboardManager = Bukkit.getScoreboardManager();
        this.scoreboard = this.scoreboardManager.getNewScoreboard();
        this.date = Util.getDate();

        this.object = this.scoreboard.registerNewObjective("sb", "dummy");
        this.object.setDisplayName(c("&a&lTHE FFA"));
        this.object.setDisplaySlot(DisplaySlot.SIDEBAR);

        this.object.getScore(c("&7" + this.date + " &8[#m981E]")).setScore(12);
        this.object.getScore(c("&1")).setScore(11);
        this.object.getScore(c("&f레벨: " + Util.getLevel(new User(this.player).getLevel()))).setScore(10);
        this.object.getScore(c("&f경험치: &a[" + Util.getBalance(new User(this.player).getMinExperience()) + "&a/" + Util.getBalance(new User(this.player).getMaxExperience()) + "&a]")).setScore(9);
        this.object.getScore(c("&f진행률: " + Util.getProgressBar(new User(this.player).getMinExperience(), new User(this.player).getMaxExperience()))).setScore(8);
        this.object.getScore(c("&2")).setScore(7);
        this.object.getScore(c("&f총 킬: &a[" + Util.getBalance(new User(this.player).getKills()) + "&a]")).setScore(6);
        this.object.getScore(c("&f총 사망: &a[" + Util.getBalance(new User(this.player).getDeaths()) + "&a]")).setScore(5);
        this.object.getScore(c("&f상점 포인트: &a[" + Util.getBalance(new User(this.player).getPoints()) + "&a]")).setScore(4);
        this.object.getScore(c("&f랜덤상자 열쇠: &a[" + Util.getBalance(new User(this.player).getKeys()) + "&a]")).setScore(3);
        this.object.getScore(c("&3")).setScore(2);
        this.object.getScore(c("&a" + this.main.getConfig().getString("scoreboard.domain"))).setScore(1);

        this.player.setScoreboard(this.scoreboard);
    }

    public String c(String text) {
        return Util.getColor(text);
    }

}
