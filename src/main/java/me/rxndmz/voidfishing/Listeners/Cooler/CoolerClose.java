package me.rxndmz.voidfishing.Listeners.Cooler;

import me.rxndmz.voidfishing.Data.CoolerData;
import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

public class CoolerClose implements Listener {

    VoidFishing plugin = VoidFishing.getPlugin();

    @EventHandler
    public void CoolerClosedEvent(InventoryCloseEvent e) {
        Player player = (Player) e.getPlayer();
        if (e.getView().getTitle().equalsIgnoreCase("Cooler")) {
            Inventory cooler = e.getView().getTopInventory();
            CoolerData.setCooler(player, cooler);
        }
    }

}
