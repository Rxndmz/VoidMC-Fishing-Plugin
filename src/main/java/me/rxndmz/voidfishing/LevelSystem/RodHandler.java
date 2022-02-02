package me.rxndmz.voidfishing.LevelSystem;

import me.rxndmz.voidfishing.events.GainedRodXp;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class RodHandler implements Listener {

    @EventHandler
    public void GainedXp(GainedRodXp e) {
        ItemStack rod = e.getRod();
        int xp = e.getXp();
    }

}
