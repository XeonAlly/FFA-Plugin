package in.ffa.project.command.commands;

import in.ffa.project.FFA;
import in.ffa.project.command.commands.impl.*;
import in.ffa.project.util.Util;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class MainCommand extends BukkitCommand {

    private final SetSpawnCommand setSpawnCommand = new SetSpawnCommand();
    private final SetKitCommand setKitCommand = new SetKitCommand();
    private final ReloadCommand reloadCommand = new ReloadCommand();
    private final BuildCommand buildCommand = new BuildCommand();
    private final StatsCommand statsCommand = new StatsCommand();
    private final PrefixCommand prefixCommand = new PrefixCommand();
    private final RandomBoxCommand randomBoxCommand = new RandomBoxCommand();
    private final TopCommand topCommand = new TopCommand();

    public MainCommand(String name) {
        super(name);
        this.description = "THE FFA command.";
        this.usageMessage = "/" + name;
        this.setAliases(new ArrayList<>());
    }

    @Override
    public boolean execute(CommandSender commandSender, String commandLabel, String[] args) {
        if (commandLabel.equalsIgnoreCase("ffa")) {
            if (commandSender.isOp() || commandSender.hasPermission("ffa.commands")) {
                if (args.length < 1) {
                    Player player = (Player) commandSender;

                    FFA.getInstance().getCommandManager().getCommandList().forEach(command -> {TextComponent textComponent = new TextComponent(Util.getColor(FFA.getInstance().getPrefix() + "&f/" + command.getCommand() + " &a➜ &f" + command.getDescription()));
                        textComponent.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder((command.getUsage() != null ? Util.getColor(FFA.getInstance().getPrefix() + "&f" + command.getUsage()) : Util.getColor(FFA.getInstance().getPrefix() + "&f사용법을 불러오지 못했습니다."))).create()));
                        player.spigot().sendMessage(textComponent);
                    });
                } else {
                    String s = args[0];
                    boolean found = false;

                    if (s.equalsIgnoreCase("setspawn")) {
                        found = true;
                        setSpawnCommand.execute(args, s, commandSender);
                    } else if (s.equalsIgnoreCase("setkit")) {
                        found = true;
                        setKitCommand.execute(args, s, commandSender);
                    } else if (s.equalsIgnoreCase("reload")) {
                        found = true;
                        reloadCommand.execute(args, s, commandSender);
                    } else if (s.equalsIgnoreCase("build")) {
                        found = true;
                        buildCommand.execute(args, s, commandSender);
                    } else if (s.equalsIgnoreCase("stats")) {
                        found = true;
                        statsCommand.execute(args, s, commandSender);
                    } else if (s.equalsIgnoreCase("setprefix")) {
                        found = true;
                        prefixCommand.execute(args, s, commandSender);
                    } else if (s.equalsIgnoreCase("randombox")) {
                        found = true;
                        randomBoxCommand.execute(args, s, commandSender);
                    } else if (s.equalsIgnoreCase("top")) {
                        found = true;
                        topCommand.execute(args, s, commandSender);
                    }

                    if (!found) commandSender.sendMessage(Util.getColor(FFA.getInstance().getPrefix() + "&f존재하지 않는 명령어입니다."));
                }
            } else {
                commandSender.sendMessage(Util.getColor(FFA.getInstance().getPrefix() + "&f당신은 이 명령어를 사용할 권한이 존재하지 않습니다."));
            }
        }
        return false;
    }

}
