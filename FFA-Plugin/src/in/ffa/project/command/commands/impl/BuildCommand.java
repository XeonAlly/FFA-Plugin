package in.ffa.project.command.commands.impl;

import in.ffa.project.FFA;
import in.ffa.project.util.BuildUtil;
import in.ffa.project.util.Util;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BuildCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        Player player = (Player) commandSender;

        if (BuildUtil.getBuilds().contains(player)) {
            BuildUtil.remove(player);
            player.sendMessage(Util.getColor(FFA.getInstance().getPrefix() + "&f건축 모드를 &c비활성화&f하셨습니다."));
        } else {
            BuildUtil.add(player);
            player.sendMessage(Util.getColor(FFA.getInstance().getPrefix() + "&f건축 모드를 &a활성화&f하셨습니다."));
        }
    }

}
