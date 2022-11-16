package in.ffa.project.command;

import in.ffa.project.command.commands.MainCommand;
import in.ffa.project.util.CommandUtil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class CommandManager {

    private final List<Command> commandList = new ArrayList<>();

    public CommandManager() {
        addCommand(new Command(new MainCommand("ffa"), "ffa", null, "[THE FFA 플러그인 명령어입니다.]", true));

        addCommand(new Command(new MainCommand("ffa"), "ffa setspawn", "/ffa setspawn", "[THE FFA 스폰 장소를 설정합니다.]", true));

        addCommand(new Command(new MainCommand("ffa"), "ffa setkit", "/ffa setkit", "[THE FFA 킷 아이템을 설정합니다.]", true));

        addCommand(new Command(new MainCommand("ffa"), "ffa build", "/ffa build", "[THE FFA 건축 모드를 사용합니다.]", true));

        addCommand(new Command(new MainCommand("ffa"), "ffa reload", "/ffa reload", "[THE FFA 설정 파일을 불러옵니다.]", true));

        addCommand(new Command(new MainCommand("ffa"), "ffa stats", "/ffa stats [level/xp/points/kills/deaths/keys] [give/set/remove] (player) (value)", "[THE FFA 스텟 정보 관리합니다.]", true));

        addCommand(new Command(new MainCommand("ffa"), "ffa setprefix", "/ffa setprefix (player) (value)", "[THE FFA 칭호를 설정합니다.]", true));

        addCommand(new Command(new MainCommand("ffa"), "ffa randombox", "/ffa randombox", "[THE FFA 랜덤상자를 생성합니다.]", true));

        addCommand(new Command(new MainCommand("ffa"), "ffa top", "/ffa top", "[THE FFA 리더보드를 설정합니다.]", true));
    }

    private void addCommand(Command... commands) {
        for (Command command : commands) {
            commandList.add(command);
            if (command.isEnabled()) CommandUtil.registerCommand(command);
        }
    }

    public void removeCommand() {
        commandList.forEach(CommandUtil::unRegisterBukkitCommand);
    }

}
