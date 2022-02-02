package me.rxndmz.voidfishing.Data;

import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PlayerData {

    private static VoidFishing plugin = VoidFishing.getPlugin();

    private static File file;
    private static FileConfiguration plrData;

    public static void setup() {
        file = new File(plugin.getDataFolder(), "PlayerData.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        plrData = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration getData() { return plrData; }

    public static void saveData() {
        try {
            plrData.save(file);
        } catch (IOException e) {
            System.out.println("[Void Fishing] Failed to save player data.");
        }
    }

    public static void reloadData() { plrData = YamlConfiguration.loadConfiguration(file); }

}
