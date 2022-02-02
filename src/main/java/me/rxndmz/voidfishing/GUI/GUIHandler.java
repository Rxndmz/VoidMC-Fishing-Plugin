package me.rxndmz.voidfishing.GUI;

import me.rxndmz.voidfishing.Data.CoolerData;
import me.rxndmz.voidfishing.Data.PlayerData;
import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GUIHandler {

    private static VoidFishing plugin = VoidFishing.getPlugin();

    private static Inventory enchMain;
    private static Inventory enchList;
    private static Inventory crafting;
    private static Inventory upgradesMain;

    public static void setup() {
        enchantingMainGUI();
        enchantsListGUI();
    }

    public static Inventory fishSellingGUI(Player player) throws IOException {
        // make more methods in CoolerData to calc cooler worth of certain rarity and or in here and display on the item here //
        Inventory fishSelling = Bukkit.createInventory(null, 27, "Sell By Rarity");

        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();

        // Glass Panes //

        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        fishSelling.setItem(0, item);
        fishSelling.setItem(1, item);
        fishSelling.setItem(2, item);
        fishSelling.setItem(3, item);
        fishSelling.setItem(4, item);
        fishSelling.setItem(5, item);
        fishSelling.setItem(6, item);
        fishSelling.setItem(7, item);
        fishSelling.setItem(8, item);
        fishSelling.setItem(9, item);
        fishSelling.setItem(17, item);
        fishSelling.setItem(18, item);
        fishSelling.setItem(19, item);
        fishSelling.setItem(20, item);
        fishSelling.setItem(21, item);
        fishSelling.setItem(22, item);
        fishSelling.setItem(23, item);
        fishSelling.setItem(24, item);
        fishSelling.setItem(25, item);
        fishSelling.setItem(26, item);
        item.setType(Material.GRAY_STAINED_GLASS_PANE);
        fishSelling.setItem(10, item);
        fishSelling.setItem(16, item);

        // Common Item //

        item.setType(Material.WHITE_STAINED_GLASS_PANE);
        meta.setDisplayName(format("&b&lSell Common"));
        List<String> lore = new ArrayList<String>();
        lore.add(format("&dSell all of your &7&lCOMMON &r&dfish in your cooler!"));
        lore.add(format("&dCommon Value: &a&l$" + roundMoney(CoolerData.calcCoolerByRarity(player, "Common"))));
        meta.setLore(lore);
        item.setItemMeta(meta);
        fishSelling.setItem(11, item);

        // Uncommon Item //

        item.setType(Material.GREEN_STAINED_GLASS_PANE);
        meta.setDisplayName(format("&b&lSell Uncommon"));
        lore.clear();
        lore.add(format("&dSell all of your &a&lUNCOMMON &r&dfish in your cooler!"));
        lore.add(format("&dUncommon Value: &a&l$" + roundMoney(CoolerData.calcCoolerByRarity(player, "Uncommon"))));
        meta.setLore(lore);
        item.setItemMeta(meta);
        fishSelling.setItem(12, item);

        // Rare Item //

        item.setType(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        meta.setDisplayName(format("&b&lSell Rare"));
        lore.clear();
        lore.add(format("&dSell all of your &b&lRARE &r&dfish in your cooler!"));
        lore.add(format("&dRare Value: &a&l$" + roundMoney(CoolerData.calcCoolerByRarity(player, "Rare"))));
        meta.setLore(lore);
        item.setItemMeta(meta);
        fishSelling.setItem(13, item);

        // Legendary Item //

        item.setType(Material.ORANGE_STAINED_GLASS_PANE);
        meta.setDisplayName(format("&b&lSell Legendary"));
        lore.clear();
        lore.add(format("&dSell all of your &6&lLEGENDARY &r&dfish in your cooler!"));
        lore.add(format("&dLegendary Value: &a&l$" + roundMoney(CoolerData.calcCoolerByRarity(player, "Legendary"))));
        meta.setLore(lore);
        item.setItemMeta(meta);
        fishSelling.setItem(14, item);

        // Rare Item //

        item.setType(Material.PURPLE_STAINED_GLASS_PANE);
        meta.setDisplayName(format("&b&lSell Mythic"));
        lore.clear();
        lore.add(format("&dSell all of your &lMYTHIC &r&dfish in your cooler!"));
        lore.add(format("&dMythic Value: &a&l$" + roundMoney(CoolerData.calcCoolerByRarity(player, "Mythic"))));
        meta.setLore(lore);
        item.setItemMeta(meta);
        fishSelling.setItem(15, item);
        return fishSelling;
    }

    public static Inventory shopMainGUI(Player player) throws IOException {
        Inventory shopMain = Bukkit.createInventory(null, 54, "Fish Merchant");

        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();

        // Glass Panes //

        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        shopMain.setItem(0, item);
        shopMain.setItem(1, item);
        shopMain.setItem(2, item);
        shopMain.setItem(3, item);
        shopMain.setItem(4, item);
        shopMain.setItem(5, item);
        shopMain.setItem(6, item);
        shopMain.setItem(7, item);
        shopMain.setItem(8, item);
        shopMain.setItem(9, item);
        shopMain.setItem(13, item);
        shopMain.setItem(17, item);
        shopMain.setItem(18, item);
        shopMain.setItem(26, item);
        shopMain.setItem(27, item);
        shopMain.setItem(35, item);
        shopMain.setItem(36, item);
        shopMain.setItem(37, item);
        shopMain.setItem(38, item);
        shopMain.setItem(42, item);
        shopMain.setItem(43, item);
        shopMain.setItem(44, item);
        shopMain.setItem(45, item);
        shopMain.setItem(46, item);
        shopMain.setItem(47, item);
        shopMain.setItem(48, item);
        shopMain.setItem(49, item);
        shopMain.setItem(50, item);
        shopMain.setItem(51, item);
        shopMain.setItem(52, item);
        shopMain.setItem(53, item);
        item.setType(Material.PURPLE_STAINED_GLASS_PANE);
        shopMain.setItem(10, item);
        shopMain.setItem(11, item);
        shopMain.setItem(12, item);
        shopMain.setItem(14, item);
        shopMain.setItem(15, item);
        shopMain.setItem(16, item);
        shopMain.setItem(19, item);
        shopMain.setItem(21, item);
        shopMain.setItem(22, item);
        shopMain.setItem(23, item);
        shopMain.setItem(25, item);
        shopMain.setItem(28, item);
        shopMain.setItem(29, item);
        shopMain.setItem(30, item);
        shopMain.setItem(32, item);
        shopMain.setItem(33, item);
        shopMain.setItem(34, item);
        shopMain.setItem(39, item);
        shopMain.setItem(40, item);
        shopMain.setItem(41, item);

        // Sell All Item //

        item.setType(Material.COOKED_COD);
        meta.setDisplayName(format("&b&lSell All"));
        List<String> lore = new ArrayList<String>();
        lore.add(format("&dSell all of your fish in your cooler!"));
        lore.add(format("&dCooler Value: &a&l$") + roundMoney(CoolerData.calcCoolerWorth(player)));
        meta.setLore(lore);
        item.setItemMeta(meta);
        shopMain.setItem(20, item);

        // Quests Item //

        item.setType(Material.BOOK);
        meta.setDisplayName(format("&b&lQuests"));
        lore.clear();
        lore.add(format("&dComplete Quests for money and"));
        lore.add(format("&dother rewards!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        shopMain.setItem(31, item);

        // Sell Individual Fish Item //

        item.setType(Material.COD);
        meta.setDisplayName(format("&b&lSell By Rarity"));
        lore.clear();
        lore.add(format("&dSell all fish of a certain rarity!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        shopMain.setItem(24, item);
        return shopMain;
    }

    public static Inventory coolerGUI(Player player) throws IOException {
        Inventory coolerMain = Bukkit.createInventory(null, 54, "Cooler Upgrades");
        ConfigurationSection data = PlayerData.getData().getConfigurationSection(player.getUniqueId().toString());

        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);

        // Glass Panes //

        coolerMain.setItem(0, item);
        coolerMain.setItem(1, item);
        coolerMain.setItem(2, item);
        coolerMain.setItem(3, item);
        coolerMain.setItem(4, item);
        coolerMain.setItem(5, item);
        coolerMain.setItem(6, item);
        coolerMain.setItem(7, item);
        coolerMain.setItem(8, item);
        coolerMain.setItem(9, item);
        coolerMain.setItem(17, item);
        coolerMain.setItem(18, item);
        coolerMain.setItem(26, item);
        coolerMain.setItem(27, item);
        coolerMain.setItem(35, item);
        coolerMain.setItem(36, item);
        coolerMain.setItem(37, item);
        coolerMain.setItem(38, item);
        coolerMain.setItem(42, item);
        coolerMain.setItem(43, item);
        coolerMain.setItem(44, item);
        coolerMain.setItem(45, item);
        coolerMain.setItem(46, item);
        coolerMain.setItem(47, item);
        coolerMain.setItem(48, item);
        coolerMain.setItem(49, item);
        coolerMain.setItem(50, item);
        coolerMain.setItem(51, item);
        coolerMain.setItem(52, item);
        coolerMain.setItem(53, item);
        item.setType(Material.PURPLE_STAINED_GLASS_PANE);
        coolerMain.setItem(10, item);
        coolerMain.setItem(11, item);
        coolerMain.setItem(12, item);
        coolerMain.setItem(13, item);
        coolerMain.setItem(14, item);
        coolerMain.setItem(15, item);
        coolerMain.setItem(16, item);
        coolerMain.setItem(19, item);
        coolerMain.setItem(25, item);
        coolerMain.setItem(28, item);
        coolerMain.setItem(29, item);
        coolerMain.setItem(30, item);
        coolerMain.setItem(32, item);
        coolerMain.setItem(33, item);
        coolerMain.setItem(34, item);
        coolerMain.setItem(39, item);
        coolerMain.setItem(40, item);
        coolerMain.setItem(41, item);

        // Cooler / fish Stats Item //

        item.setType(Material.BOOK);
        meta.setDisplayName(format("&b&lCooler Stats"));
        List<String> lore = new ArrayList<String>();
        String coolerSize = data.getString("Cooler Size");
        lore.add(format("&dSize: " + coolerSize));
        meta.setLore(lore);
        item.setItemMeta(meta);
        coolerMain.setItem(31, item);

        // Levelling Glass Panes //
        int upgrades = data.getInt("Cooler Upgrades");
        ConfigurationSection costs = VoidFishing.getDefaultConfig().getConfigurationSection("Cooler Upgrades");
        item.setType(Material.GREEN_STAINED_GLASS_PANE);
        double cost;
        switch (upgrades) {
            case 0:
                cost = costs.getDouble("1");
                meta.setDisplayName(format("&b&lUpgrade &r&8(click)"));
                lore.clear();
                lore.add(format("&dUpgrade your cooler"));
                lore.add(format("&dfor more spaces!"));
                lore.add(format("&dCost: &a&l" + roundMoney(cost)));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(20, item);

                item.setType(Material.GRAY_STAINED_GLASS_PANE);
                meta.setDisplayName(format("&b&lLocked"));
                lore.clear();
                lore.add(format("&dUnlock the other upgrades first!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(21, item);
                coolerMain.setItem(22, item);
                coolerMain.setItem(23, item);
                coolerMain.setItem(24, item);
                break;
            case 1:
                cost = costs.getDouble("2");
                meta.setDisplayName(format("&b&lUpgrade &r&8(click)"));
                lore.clear();
                lore.add(format("&dUpgrade your cooler"));
                lore.add(format("&dfor more spaces!"));
                lore.add(format("&dCost: &a&l" + roundMoney(cost)));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(21, item);

                meta.setDisplayName(format("&b&lUnlocked!"));
                lore.clear();
                lore.add(format("&dThis upgrade has been unlocked!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(20, item);

                item.setType(Material.GRAY_STAINED_GLASS_PANE);
                meta.setDisplayName(format("&b&lLocked"));
                lore.clear();
                lore.add(format("&dUnlock the other upgrades first!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(22, item);
                coolerMain.setItem(23, item);
                coolerMain.setItem(24, item);
                break;
            case 2:
                cost = costs.getDouble("3");
                meta.setDisplayName(format("&b&lUpgrade &r&8(click)"));
                lore.clear();
                lore.add(format("&dUpgrade your cooler"));
                lore.add(format("&dfor more spaces!"));
                lore.add(format("&dCost: &a&l" + roundMoney(cost)));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(22, item);

                meta.setDisplayName(format("&b&lUnlocked!"));
                lore.clear();
                lore.add(format("&dThis upgrade has been unlocked!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(20, item);
                coolerMain.setItem(21, item);

                item.setType(Material.GRAY_STAINED_GLASS_PANE);
                meta.setDisplayName(format("&b&lLocked"));
                lore.clear();
                lore.add(format("&dUnlock the other upgrades first!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(23, item);
                coolerMain.setItem(24, item);
                break;
            case 3:
                cost = costs.getDouble("4");
                meta.setDisplayName(format("&b&lUpgrade &r&8(click)"));
                lore.clear();
                lore.add(format("&dUpgrade your cooler"));
                lore.add(format("&dfor more spaces!"));
                lore.add(format("&dCost: &a&l" + roundMoney(cost)));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(23, item);

                meta.setDisplayName(format("&b&lUnlocked!"));
                lore.clear();
                lore.add(format("&dThis upgrade has been unlocked!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(20, item);
                coolerMain.setItem(21, item);
                coolerMain.setItem(22, item);

                item.setType(Material.GRAY_STAINED_GLASS_PANE);
                meta.setDisplayName(format("&b&lLocked"));
                lore.clear();
                lore.add(format("&dUnlock the other upgrades first!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(24, item);
                break;
            case 4:
                cost = costs.getDouble("5");
                meta.setDisplayName(format("&b&lUpgrade &r&8(click)"));
                lore.clear();
                lore.add(format("&dUpgrade your cooler"));
                lore.add(format("&dfor more spaces!"));
                lore.add(format("&dCost: &a&l" + roundMoney(cost)));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(24, item);

                meta.setDisplayName(format("&b&lUnlocked!"));
                lore.clear();
                lore.add(format("&dThis upgrade has been unlocked!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(20, item);
                coolerMain.setItem(21, item);
                coolerMain.setItem(22, item);
                coolerMain.setItem(23, item);
                break;
            case 5:
                meta.setDisplayName(format("&b&lUnlocked!"));
                lore.clear();
                lore.add(format("&dThis upgrade has been unlocked!"));
                meta.setLore(lore);
                item.setItemMeta(meta);
                coolerMain.setItem(20, item);
                coolerMain.setItem(21, item);
                coolerMain.setItem(22, item);
                coolerMain.setItem(23, item);
                coolerMain.setItem(24, item);
                break;
        }

        return coolerMain;
    }

    private static void enchantsListGUI() {
        enchList = Bukkit.createInventory(null, 27, "Enchantments");

        ItemStack item = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);

        // Glass Panes //

        enchList.setItem(0, item);
        enchList.setItem(1, item);
        enchList.setItem(2, item);
        enchList.setItem(3, item);
        enchList.setItem(4, item);
        enchList.setItem(5, item);
        enchList.setItem(6, item);
        enchList.setItem(7, item);
        enchList.setItem(8, item);
        enchList.setItem(9, item);
        enchList.setItem(17, item);
        enchList.setItem(18, item);
        enchList.setItem(19, item);
        enchList.setItem(20, item);
        enchList.setItem(21, item);
        enchList.setItem(22, item);
        enchList.setItem(23, item);
        enchList.setItem(24, item);
        enchList.setItem(25, item);
        enchList.setItem(26, item);

        // Enchants //

        // double //
        item.setType(Material.BOOK);
        meta.setDisplayName(format("&b&lDouble"));
        List<String> lore = new ArrayList<String>();
        lore.add(format("&dGives the ability to catch two"));
        lore.add(format("&dfish at once!"));
        lore.add("");
        lore.add(format("&dHigher the level the better chances."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchList.setItem(10, item);

        // lucky //
        item.setType(Material.BOOK);
        meta.setDisplayName(format("&b&lLucky"));
        lore.clear();
        lore.add(format("&dBecome a lucky fisher and get"));
        lore.add(format("&dfish with more value!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchList.setItem(11, item);

        // experience //
        item.setType(Material.BOOK);
        meta.setDisplayName(format("&b&lExperience"));
        lore.clear();
        lore.add(format("&dUnderstand how to use the fishing"));
        lore.add(format("&drod like a master and gain more"));
        lore.add(format("&dfishing rod experience!"));
        lore.add("");
        lore.add(format("&dHigher level gives more bonus exp."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchList.setItem(12, item);

        // charmed //
        item.setType(Material.BOOK);
        meta.setDisplayName(format("&b&lCharmed"));
        lore.clear();
        lore.add(format("&dBecome a master at fishing and"));
        lore.add(format("&dgain more angler experience!"));
        lore.add("");
        lore.add(format("&dHigher level gives more bonus exp."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchList.setItem(13, item);

        // mythical //
        item.setType(Material.BOOK);
        meta.setDisplayName(format("&b&lMythical"));
        lore.clear();
        lore.add(format("&dPray to the gods and have a"));
        lore.add(format("&dsmall chance to instantly"));
        lore.add(format("&dcatch a mythic fish!"));
        lore.add("");
        lore.add(format("&dHigher level gives better chances."));
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchList.setItem(14, item);

        // Blank Enchant Slots (black panes) //

        item.setType(Material.BLACK_STAINED_GLASS_PANE);
        meta.setDisplayName(" ");
        lore.clear();
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchList.setItem(15, item);
        enchList.setItem(16, item);

    }

    private static void enchantingMainGUI() {
        enchMain = Bukkit.createInventory(null, 54, "Fishing Master");

        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        ItemMeta meta = item.getItemMeta();

        // Glass Panes //

        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        enchMain.setItem(0, item);
        enchMain.setItem(1, item);
        enchMain.setItem(2, item);
        enchMain.setItem(3, item);
        enchMain.setItem(4, item);
        enchMain.setItem(5, item);
        enchMain.setItem(6, item);
        enchMain.setItem(7, item);
        enchMain.setItem(8, item);
        enchMain.setItem(9, item);
        enchMain.setItem(17, item);
        enchMain.setItem(18, item);
        enchMain.setItem(26, item);
        enchMain.setItem(27, item);
        enchMain.setItem(35, item);
        enchMain.setItem(36, item);
        enchMain.setItem(37, item);
        enchMain.setItem(38, item);
        enchMain.setItem(42, item);
        enchMain.setItem(43, item);
        enchMain.setItem(44, item);
        enchMain.setItem(45, item);
        enchMain.setItem(46, item);
        enchMain.setItem(47, item);
        enchMain.setItem(48, item);
        enchMain.setItem(49, item);
        enchMain.setItem(50, item);
        enchMain.setItem(51, item);
        enchMain.setItem(52, item);
        enchMain.setItem(53, item);
        item.setType(Material.PURPLE_STAINED_GLASS_PANE);
        enchMain.setItem(10, item);
        enchMain.setItem(11, item);
        enchMain.setItem(12, item);
        enchMain.setItem(13, item);
        enchMain.setItem(14, item);
        enchMain.setItem(15, item);
        enchMain.setItem(16, item);
        enchMain.setItem(19, item);
        enchMain.setItem(21, item);
        enchMain.setItem(23, item);
        enchMain.setItem(25, item);
        enchMain.setItem(28, item);
        enchMain.setItem(29, item);
        enchMain.setItem(30, item);
        enchMain.setItem(32, item);
        enchMain.setItem(33, item);
        enchMain.setItem(34, item);
        enchMain.setItem(39, item);
        enchMain.setItem(40, item);
        enchMain.setItem(41, item);

        // Enchanting Item //

        item.setType(Material.FISHING_ROD);
        meta.setDisplayName(format("&b&lUpgrades"));
        List<String> lore = new ArrayList<String>();
        lore.add(format("&dUpgrade your fishing rod by adding"));
        lore.add(format("&ddifferent enchants to build the"));
        lore.add(format("&dUltimate fishing rod!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchMain.setItem(20, item);

        // Cooler Upgrades Item //

        item.setType(Material.CHEST);
        meta.setDisplayName(format("&b&lCooler"));
        lore.clear();
        lore.add(format("&dShows the stats of your cooler"));
        lore.add(format("&dand allows you to upgrade it!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchMain.setItem(22, item);

        // Enchants List Item //

        item.setType(Material.BOOK);
        meta.setDisplayName(format("&b&lEnchants"));
        lore.clear();
        lore.add(format("&dShows the different enchants"));
        lore.add(format("&davailable on the server!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchMain.setItem(31, item);

        // Gear Crafting Item //

        item.setType(Material.CRAFTING_TABLE);
        meta.setDisplayName(format("&b&lCrafting"));
        lore.clear();
        lore.add(format("&dCraft different gear sets"));
        lore.add(format("&dto gain bonuses when fishing!"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        enchMain.setItem(24, item);

    }

    private static String roundMoney(Double money) {
        int i = (int) Math.round(money);
        String str = String.valueOf(i);
        if (str.length() >= 4 && str.length() <= 6) {
            if (str.length() == 4) {
                str = str.substring(0, 1) + "." + str.substring(1,2) + "K";
            } else if (str.length() == 5) {
                str = str.substring(0,2) + "." + str.substring(2,3) + "K";
            } else {
                str = str.substring(0, 3) + "." + str.substring(3,4) + "K";
            }
        } else if (str.length() >= 7 && str.length() <= 9) {
            if (str.length() == 7) {
                str = str.substring(0, 1) + "." + str.substring(1,2) + "M";
            } else if (str.length() == 8) {
                str = str.substring(0,2) + "." + str.substring(2,3) + "M";
            } else {
                str = str.substring(0, 3) + "." + str.substring(3,4) + "M";
            }
        }
        return str;
    }

    // Getters //

    public static Inventory getEnchList() { return enchList; }

    public static Inventory getEnchMain() {
        return enchMain;
    }

    private static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
