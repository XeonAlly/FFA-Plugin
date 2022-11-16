package in.ffa.project.command.commands.impl;

import in.ffa.project.FFA;
import in.ffa.project.util.FileScript;
import in.ffa.project.util.Util;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TopCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        FFA ffa = FFA.getPlugin(FFA.class);
        Player player = (Player) commandSender;

        new FileScript("config.yml").set("game.leaderboards.levels-top", player.getLocation());
        player.sendMessage(Util.getColor(FFA.getInstance().getPrefix() + "&f성공적으로 THE FFA 스폰을 설정하셨습니다."));
    }

}
