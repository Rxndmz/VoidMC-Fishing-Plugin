package me.rxndmz.voidfishing.Data;

import me.rxndmz.voidfishing.VoidFishing;
import me.rxndmz.voidfishing.events.SendNotification;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.io.IOException;

public class CoolerData {

    private static VoidFishing plugin = VoidFishing.getPlugin();

    private static String coolerName = "Cooler";

    public static void setup(Player player) {
        FileConfiguration data = PlayerData.getData();
        if (data.getConfigurationSection(player.getUniqueId().toString()).get("Cooler") == null) {
            Inventory inv = Bukkit.createInventory(player,9, coolerName);
            ItemStack[] items = inv.getContents();
            System.out.println(ItemSerialization.itemStackArrayToBase64(items));
            data.getConfigurationSection(player.getUniqueId().toString()).set("Cooler", ItemSerialization.itemStackArrayToBase64(items));
            PlayerData.saveData();
        }
    }

    public static Inventory getCooler(Player player) throws IOException {
        FileConfiguration data = PlayerData.getData();
        Integer size = data.getConfigurationSection(player.getUniqueId().toString()).getInt("Cooler Size");
        Inventory inv = Bukkit.createInventory(player, size, coolerName);
        if (!data.getConfigurationSection(player.getUniqueId().toString()).getString("Cooler").equalsIgnoreCase("null")) {
            ItemStack[] items = ItemSerialization.itemStackArrayFromBase64(data.getConfigurationSection(player.getUniqueId().toString()).getString("Cooler"));
            for (int i = 0; i < items.length; i++) {
                inv.setItem(i, items[i]);
            }
        }
        return inv;
    }

    public static double calcCoolerWorth(Player player) throws IOException {
        Inventory cooler = getCooler(player);
        double money = 0.00;
        NamespacedKey key = new NamespacedKey(plugin, "worth");
        for (ItemStack i : cooler.getContents()) {
            if (i != null) {
                if (i.hasItemMeta()) {
                    ItemMeta meta = i.getItemMeta();
                    PersistentDataContainer data = meta.getPersistentDataContainer();
                    double worth = 0.00;
                    if (data.has(key, PersistentDataType.DOUBLE)) {
                        worth = data.get(key, PersistentDataType.DOUBLE);
                    }
                    money = money + worth;
                }
            }
        }
        return money;
    }

    public static double calcCoolerByRarity(Player player, String rarity) throws IOException {
        NamespacedKey key = new NamespacedKey(plugin, "rarity");
        NamespacedKey key2 = new NamespacedKey(plugin, "worth");
        double money = 0.00;
        switch (rarity) {
            case "Common":
                for (ItemStack i : getCooler(player).getContents()) {
                    if (i != null) {
                        if (i.hasItemMeta()) {
                            ItemMeta meta = i.getItemMeta();
                            String s = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
                            if (s.equalsIgnoreCase("Common")) {
                                money = money + meta.getPersistentDataContainer().get(key2, PersistentDataType.DOUBLE);
                            }
                        }
                    }
                }
                break;
            case "Uncommon":
                for (ItemStack i : getCooler(player).getContents()) {
                    if (i != null) {
                        if (i.hasItemMeta()) {
                            ItemMeta meta = i.getItemMeta();
                            String s = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
                            if (s.equalsIgnoreCase("Uncommon")) {
                                money = money + meta.getPersistentDataContainer().get(key2, PersistentDataType.DOUBLE);
                            }
                        }
                    }
                }
                break;
            case "Rare":
                for (ItemStack i : getCooler(player).getContents()) {
                    if (i != null) {
                        if (i.hasItemMeta()) {
                            ItemMeta meta = i.getItemMeta();
                            String s = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
                            if (s.equalsIgnoreCase("Rare")) {
                                money = money + meta.getPersistentDataContainer().get(key2, PersistentDataType.DOUBLE);
                            }
                        }
                    }
                }
                break;
            case "Legendary":
                for (ItemStack i : getCooler(player).getContents()) {
                    if (i != null) {
                        if (i.hasItemMeta()) {
                            ItemMeta meta = i.getItemMeta();
                            String s = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
                            if (s.equalsIgnoreCase("Legendary")) {
                                money = money + meta.getPersistentDataContainer().get(key2, PersistentDataType.DOUBLE);
                            }
                        }
                    }
                }
                break;
            case "Mythic":
                for (ItemStack i : getCooler(player).getContents()) {
                    if (i != null) {
                        if (i.hasItemMeta()) {
                            ItemMeta meta = i.getItemMeta();
                            String s = meta.getPersistentDataContainer().get(key, PersistentDataType.STRING);
                            if (s.equalsIgnoreCase("Mythic")) {
                                money = money + meta.getPersistentDataContainer().get(key2, PersistentDataType.DOUBLE);
                            }
                        }
                    }
                }
                break;
        }
        return money;
    }

    public static void clearByRarity(Player player, String rarity) throws IOException {
        Inventory inv = getCooler(player);
        Inventory newInv = getCooler(player);
        newInv.clear();
        for (ItemStack i : inv.getContents()) {
            if (i != null) {
                if (i.hasItemMeta()) {
                    ItemMeta meta = i.getItemMeta();
                    String s = meta.getPersistentDataContainer().get(new NamespacedKey(plugin, "rarity"), PersistentDataType.STRING);
                    if (!s.equalsIgnoreCase(rarity)) {
                        newInv.addItem(i);
                    }
                }
            }
        }
        setCooler(player, newInv);
    }

    public static void clearCooler(Player player) throws IOException {
        Inventory cooler = getCooler(player);
        cooler.clear();
        setCooler(player, cooler);
    }

    public static void setCooler(Player player, Inventory cooler) {
        FileConfiguration data = PlayerData.getData();
        ItemStack[] items = cooler.getContents();
        data.getConfigurationSection(player.getUniqueId().toString()).set("Cooler", ItemSerialization.itemStackArrayToBase64(items));
        PlayerData.saveData();
    }

    public static void addToCooler(Player player, ItemStack item) throws IOException {
        ConfigurationSection data = PlayerData.getData().getConfigurationSection(player.getUniqueId().toString());
        Inventory cooler = getCooler(player);
        if (cooler.firstEmpty() != -1) {
            cooler.setItem(cooler.firstEmpty(), item);
            setCooler(player, cooler);
        } else {
            Bukkit.getServer().getPluginManager().callEvent(new SendNotification(
                    player,
                    ChatColor.RED.toString() + ChatColor.BOLD + "Inventory Full!",
                    ChatColor.RED.toString() + ChatColor.BOLD + "Sell Your Items!",
                    5,
                    15,
                    5,
                    false
            ));
        }
    }

    public static Boolean checkCooler(Player player) throws IOException {
        Inventory cooler = getCooler(player);
        return cooler.firstEmpty() == -1;
    }

    public static void upgradeCooler(Player player) {
        ConfigurationSection data = PlayerData.getData().getConfigurationSection(player.getUniqueId().toString());
        Integer upgrades = data.getInt("Cooler Upgrades");
        if (upgrades == 0) {
            data.set("Cooler Size", 18);
            data.set("Cooler Upgrades", upgrades + 1);
            PlayerData.saveData();
        } else if (upgrades == 1) {
            data.set("Cooler Size", 27);
            data.set("Cooler Upgrades", upgrades + 1);
            PlayerData.saveData();
        } else if (upgrades == 2) {
            data.set("Cooler Size", 36);
            data.set("Cooler Upgrades", upgrades + 1);
            PlayerData.saveData();
        } else if (upgrades == 3) {
            data.set("Cooler Size", 45);
            data.set("Cooler Upgrades", upgrades + 1);
            PlayerData.saveData();
        } else if (upgrades == 4) {
            data.set("Cooler Size", 54);
            data.set("Cooler Upgrades", upgrades + 1);
            PlayerData.saveData();
        } else {
            player.sendMessage("[Void Fishing] Cannot upgrade above the max amount!");
        }
    }

}
