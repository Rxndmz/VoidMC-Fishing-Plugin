package me.rxndmz.voidfishing.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class LevelUp extends Event {

    private Integer level;
    private Player player;

    public LevelUp(Player player, Integer level) {
        this.level = level;
        this.player = player;
    }

    // Getters //

    public Integer getLevel() {
        return level;
    }

    public Player getPlayer() {
        return player;
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
