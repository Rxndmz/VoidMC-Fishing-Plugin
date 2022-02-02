package me.rxndmz.voidfishing.Loot;

import me.rxndmz.voidfishing.Chat.MessageHandler;
import me.rxndmz.voidfishing.Data.CoolerData;
import me.rxndmz.voidfishing.Data.PlayerData;
import me.rxndmz.voidfishing.Enchants.CustomEnchants;
import me.rxndmz.voidfishing.Enchants.EnchantHandler;
import me.rxndmz.voidfishing.Loot.Fish.*;
import me.rxndmz.voidfishing.VoidFishing;
import me.rxndmz.voidfishing.events.GainedXP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LootHandler {

    // length is old // weight is new //

    private static VoidFishing plugin = VoidFishing.getPlugin();

    public static void rollFish(Player player, ItemStack rod) throws IOException {
        int level = PlayerData.getData().getConfigurationSection(player.getUniqueId().toString()).getInt("Fishing Level");
        double rand = Math.random();
        switch (level) {
            case 1:
                rollCommon(player, rod);
                break;
            case 2:
                if (rand < 0.30) {
                    rollUncommon(player, rod);
                } else if (rand >= 0.30) {
                    rollCommon(player, rod);
                }
                break;
            case 3:
                if (rand < 0.10) {
                    rollRare(player, rod);
                } else if (rand >= 0.10 && rand < 0.35) {
                    rollUncommon(player, rod);
                } else if (rand >= 0.35) {
                    rollCommon(player, rod);
                }
                break;
            case 4:
                if (rand < 0.08) {
                    rollLegendary(player, rod);
                } else if ( rand >= 0.08 && rand < 0.20) {
                    rollRare(player, rod);
                } else if (rand >= 0.20 && rand < 0.40) {
                    rollUncommon(player, rod);
                } else if (rand >= 0.40) {
                    rollCommon(player, rod);
                }
                break;
            case 5:
                if (rand < 0.03) {
                    rollMythic(player, rod);
                } else if ( rand >= 0.03 && rand < 0.10) {
                    rollLegendary(player, rod);
                } else if (rand >= 0.10 && rand < 0.25) {
                    rollRare(player, rod);
                } else if (rand >= 0.25 && rand < 0.50) {
                    rollUncommon(player, rod);
                } else if (rand >= 0.50) {
                    rollCommon(player, rod);
                }
                break;
        }
        if (level > 5) {
            if (rand < 0.03) {
                rollMythic(player, rod);
            } else if ( rand >= 0.03 && rand < 0.10) {
                rollLegendary(player, rod);
            } else if (rand >= 0.10 && rand < 0.25) {
                rollRare(player, rod);
            } else if (rand >= 0.25 && rand < 0.50) {
                rollUncommon(player, rod);
            } else if (rand >= 0.50) {
                rollCommon(player, rod);
            }
        }
    }

    public static void rollCommon(Player player, ItemStack rod) throws IOException {
        double x = Math.random();
        ConfigurationSection cfg = plugin.getConfig().getConfigurationSection("Xp Rates").getConfigurationSection("Common");
        int xp = ThreadLocalRandom.current().nextInt(cfg.getInt("Lowest"), cfg.getInt("Highest") + 1);
        if (x <= 0.25) {
            // Bass
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(COMMON_FISH.BASS);
            } else {
                fish = getFish(COMMON_FISH.BASS);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GRAY, "COMMON", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GRAY, "COMMON", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.25 && x <= 0.50) {
            // Goldfish
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(COMMON_FISH.GOLDFISH);
            } else {
                fish = getFish(COMMON_FISH.GOLDFISH);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GRAY, "COMMON", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GRAY, "COMMON", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.50 && x <= 0.75) {
            // Carp
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(COMMON_FISH.CARP);
            } else {
                fish = getFish(COMMON_FISH.CARP);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GRAY, "COMMON", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GRAY, "COMMON", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.75 && x <= 1.00) {
            // Salmon
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(COMMON_FISH.SALMON);
            } else {
                fish = getFish(COMMON_FISH.SALMON);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GRAY, "COMMON", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GRAY, "COMMON", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        }
    }

    public static void rollUncommon(Player player, ItemStack rod) throws IOException {
        double x = Math.random();
        ConfigurationSection cfg = plugin.getConfig().getConfigurationSection("Xp Rates").getConfigurationSection("Uncommon");
        int xp = ThreadLocalRandom.current().nextInt(cfg.getInt("Lowest"), cfg.getInt("Highest") + 1);
        if (x <= 0.25) {
            // Roach
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(UNCOMMON_FISH.ROACH);
            } else {
                fish = getFish(UNCOMMON_FISH.ROACH);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GREEN, "UNCOMMON", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GREEN, "UNCOMMON", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.25 && x <= 0.50) {
            // Catfish
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(UNCOMMON_FISH.CATFISH);
            } else {
                fish = getFish(UNCOMMON_FISH.CATFISH);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GREEN, "UNCOMMON", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GREEN, "UNCOMMON", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.50 && x <= 0.75) {
            // Pufferfish
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(UNCOMMON_FISH.PUFFERFISH);
            } else {
                fish = getFish(UNCOMMON_FISH.PUFFERFISH);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GREEN, "UNCOMMON", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GREEN, "UNCOMMON", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.75 && x <= 1.00) {
            // Pike
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(UNCOMMON_FISH.PIKE);
            } else {
                fish = getFish(UNCOMMON_FISH.PIKE);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GREEN, "UNCOMMON", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GREEN, "UNCOMMON", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        }
    }

    public static void rollRare(Player player, ItemStack rod) throws IOException {
        double x = Math.random();
        ConfigurationSection cfg = plugin.getConfig().getConfigurationSection("Xp Rates").getConfigurationSection("Rare");
        int xp = ThreadLocalRandom.current().nextInt(cfg.getInt("Lowest"), cfg.getInt("Highest") + 1);
        if (x <= 0.25) {
            // Eel
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(RARE_FISH.EEL);
            } else {
                fish = getFish(RARE_FISH.EEL);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.AQUA, "RARE", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.AQUA, "RARE", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.25 && x <= 0.50) {
            // Koi
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(RARE_FISH.KOI);
            } else {
                fish = getFish(RARE_FISH.KOI);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.AQUA, "RARE", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.AQUA, "RARE", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.50 && x <= 0.75) {
            // Trout
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(RARE_FISH.TROUT);
            } else {
                fish = getFish(RARE_FISH.TROUT);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.AQUA, "RARE", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.AQUA, "RARE", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.75 && x <= 1.00) {
            // Tuna
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(RARE_FISH.TUNA);
            } else {
                fish = getFish(RARE_FISH.TUNA);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.AQUA, "RARE", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.AQUA, "RARE", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        }
    }

    public static void rollLegendary(Player player, ItemStack rod) throws IOException {
        double x = Math.random();
        ConfigurationSection cfg = plugin.getConfig().getConfigurationSection("Xp Rates").getConfigurationSection("Legendary");
        int xp = ThreadLocalRandom.current().nextInt(cfg.getInt("Lowest"), cfg.getInt("Highest") + 1);
        if (x <= 0.25) {
            // Sunfish
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(LEGENDARY_FISH.SUNFISH);
            } else {
                fish = getFish(LEGENDARY_FISH.SUNFISH);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GOLD, "LEGENDARY", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GOLD, "LEGENDARY", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.25 && x <= 0.50) {
            // Oarfish
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(LEGENDARY_FISH.OARFISH);
            } else {
                fish = getFish(LEGENDARY_FISH.OARFISH);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GOLD, "LEGENDARY", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GOLD, "LEGENDARY", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.50 && x <= 0.75) {
            // Sawfish
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(LEGENDARY_FISH.SAWFISH);
            } else {
                fish = getFish(LEGENDARY_FISH.SAWFISH);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GOLD, "LEGENDARY", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GOLD, "LEGENDARY", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        } else if (x > 0.75 && x <= 1.00) {
            // Swordfish
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(LEGENDARY_FISH.SWORDFISH);
            } else {
                fish = getFish(LEGENDARY_FISH.SWORDFISH);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GOLD, "LEGENDARY", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.GOLD, "LEGENDARY", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
        }
    }

    public static void rollMythic(Player player, ItemStack rod) throws IOException {
        double x = Math.random();
        ConfigurationSection cfg = plugin.getConfig().getConfigurationSection("Xp Rates").getConfigurationSection("Mythic");
        int xp = ThreadLocalRandom.current().nextInt(cfg.getInt("Lowest"), cfg.getInt("Highest") + 1);
        if (x <= 0.25) {
            // Kraken
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(MYTHIC_FISH.KRAKEN);
            } else {
                fish = getFish(MYTHIC_FISH.KRAKEN);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE, "MYTHIC", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE, "MYTHIC", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.00f, 1.00f);
        } else if (x > 0.25 && x <= 0.50) {
            // Megalodon
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(MYTHIC_FISH.MEGALODON);
            } else {
                fish = getFish(MYTHIC_FISH.MEGALODON);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE, "MYTHIC", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE, "MYTHIC", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.00f, 1.00f);
        } else if (x > 0.50 && x <= 0.75) {
            // Great White Shark
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(MYTHIC_FISH.GREAT_WHITE_SHARK);
            } else {
                fish = getFish(MYTHIC_FISH.GREAT_WHITE_SHARK);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE, "MYTHIC", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE, "MYTHIC", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.00f, 1.00f);
        } else if (x > 0.75 && x <= 1.00) {
            // Tiger Shark
            ItemStack fish;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.LUCKY)) {
                fish = EnchantHandler.rollLucky(MYTHIC_FISH.TIGER_SHARK);
            } else {
                fish = getFish(MYTHIC_FISH.TIGER_SHARK);
            }
            boolean successful = false;
            if (rod.getItemMeta().hasEnchant(CustomEnchants.DOUBLE)) {
                switch (rod.getItemMeta().getEnchantLevel(CustomEnchants.DOUBLE)) {
                    case 1:
                        if (EnchantHandler.rollDouble(1)) {
                            successful = true;
                        }
                    case 2:
                        if (EnchantHandler.rollDouble(2)) {
                            successful = true;
                        }
                    case 3:
                        if (EnchantHandler.rollDouble(3)) {
                            successful = true;
                        }
                }
            }
            if (successful) {
                ItemStack i = fish.clone();
                ItemMeta meta = i.getItemMeta();
                meta.setDisplayName(meta.getDisplayName() + format(" &8(doubled)"));
                i.setItemMeta(meta);
                CoolerData.addToCooler(player, i);
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE, "MYTHIC", true);
            } else {
                MessageHandler.successfulCatch(player, fish.getItemMeta().getDisplayName(), ChatColor.LIGHT_PURPLE, "MYTHIC", false);
            }
            CoolerData.addToCooler(player, fish);
            Bukkit.getServer().getPluginManager().callEvent(new GainedXP(xp, player, rod));
            player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1.00f, 1.00f);
        }
    }

    public static ItemStack getFish(COMMON_FISH fish) {
        Integer length = getLength(fish.getWeightLow(), fish.getWeightHigh());
        Double worth = calcWorth(length, fish.getWeightHigh(), fish.getWeightLow(), fish.getBaseValue());
        return buildItem(fish.getItem(), fish.getName(), "Common", length.toString(), buildWorthLore(worth), worth);
    }

    public static ItemStack getFish(UNCOMMON_FISH fish) {
        Integer length = getLength(fish.getWeightLow(), fish.getWeightHigh());
        Double worth = calcWorth(length, fish.getWeightHigh(), fish.getWeightLow(), fish.getBaseValue());
        return buildItem(fish.getItem(), fish.getName(), "Uncommon", length.toString(), buildWorthLore(worth), worth);
    }

    public static ItemStack getFish(RARE_FISH fish) {
        Integer length = getLength(fish.getWeightLow(), fish.getWeightHigh());
        Double worth = calcWorth(length, fish.getWeightHigh(), fish.getWeightLow(), fish.getBaseValue());
        return buildItem(fish.getItem(), fish.getName(), "Rare", length.toString(), buildWorthLore(worth), worth);
    }

    public static ItemStack getFish(LEGENDARY_FISH fish) {
        Integer length = getLength(fish.getWeightLow(), fish.getWeightHigh());
        Double worth = calcWorth(length, fish.getWeightHigh(), fish.getWeightLow(), fish.getBaseValue());
        return buildItem(fish.getItem(), fish.getName(), "Legendary", length.toString(), buildWorthLore(worth), worth);
    }

    public static ItemStack getFish(MYTHIC_FISH fish) {
        Integer length = getLength(fish.getWeightLow(), fish.getWeightHigh());
        Double worth = calcWorth(length, fish.getWeightHigh(), fish.getWeightLow(), fish.getBaseValue());
        return buildItem(fish.getItem(), fish.getName(), "Mythic", length.toString(), buildWorthLore(worth), worth);
    }

    private static double calcWorth(int length, int lengthHigh, int lengthLow, double worth) {
        double x = lengthHigh - lengthLow;
        double z = x / 100;
        for (int i = 0; i < 101; i++) {
            if (length < (lengthLow + (z * i))) {
                worth = worth + (worth * (((i * 0.01)) / 3));
                return worth;
            }
        }
        return worth;
    }

    private static String buildWorthLore(Double worth) {
        int i = (int) Math.round(worth);
        String str = String.valueOf(i);
        if (str.length() >= 4 && str.length() <= 6) {
            if (str.length() == 4) {
                str = str.substring(0, 1) + "." + str.substring(1,2) + "K";
            } else {
                str = str.substring(0, 2) + "." + str.substring(2,3) + "K";
            }
            return str;
        } else if (str.length() >= 7 && str.length() <= 9) {
            if (str.length() == 7) {
                str = str.substring(0, 1) + "." + str.substring(1,2) + "M";
            } else {
                str = str.substring(0, 2) + "." + str.substring(2,3) + "M";
            }
            return str;
        }
        return str;
    }

    private static Integer getLength(Integer low, Integer high) {
        Integer r = (int) (Math.random() * (high - low)) + low;
        return r;
    }

    private static ItemStack buildItem(ItemStack item, String name, String rarity, String length, String worth, Double actualWorth) {
        ItemMeta meta = item.getItemMeta();
        NamespacedKey key = new NamespacedKey(plugin, "worth");
        NamespacedKey key2 = new NamespacedKey(plugin, "rarity");
        meta.getPersistentDataContainer().set(key, PersistentDataType.DOUBLE, actualWorth);
        meta.getPersistentDataContainer().set(key2, PersistentDataType.STRING, rarity);
        System.out.println(meta.getPersistentDataContainer().get(key, PersistentDataType.DOUBLE));
        String common = ChatColor.GRAY + "" + ChatColor.BOLD + "COMMON";
        String uncommon = ChatColor.GREEN + "" + ChatColor.BOLD + "UNCOMMON";
        String rare = ChatColor.AQUA + "" + ChatColor.BOLD + "RARE";
        String legendary = ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY";
        String mythic = ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "MYTHIC";
        List<String> lore = new ArrayList<String>();
        switch(rarity) {
            case "Common":
                // its common
                meta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + name);
                lore.add(ChatColor.WHITE + "Rarity: " + common);
                lore.add(ChatColor.WHITE + "Weight: " + ChatColor.BOLD + length + "lbs");
                lore.add(ChatColor.WHITE + "Worth: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + worth);
                meta.setLore(lore);
                item.setItemMeta(meta);
                return item;
            case "Uncommon":
                // its uncommon
                meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + name);
                lore.add(ChatColor.WHITE + "Rarity: " + uncommon);
                lore.add(ChatColor.WHITE + "Weight: " + ChatColor.BOLD + length + "lbs");
                lore.add(ChatColor.WHITE + "Worth: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + worth);
                meta.setLore(lore);
                item.setItemMeta(meta);
                return item;
            case "Rare":
                // its rare
                meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + name);
                lore.add(ChatColor.WHITE + "Rarity: " + rare);
                lore.add(ChatColor.WHITE + "Weight: " + ChatColor.BOLD + length + "lbs");
                lore.add(ChatColor.WHITE + "Worth: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + worth);
                meta.setLore(lore);
                item.setItemMeta(meta);
                return item;
            case "Legendary":
                // its legendary
                meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + name);
                lore.add(ChatColor.WHITE + "Rarity: " + legendary);
                lore.add(ChatColor.WHITE + "Weight: " + ChatColor.BOLD + length + "lbs");
                lore.add(ChatColor.WHITE + "Worth: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + worth);
                meta.setLore(lore);
                item.setItemMeta(meta);
                return item;
            case "Mythic":
                // its mythic
                meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + name);
                lore.add(ChatColor.WHITE + "Rarity: " + mythic);
                lore.add(ChatColor.WHITE + "Weight: " + ChatColor.BOLD + length + "lbs");
                lore.add(ChatColor.WHITE + "Worth: " + ChatColor.GREEN + "" + ChatColor.BOLD + "$" + worth);
                meta.setLore(lore);
                item.setItemMeta(meta);
                return item;
        }
        return item;
    }

    private static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
