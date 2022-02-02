package me.rxndmz.voidfishing.Listeners.GUI;

import me.rxndmz.voidfishing.GUI.GUIHandler;
import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;

public class OnCloseInv implements Listener {

    private static VoidFishing plugin = VoidFishing.getPlugin();

    @EventHandler
    public void invClosed(InventoryCloseEvent e) {
        if (e.getInventory().equals(GUIHandler.getEnchList())) {
            Player player = (Player) e.getPlayer();
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.openInventory(GUIHandler.getEnchMain());
                }
            }.runTaskLater(plugin, 1);
        } else if (e.getView().getTitle().equalsIgnoreCase("Sell By Rarity")) {
            Player player = (Player) e.getPlayer();
            new BukkitRunnable() {
                @Override
                public void run() {
                    try {
                        player.openInventory(GUIHandler.shopMainGUI(player));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }.runTaskLater(plugin, 1);
        } else if (e.getView().getTitle().equalsIgnoreCase("Cooler Upgrades")) {
            Player player = (Player) e.getPlayer();
            new BukkitRunnable() {
                @Override
                public void run() {
                    player.openInventory(GUIHandler.getEnchMain());
                }
            }.runTaskLater(plugin, 1);
        }
    }

    private static String roundMoney(Double money) {
        int i = (int) Math.round(money);
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

}
