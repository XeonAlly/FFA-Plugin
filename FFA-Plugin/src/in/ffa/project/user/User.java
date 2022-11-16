package in.ffa.project.user;

import in.ffa.project.FFA;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.UUID;

public class User {

    private UUID uuid;

    private File file;
    private YamlConfiguration config;
    private FFA ffa = FFA.getPlugin(FFA.class);

    public User(Player player) {
        this.uuid = player.getUniqueId();
        this.file = new File(ffa.getDataFolder() + "/users/" + this.uuid.toString() + ".yml");
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public User(UUID uuid) {
        this.uuid = uuid;
        this.file = new File(ffa.getDataFolder() + "/users/" + this.uuid.toString() + ".yml");
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void createPlayer() {
        if (!(this.file.exists())) try{this.file.createNewFile(); this.config.save(this.file);} catch (Exception e) {return;}
        if (!(contains("user.prefix")))
            setPrefix("Default");
        if (!(contains("user.level")))
            setLevel(1);
        if (!(contains("user.exp.min")))
            setMinExperience(0);
        if (!(contains("user.exp.max")))
            setMaxExperience(10);
        if (!(contains("user.points")))
            setPoints(0);
        if (!(contains("user.kills")))
            setKills(0);
        if (!(contains("user.deaths")))
            setDeaths(0);
        if (!(contains("user.keys")))
            setKeys(0);
    }

    public boolean contains(String name) {
        return this.config.contains(name);
    }

    public boolean is() {
        return this.file.exists();
    }

    public String getPrefix() {
        return this.config.get("user.prefix").toString();
    }

    public void setPrefix(String prefix) {
        this.config.set("user.prefix", prefix);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public int getLevel() {
        return this.config.getInt("user.level");
    }

    public void setLevel(int level) {
        this.config.set("user.level", level);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public int getMinExperience() {
        return this.config.getInt("user.exp.min");
    }

    public void setMinExperience(int minexp) {
        this.config.set("user.exp.min", minexp);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public int getMaxExperience() {
        return this.config.getInt("user.exp.max");
    }

    public void setMaxExperience(int maxexp) {
        this.config.set("user.exp.max", maxexp);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public int getPoints() {
        return this.config.getInt("user.points");
    }

    public void setPoints(int points) {
        this.config.set("user.points", points);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public int getKills() {
        return this.config.getInt("user.kills");
    }

    public void setKills(int kills) {
        this.config.set("user.kills", kills);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public int getDeaths() {
        return this.config.getInt("user.deaths");
    }

    public void setDeaths(int deaths) {
        this.config.set("user.deaths", deaths);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public int getKeys() {
        return (int) this.config.getInt("user.keys");
    }

    public void setKeys(int keys) {
        this.config.set("user.keys", keys);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

}
