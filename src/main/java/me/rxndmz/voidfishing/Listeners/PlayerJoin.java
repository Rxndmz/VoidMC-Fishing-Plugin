package me.rxndmz.voidfishing.Listeners;

import me.rxndmz.voidfishing.Data.CoolerData;
import me.rxndmz.voidfishing.Data.PlayerData;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void OnPlayerJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        FileConfiguration data = PlayerData.getData();
        if (!data.contains(player.getUniqueId().toString())) {
            data.createSection(player.getUniqueId().toString());
            data.getConfigurationSection(player.getUniqueId().toString()).addDefault("Total XP", 0);
            data.getConfigurationSection(player.getUniqueId().toString()).addDefault("Scraps", 0);
            data.getConfigurationSection(player.getUniqueId().toString()).addDefault("Fishing Level", 1);
            data.getConfigurationSection(player.getUniqueId().toString()).addDefault("Cooler Size", 9);
            data.getConfigurationSection(player.getUniqueId().toString()).addDefault("Cooler Upgrades", 0);
            data.getConfigurationSection(player.getUniqueId().toString()).addDefault("Cooler", null);
        }
        PlayerData.saveData();
        CoolerData.setup(player);
    }

}
