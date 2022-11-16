package in.ffa.project.command.commands.impl;

import in.ffa.project.FFA;
import in.ffa.project.util.Util;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        FFA ffa = FFA.getPlugin(FFA.class);
        Player player = (Player) commandSender;

        player.sendMessage(Util.getColor(FFA.getInstance().getPrefix() + "&f설정 파일을 다시 불러오는 중..."));
        ffa.reloadConfig();
        player.sendMessage(Util.getColor(FFA.getInstance().getPrefix() + "&f성공적으로 설정 파일을 불러왔습니다!"));
    }

}
