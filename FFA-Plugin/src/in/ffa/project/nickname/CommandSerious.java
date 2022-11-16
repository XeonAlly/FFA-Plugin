package in.ffa.project.nickname;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandSerious implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String arg, String[] args) {

        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("nick")) {

        }

        return false;
    }
}
