package me.rxndmz.voidfishing.Enchants;

import me.rxndmz.voidfishing.Loot.Fish.*;
import me.rxndmz.voidfishing.Loot.LootHandler;
import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

public class EnchantHandler {

    private static VoidFishing plugin = VoidFishing.getPlugin();

    // double roll //

    public static boolean rollDouble(int level) {
        double x = Math.random();
        switch (level) {
            case 1:
                if (x < 0.10) {
                    return true;
                }
            case 2:
                if (x < 0.20) {
                    return true;
                }
            case 3:
                if (x < 0.35) {
                    return true;
                }
        }
        return false;
    }

    // Lucky roll methods //

    public static ItemStack rollLucky(MYTHIC_FISH fish) {
        ItemStack firstRoll = LootHandler.getFish(fish);
        ItemStack secondRoll = LootHandler.getFish(fish);
        NamespacedKey key = new NamespacedKey(plugin, "worth");
        if (firstRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE) > secondRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE)) {
            return firstRoll;
        } else {
            return secondRoll;
        }
    }

    public static ItemStack rollLucky(LEGENDARY_FISH fish) {
        ItemStack firstRoll = LootHandler.getFish(fish);
        ItemStack secondRoll = LootHandler.getFish(fish);
        NamespacedKey key = new NamespacedKey(plugin, "worth");
        if (firstRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE) > secondRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE)) {
            return firstRoll;
        } else {
            return secondRoll;
        }
    }

    public static ItemStack rollLucky(RARE_FISH fish) {
        ItemStack firstRoll = LootHandler.getFish(fish);
        ItemStack secondRoll = LootHandler.getFish(fish);
        NamespacedKey key = new NamespacedKey(plugin, "worth");
        if (firstRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE) > secondRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE)) {
            return firstRoll;
        } else {
            return secondRoll;
        }
    }

    public static ItemStack rollLucky(UNCOMMON_FISH fish) {
        ItemStack firstRoll = LootHandler.getFish(fish);
        ItemStack secondRoll = LootHandler.getFish(fish);
        NamespacedKey key = new NamespacedKey(plugin, "worth");
        if (firstRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE) > secondRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE)) {
            return firstRoll;
        } else {
            return secondRoll;
        }
    }

    public static ItemStack rollLucky(COMMON_FISH fish) {
        ItemStack firstRoll = LootHandler.getFish(fish);
        ItemStack secondRoll = LootHandler.getFish(fish);
        NamespacedKey key = new NamespacedKey(plugin, "worth");
        if (firstRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE) > secondRoll.getItemMeta().getPersistentDataContainer().get(key, PersistentDataType.DOUBLE)) {
            return firstRoll;
        } else {
            return secondRoll;
        }
    }

}
