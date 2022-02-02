package me.rxndmz.voidfishing.LevelSystem;

import me.rxndmz.voidfishing.Chat.MessageHandler;
import me.rxndmz.voidfishing.Data.PlayerData;
import me.rxndmz.voidfishing.Enchants.CustomEnchants;
import me.rxndmz.voidfishing.VoidFishing;
import me.rxndmz.voidfishing.events.GainedXP;
import me.rxndmz.voidfishing.events.LevelUp;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.Objects;

public class LevelHandler implements Listener {

    @EventHandler
    public void gainedXp(GainedXP e) {
        Player player = e.getPlayer();
        int xp = e.getXp();
        if (e.getRod().getItemMeta().hasEnchant(CustomEnchants.CHARMED)) {
            switch (e.getRod().getItemMeta().getEnchantLevel(CustomEnchants.CHARMED)) {
                case 1:
                    xp = ((xp / 100) * 5) + xp;
                case 2:
                    xp = ((xp / 100) * 12) + xp;
                case 3:
                    xp = ((xp / 100) * 25) + xp;
            }
        }
        addXp(player, xp);
        MessageHandler.xpEarned(player, xp);
        if (checkLevel(player)) {
            levelUp(player);
            Bukkit.getServer().getPluginManager().callEvent(new LevelUp(player, e.getLevel() + 1));
        }
    }

    public void addXp(Player player, int xp) {
        FileConfiguration playerData = PlayerData.getData();
        Integer totalXp = Objects.requireNonNull(playerData.getConfigurationSection(player.getUniqueId().toString())).getInt("Total XP");
        Objects.requireNonNull(playerData.getConfigurationSection(player.getUniqueId().toString())).set("Total XP", totalXp + xp);
    }

    public boolean checkLevel(Player player) {
        FileConfiguration playerData = PlayerData.getData();
        Integer level = Objects.requireNonNull(playerData.getConfigurationSection(player.getUniqueId().toString())).getInt("Fishing Level");
        Integer totalXp = Objects.requireNonNull(playerData.getConfigurationSection(player.getUniqueId().toString())).getInt("Total XP");
        FileConfiguration levelData = VoidFishing.getPlugin().getConfig();
        List<Integer> levels = levelData.getIntegerList("Levels");
        if (levels.size() > level - 1) {
            return totalXp >= levels.get(level - 1);
        } else {
            return false;
        }
    }

    public void levelUp(Player player) {
        FileConfiguration playerData = PlayerData.getData();
        int level = Objects.requireNonNull(playerData.getConfigurationSection(player.getUniqueId().toString())).getInt("Fishing Level");
        Objects.requireNonNull(playerData.getConfigurationSection(player.getUniqueId().toString())).set("Fishing Level", level + 1);
        PlayerData.saveData();
    }

}
