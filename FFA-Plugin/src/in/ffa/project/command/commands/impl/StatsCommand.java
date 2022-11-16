package in.ffa.project.command.commands.impl;

import in.ffa.project.FFA;
import in.ffa.project.user.User;
import in.ffa.project.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static in.ffa.project.util.Util.*;

public class StatsCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        FFA ffa = FFA.getPlugin(FFA.class);
        Player player = (Player) commandSender;

        if (args.length < 5) {
            player.spigot().sendMessage(getText(ffa.getPrefix() + "/ffa stats &a➜ &f[THE FFA 스텟 정보 관리합니다.]", ffa.getPrefix() + "/ffa stats [level/xp/points/kills/deaths/keys] [give/set/remove] (player) (value)"));
            return;
        }

        Player target = Bukkit.getPlayer(args[3]);
        if (target == null) {
            player.sendMessage(getColor(ffa.getPrefix() + "&f오프라인 상태인 플레이어입니다."));
            return;
        }

        int value = Integer.valueOf(args[4]);
        if (args[1].equalsIgnoreCase("level")) {
            if (args[2].equalsIgnoreCase("set")) {
                int clv = new User(target).getLevel();
                new User(target).setLevel(value);
                new User(target).setMaxExperience(value * 10);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 레벨를 &a설정&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + getLevel(clv) + " &8➜ &a" + getLevel(new User(target).getLevel())));
            } else if (args[2].equalsIgnoreCase("give")) {
                int clv = new User(target).getLevel();
                new User(target).setLevel(clv + value);
                new User(target).setMaxExperience(new User(target).getLevel() * 10);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 레벨를 &a추가&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + getLevel(clv) + " &8➜ &a" + getLevel(new User(target).getLevel())));
            } else if (args[2].equalsIgnoreCase("remove")) {
                int clv = new User(target).getLevel();
                new User(target).setLevel(clv - value);
                new User(target).setMaxExperience(new User(target).getLevel() * 10);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 레벨를 &a차감&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + getLevel(clv) + " &8➜ &a" + getLevel(new User(target).getLevel())));
            }
        } else if (args[1].equalsIgnoreCase("xp")) {
            if (args[2].equalsIgnoreCase("set")) {
                int cxp = new User(target).getMinExperience();
                new User(target).setMinExperience(value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 경험치를 &a설정&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(cxp) + " &8➜ &a" + Util.getBalance(new User(target).getMinExperience())));
            } else if (args[2].equalsIgnoreCase("give")) {
                int cxp = new User(target).getMinExperience();
                new User(target).setMinExperience(cxp + value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 경험치를 &a추가&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(cxp) + " &8➜ &a" + Util.getBalance(new User(target).getMinExperience())));
            } else if (args[2].equalsIgnoreCase("remove")) {
                int cxp = new User(target).getMinExperience();
                new User(target).setMinExperience(cxp - value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 경험치를 &a차감&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(cxp) + " &8➜ &a" + Util.getBalance(new User(target).getMinExperience())));
            }
        } else if (args[1].equalsIgnoreCase("points")) {
            if (args[2].equalsIgnoreCase("set")) {
                int cpoints = new User(target).getPoints();
                new User(target).setPoints(value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 포인트를 &a설정&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(cpoints) + " &8➜ &a" + Util.getBalance(new User(target).getPoints())));
            } else if (args[2].equalsIgnoreCase("give")) {
                int cpoints = new User(target).getPoints();
                new User(target).setPoints(cpoints + value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 포인트를 &a추가&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(cpoints) + " &8➜ &a" + Util.getBalance(new User(target).getPoints())));
            } else if (args[2].equalsIgnoreCase("remove")) {
                int cpoints = new User(target).getPoints();
                new User(target).setPoints(cpoints - value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 포인트를 &a차감&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(cpoints) + " &8➜ &a" + Util.getBalance(new User(target).getPoints())));
            }
        } else if (args[1].equalsIgnoreCase("kills")) {
            if (args[2].equalsIgnoreCase("set")) {
                int ckills = new User(target).getKills();
                new User(target).setKills(value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 총 킬를 &a설정&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(ckills) + " &8➜ &a" + Util.getBalance(new User(target).getKills())));
            } else if (args[2].equalsIgnoreCase("give")) {
                int ckills = new User(target).getKills();
                new User(target).setKills(ckills + value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 총 킬를 &a추가&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(ckills) + " &8➜ &a" + Util.getBalance(new User(target).getKills())));
            } else if (args[2].equalsIgnoreCase("remove")) {
                int ckills = new User(target).getKills();
                new User(target).setKills(ckills - value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 총 킬를 &a차감&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(ckills) + " &8➜ &a" + Util.getBalance(new User(target).getKills())));
            }
        } else if (args[1].equalsIgnoreCase("deaths")) {
            if (args[2].equalsIgnoreCase("set")) {
                int cdeaths = new User(target).getDeaths();
                new User(target).setDeaths(value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 총 사망를 &a설정&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(cdeaths) + " &8➜ &a" + Util.getBalance(new User(target).getDeaths())));
            } else if (args[2].equalsIgnoreCase("give")) {
                int cdeaths = new User(target).getDeaths();
                new User(target).setDeaths(cdeaths + value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 총 사망를 &a추가&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(cdeaths) + " &8➜ &a" + Util.getBalance(new User(target).getDeaths())));
            } else if (args[2].equalsIgnoreCase("remove")) {
                int cdeaths = new User(target).getDeaths();
                new User(target).setDeaths(cdeaths - value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 총 사망를 &a차감&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(cdeaths) + " &8➜ &a" + Util.getBalance(new User(target).getDeaths())));
            }
        } else if (args[1].equalsIgnoreCase("keys")) {
            if (args[2].equalsIgnoreCase("set")) {
                int ckeys = new User(target).getKeys();
                new User(target).setKeys(value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 랜덤상자 열쇠를 &a설정&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(ckeys) + " &8➜ &a" + Util.getBalance(new User(target).getKeys())));
            } else if (args[2].equalsIgnoreCase("give")) {
                int ckeys = new User(target).getKeys();
                new User(target).setKeys(ckeys + value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 랜덤상자 열쇠를 &a추가&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(ckeys) + " &8➜ &a" + Util.getBalance(new User(target).getKeys())));
            } else if (args[2].equalsIgnoreCase("remove")) {
                int ckeys = new User(target).getKeys();
                new User(target).setKeys(ckeys - value);
                player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 랜덤상자 열쇠를 &a차감&f하셨습니다."));
                player.sendMessage(getColor(ffa.getPrefix() + "&f현황 : &a" + Util.getBalance(ckeys) + " &8➜ &a" + Util.getBalance(new User(target).getKeys())));
            }
        } else {
            player.sendMessage(getColor(ffa.getPrefix() + "&f존재하지 않는 명령어입니다."));
            return;
        }
    }

}
