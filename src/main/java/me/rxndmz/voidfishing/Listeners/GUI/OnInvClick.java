package me.rxndmz.voidfishing.Listeners.GUI;

import me.rxndmz.voidfishing.Chat.MessageHandler;
import me.rxndmz.voidfishing.Commands.Cooler;
import me.rxndmz.voidfishing.Data.CoolerData;
import me.rxndmz.voidfishing.Data.SellingHandler;
import me.rxndmz.voidfishing.GUI.GUIHandler;
import me.rxndmz.voidfishing.VoidFishing;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OnInvClick implements Listener {

    private static VoidFishing plugin = VoidFishing.getPlugin();
    private static Economy eco = VoidFishing.getEco();

    @EventHandler
    public void onClick(InventoryClickEvent e) throws IOException {
        if (e.getInventory().equals(GUIHandler.getEnchMain())) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
                Player player = (Player) e.getWhoClicked();
                if (e.getSlot() == 20) {
                    // Upgrades Menu //
                    player.sendMessage("upgrades");
                } else if (e.getSlot() == 22) {
                    // Cooler Menu //
                    player.openInventory(GUIHandler.coolerGUI(player));
                } else if (e.getSlot() == 31) {
                    // Enchants List Menu //
                    player.openInventory(GUIHandler.getEnchList());
                } else if (e.getSlot() == 24) {
                    // Crafting Menu //
                    player.sendMessage("Opened Crafting");
                }
            }
        } else if (e.getInventory().equals(GUIHandler.getEnchList())) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
            }
        }
        if (e.getView().getTitle().equalsIgnoreCase("Fish Merchant")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
                Player player = (Player) e.getWhoClicked();
                if (e.getSlot() == 20) {
                    SellingHandler.sellAll(player);
                    setItem(e.getClickedInventory(), e.getCurrentItem(), "Cooler", 20);
                } else if (e.getSlot() == 31) {
                    player.sendMessage("Quests");
                } else if (e.getSlot() == 24) {
                    player.openInventory(GUIHandler.fishSellingGUI(player));
                }
            }
        } else if (e.getView().getTitle().equalsIgnoreCase("Sell By Rarity")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
                Player player = (Player) e.getWhoClicked();
                if (e.getSlot() == 11) {
                    SellingHandler.sellByRarity(player, "Common");
                    setItem(e.getClickedInventory(), e.getCurrentItem(), "Common", 11);
                } else if (e.getSlot() == 12) {
                    SellingHandler.sellByRarity(player, "Uncommon");
                    setItem(e.getClickedInventory(), e.getCurrentItem(), "Uncommon", 12);
                } else if (e.getSlot() == 13) {
                    SellingHandler.sellByRarity(player, "Rare");
                    setItem(e.getClickedInventory(), e.getCurrentItem(), "Rare", 13);
                } else if (e.getSlot() == 14) {
                    SellingHandler.sellByRarity(player, "Legendary");
                    setItem(e.getClickedInventory(), e.getCurrentItem(), "Legendary", 14);
                } else if (e.getSlot() == 15) {
                    SellingHandler.sellByRarity(player, "Mythic");
                    setItem(e.getClickedInventory(), e.getCurrentItem(), "Mythic", 15);
                }
            }
        } else if (e.getView().getTitle().equalsIgnoreCase("Cooler Upgrades")) {
            if (e.getCurrentItem() != null) {
                e.setCancelled(true);
                Player player = (Player) e.getWhoClicked();
                if (e.getSlot() == 20) {
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(format("&b&lUpgrade &r&8(click)"))) {
                            if (eco.getBalance(player) > 250000.00) {
                                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
                                upgradeCooler(player, 250000.00);
                                ItemStack item = e.getCurrentItem().clone();
                                ItemMeta meta = item.getItemMeta();
                                meta.setDisplayName(format("&b&lUnlocked!"));
                                List<String> lore = new ArrayList<String>();
                                lore.add(format("&dThis upgrade has been unlocked!"));
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                e.getClickedInventory().setItem(20, item);
                                meta.setDisplayName(format("&b&lUpgrade &r&8(click)"));
                                lore.clear();
                                lore.add(format("&dUpgrade your cooler"));
                                lore.add(format("&dfor more spaces!"));
                                lore.add(format("&dCost: &a&l" + roundMoney(500000.00)));
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                e.getClickedInventory().setItem(21, item);
                            } else {
                                MessageHandler.badAlert(player, "You Don't Have Enough Money For That!");
                                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.00f, 1.00f);
                            }
                        }
                    }
                } else if (e.getSlot() == 21) {
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(format("&b&lUpgrade &r&8(click)"))) {
                            if (eco.getBalance(player) > 500000.00) {
                                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
                                upgradeCooler(player, 500000.00);
                                ItemStack item = e.getCurrentItem().clone();
                                ItemMeta meta = item.getItemMeta();
                                meta.setDisplayName(format("&b&lUnlocked!"));
                                List<String> lore = new ArrayList<String>();
                                lore.add(format("&dThis upgrade has been unlocked!"));
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                e.getClickedInventory().setItem(21, item);
                                meta.setDisplayName(format("&b&lUpgrade &r&8(click)"));
                                lore.clear();
                                lore.add(format("&dUpgrade your cooler"));
                                lore.add(format("&dfor more spaces!"));
                                lore.add(format("&dCost: &a&l" + roundMoney(750000.00)));
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                e.getClickedInventory().setItem(22, item);
                            } else {
                                MessageHandler.badAlert(player, "You Don't Have Enough Money For That!");
                                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.00f, 1.00f);
                            }
                        }
                    }
                } else if (e.getSlot() == 22) {
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(format("&b&lUpgrade &r&8(click)"))) {
                            if (eco.getBalance(player) > 750000.00) {
                                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
                                upgradeCooler(player, 750000.00);
                                ItemStack item = e.getCurrentItem().clone();
                                ItemMeta meta = item.getItemMeta();
                                meta.setDisplayName(format("&b&lUnlocked!"));
                                List<String> lore = new ArrayList<String>();
                                lore.add(format("&dThis upgrade has been unlocked!"));
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                e.getClickedInventory().setItem(22, item);
                                meta.setDisplayName(format("&b&lUpgrade &r&8(click)"));
                                lore.clear();
                                lore.add(format("&dUpgrade your cooler"));
                                lore.add(format("&dfor more spaces!"));
                                lore.add(format("&dCost: &a&l" + roundMoney(1000000.00)));
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                e.getClickedInventory().setItem(23, item);
                            } else {
                                MessageHandler.badAlert(player, "You Don't Have Enough Money For That!");
                                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.00f, 1.00f);
                            }
                        }
                    }
                } else if (e.getSlot() == 23) {
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(format("&b&lUpgrade &r&8(click)"))) {
                            if (eco.getBalance(player) > 1000000.00) {
                                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
                                upgradeCooler(player, 1000000.00);
                                ItemStack item = e.getCurrentItem().clone();
                                ItemMeta meta = item.getItemMeta();
                                meta.setDisplayName(format("&b&lUnlocked!"));
                                List<String> lore = new ArrayList<String>();
                                lore.add(format("&dThis upgrade has been unlocked!"));
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                e.getClickedInventory().setItem(23, item);
                                meta.setDisplayName(format("&b&lUpgrade &r&8(click)"));
                                lore.clear();
                                lore.add(format("&dUpgrade your cooler"));
                                lore.add(format("&dfor more spaces!"));
                                lore.add(format("&dCost: &a&l" + roundMoney(1250000.00)));
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                e.getClickedInventory().setItem(24, item);
                            } else {
                                MessageHandler.badAlert(player, "You Don't Have Enough Money For That!");
                                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.00f, 1.00f);
                            }
                        }
                    }
                } else if (e.getSlot() == 24) {
                    if (e.getCurrentItem().hasItemMeta()) {
                        if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(format("&b&lUpgrade &r&8(click)"))) {
                            if (eco.getBalance(player) > 1250000.00) {
                                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1.00f, 1.00f);
                                upgradeCooler(player, 1250000.00);
                                ItemStack item = e.getCurrentItem().clone();
                                ItemMeta meta = item.getItemMeta();
                                meta.setDisplayName(format("&b&lUnlocked!"));
                                List<String> lore = new ArrayList<String>();
                                lore.add(format("&dThis upgrade has been unlocked!"));
                                meta.setLore(lore);
                                item.setItemMeta(meta);
                                e.getClickedInventory().setItem(24, item);
                            } else {
                                MessageHandler.badAlert(player, "You Don't Have Enough Money For That!");
                                player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.00f, 1.00f);
                            }
                            // small bug but update the book stats on upgrade :) //
                        }
                    }
                }
            }
        }
    }

    private static void upgradeCooler(Player player, double money) {
        CoolerData.upgradeCooler(player);
        eco.withdrawPlayer(player, money);
        MessageHandler.goodAlert(player, "Successfully Bought Cooler Upgrade!");
        MessageHandler.withdrawMoney(player, money);
    }

    private static void setItem(Inventory inv, ItemStack item, String prefix, int index) {
        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        lore.remove(1);
        lore.add(format("&d" + prefix + " Value: &a&l$0"));
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(index, item);
    }

    private static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
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

}
