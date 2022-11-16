package in.ffa.project.command.commands.impl;

import in.ffa.project.util.RandomBox;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RandomBoxCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        Player player = (Player) commandSender;

        Location loc = player.getLocation();
        RandomBox.spawnHologram(loc);
    }

}
