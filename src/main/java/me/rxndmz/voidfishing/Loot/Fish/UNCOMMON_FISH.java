package me.rxndmz.voidfishing.Loot.Fish;

import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum UNCOMMON_FISH {
    CATFISH("Catfish", new ItemStack(Material.COD), 25, 40, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Uncommon").getDouble("Catfish")),
    PUFFERFISH("Pufferfish", new ItemStack(Material.PUFFERFISH), 20, 30, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Uncommon").getDouble("Pufferfish")),
    ROACH("Roach", new ItemStack(Material.COD), 5, 13, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Uncommon").getDouble("Roach")),
    PIKE("Pike", new ItemStack(Material.COD), 26, 38, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Uncommon").getDouble("Pike"));

    String name;
    ItemStack item;
    Integer weightLow;
    Integer weightHigh;
    Double baseValue;

    UNCOMMON_FISH(String name, ItemStack item, Integer weightLow, Integer weightHigh, Double baseValue) {
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
