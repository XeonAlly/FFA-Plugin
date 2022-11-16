package in.ffa.project.nickname;

import in.ffa.project.util.FileScript;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import static in.ffa.project.util.Util.*;

public class NickName {

    private Player player;

    public NickName(Player player) {
        this.player = player;
        new FileScript("nicknames.yml").Save();
    }

    public void Start() {
        PacketPlayOutChat packet = new PacketPlayOutChat(IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + getColor("&f당신은 현재 &c닉네임 변경 &f상태입니다.") + "\"}"), (byte) 2);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

}
