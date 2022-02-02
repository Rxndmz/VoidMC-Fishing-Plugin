package me.rxndmz.voidfishing.Listeners.Cooler;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CoolerClick implements Listener {

    @EventHandler
    public void CoolerClickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase("Cooler")) {
            e.setCancelled(true);
        }
    }

}
