package in.ffa.project.util;

import in.ffa.project.FFA;
import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.Set;

public class FileScript {

    private YamlConfiguration config;
    private String path;
    private File file;
    private FFA ffa;

    public FileScript(String path) {
        this.path = path;
        this.ffa = FFA.getPlugin(FFA.class);
        this.file = new File(this.ffa.getDataFolder() + "/" + this.path);
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public void Save() {
        try {
            this.file.createNewFile();
            this.config.save(this.file);
        } catch (Exception e) {return;}
    }

    public void Delete() {
        this.file.delete();
    }

    public void set(String path, Object obj) {
        this.config.set(path, obj);
        try {this.config.save(this.file);} catch (Exception e) {return;}
    }

    public Object get(String name) {
        return this.config.get(name);
    }

    public int getInt(String name) {
        return this.config.getInt(name);
    }

    public boolean contains(String path) {
        return this.config.contains(path);
    }

    public File[] listFiles() {
        return this.file.listFiles();
    }

    public Location getLocation() {
        return (Location) this.config.get("box.location");
    }

    public Set<String> getSet(String name) {
        return this.config.getConfigurationSection(name).getKeys(false);
    }

}
