package in.ffa.project.command.commands.impl;

import in.ffa.project.FFA;
import in.ffa.project.util.Util;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class SetSpawnCommand {

    public void execute(String[] args, String s, CommandSender commandSender) {
        FFA ffa = FFA.getPlugin(FFA.class);
        Player player = (Player) commandSender;

        FileConfiguration config = ffa.getConfig();
        World world = player.getWorld();
        double x = player.getLocation().getX();
        double y = player.getLocation().getY();
        double z = player.getLocation().getZ();
        double yaw = player.getLocation().getYaw();
        double pitch = player.getLocation().getPitch();

        config.set("world.location.spawn.world", world.getName());
        config.set("world.location.spawn.x", x);
        config.set("world.location.spawn.y", y);
        config.set("world.location.spawn.z", z);
        config.set("world.location.spawn.yaw", yaw);
        config.set("world.location.spawn.pitch", pitch);
        try {config.save(new File(ffa.getDataFolder() + "/config.yml"));} catch (Exception e) {return;}
        player.sendMessage(Util.getColor(FFA.getInstance().getPrefix() + "&f성공적으로 THE FFA 스폰을 설정하셨습니다."));
    }

}
