package me.rxndmz.voidfishing.events;

import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

public class GainedRodXp extends Event {

    private int xp;
    private ItemStack rod;

    public GainedRodXp(int xp, ItemStack rod) {
        this.xp = xp;
        this.rod = rod;
    }

    // Getters //

    public int getXp() {
        return xp;
    }

    public ItemStack getRod() {
        return rod;
    }


    // Handler thing //

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
