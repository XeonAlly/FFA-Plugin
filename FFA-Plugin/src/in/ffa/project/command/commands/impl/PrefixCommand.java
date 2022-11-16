package in.ffa.project.command.commands.impl;

import in.ffa.project.FFA;
import in.ffa.project.user.User;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static in.ffa.project.util.Util.*;

public class PrefixCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        FFA ffa = FFA.getPlugin(FFA.class);
        Player player = (Player) commandSender;

        if (args.length < 3) {
            player.spigot().sendMessage(getText(ffa.getPrefix() + "/ffa setprefix &a➜ &f[THE FFA 칭호를 설정합니다.]", ffa.getPrefix() + "/ffa setprefix (player) (value)"));
            return;
        }

        Player target = Bukkit.getPlayer(args[1]);
        if (target == null) {
            player.sendMessage(getColor(ffa.getPrefix() + "&f오프라인 상태인 플레이어입니다."));
            return;
        }

        String prefix = args[2];
        if (prefix.equalsIgnoreCase("AIR"))
            prefix = "";
        new User(target).setPrefix(prefix);
        player.sendMessage(getColor(ffa.getPrefix() + "&a[" + target.getName() + "&a]&f의 칭호를 &a설정&f하셨습니다."));
        player.sendMessage(getColor(ffa.getPrefix() + "&f설정된 칭호 : &a" + new User(target).getPrefix()));
    }

}
