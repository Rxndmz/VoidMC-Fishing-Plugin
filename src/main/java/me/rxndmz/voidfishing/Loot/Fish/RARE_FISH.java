package me.rxndmz.voidfishing.Loot.Fish;

import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum RARE_FISH {
    TUNA("Tuna", new ItemStack(Material.SALMON), 40, 60, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Rare").getDouble("Tuna")),
    TROUT("Trout", new ItemStack(Material.COD), 5, 12, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Rare").getDouble("Trout")),
    EEL("Eel", new ItemStack(Material.COD), 26, 34, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Rare").getDouble("Eel")),
    KOI("Koi", new ItemStack(Material.TROPICAL_FISH), 10, 18, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Rare").getDouble("Koi"));

    String name;
    ItemStack item;
    Integer weightLow;
    Integer weightHigh;
    Double baseValue;

    RARE_FISH(String name, ItemStack item, Integer weightLow, Integer weightHigh, Double baseValue) {
        this.name = name;
        this.item = item;
        this.weightLow = weightLow;
        this.weightHigh = weightHigh;
        this.baseValue = baseValue;
    }

    public String getName() {
        return name;
    }

    public ItemStack getItem() {
        return item;
    }

    public Integer getWeightLow() {
        return weightLow;
    }

    public Integer getWeightHigh() {
        return weightHigh;
    }

    public Double getBaseValue() { return baseValue; }
}
