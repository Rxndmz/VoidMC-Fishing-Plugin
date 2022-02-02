package me.rxndmz.voidfishing.Loot.Fish;

import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public enum MYTHIC_FISH {
    TIGER_SHARK("Tiger Shark", new ItemStack(Material.COD), 870, 1130, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Mythic").getDouble("Tiger Shark")),
    MEGALODON("Megalodon", new ItemStack(Material.COD), 110000, 150000, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Mythic").getDouble("Megalodon")),
    KRAKEN("Kraken", new ItemStack(Material.PUFFERFISH), 50000, 60000, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Mythic").getDouble("Kraken")),
    GREAT_WHITE_SHARK("Great White Shark", new ItemStack(Material.COD), 4800, 5250, VoidFishing.getPlugin().getConfig().getConfigurationSection("Fish").getConfigurationSection("Mythic").getDouble("Tiger Shark"));

    String name;
    ItemStack item;
    Integer weightLow;
    Integer weightHigh;
    Double baseValue;

    MYTHIC_FISH(String name, ItemStack item, Integer weightLow, Integer weightHigh, Double baseValue) {
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
