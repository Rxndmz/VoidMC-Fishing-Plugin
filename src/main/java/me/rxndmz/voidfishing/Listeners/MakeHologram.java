package me.rxndmz.voidfishing.Listeners;

import me.rxndmz.voidfishing.events.CreateHologram;
import org.bukkit.ChatColor;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MakeHologram implements Listener {

    @EventHandler
    public void makeHologram(CreateHologram e) {
        if (e.forFishing()) {
            // First line //
            ArmorStand hologram = (ArmorStand) e.getWorld().spawnEntity(e.getLocation(), EntityType.ARMOR_STAND);
            hologram.setVisible(false);
            hologram.setCustomNameVisible(true);
            hologram.setGravity(false);
            hologram.setCustomName(ChatColor.WHITE.toString() + ChatColor.BOLD + e.getPlayer().getName() + " Caught A");
            // Second line //
            ArmorStand hologram2 = (ArmorStand) e.getWorld().spawnEntity(e.getLocation().add(0, -0.25,0), EntityType.ARMOR_STAND);
            hologram2.setVisible(false);
            hologram2.setCustomNameVisible(true);
            hologram2.setGravity(false);
            hologram2.setCustomName(e.getText());
            System.out.println(e.getLocation());
            System.out.println(e.getLocation());
        } else {
            ArmorStand hologram = (ArmorStand) e.getWorld().spawnEntity(e.getLocation(), EntityType.ARMOR_STAND);
            hologram.setVisible(false);
            hologram.setCustomNameVisible(true);
            hologram.setGravity(false);
            hologram.setCustomName(e.getText());
        }
    }

}
