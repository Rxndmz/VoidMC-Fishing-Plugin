package me.rxndmz.voidfishing.Loot.Fish;

import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum LEGENDARY_FISH {
    SAWFISH("Sawfish", new ItemStack(Material.SALMON), 1000, 1400, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Legendary").getDouble("Sawfish")),
    SUNFISH("Sunfish", new ItemStack(Material.PUFFERFISH), 1250, 1520, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Legendary").getDouble("Sunfish")),
    OARFISH("Oarfish", new ItemStack(Material.SALMON), 540, 666, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Legendary").getDouble("Oarfish")),
    SWORDFISH("Swordfish", new ItemStack(Material.COD), 246, 342, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Legendary").getDouble("Swordfish"));

    String name;
    ItemStack item;
    Integer weightLow;
    Integer weightHigh;
    Double baseValue;

    LEGENDARY_FISH(String name, ItemStack item, Integer weightLow, Integer weightHigh, Double baseValue) {
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
