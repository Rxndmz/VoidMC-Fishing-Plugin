package me.rxndmz.voidfishing.Loot.Fish;

import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum COMMON_FISH {

    CARP("Carp", new ItemStack(Material.TROPICAL_FISH), 15, 35, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Common").getDouble("Carp")),
    GOLDFISH("Goldfish", new ItemStack(Material.TROPICAL_FISH), 5, 15, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Common").getDouble("Goldfish")),
    SALMON("Salmon", new ItemStack(Material.SALMON), 8, 20, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Common").getDouble("Salmon")),
    BASS("Bass", new ItemStack(Material.COD), 9, 19, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Common").getDouble("Bass"));

    String name;
    ItemStack item;
    Integer weightLow;
    Integer weightHigh;
    Double baseValue;

    COMMON_FISH(String name, ItemStack item, Integer weightLow, Integer weightHigh, Double baseValue) {
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
