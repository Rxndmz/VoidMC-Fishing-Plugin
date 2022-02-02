package me.rxndmz.voidfishing.events;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class CreateHologram extends Event {

    private Location location;
    private String text;
    private World world;
    private Boolean forFishing;
    private Player player;

    public CreateHologram(Player player, Location location, String text, World world, Boolean forFishing) {
        this.location = location;
        this.text = text;
        this.world = world;
        this.forFishing = forFishing;
        this.player = player;
    }

    // Getters //

    public Player getPlayer() { return player; }

    public Boolean forFishing() {
        return forFishing;
    }

    public World getWorld() {
        return world;
    }

    public String getText() {
        return text;
    }

    public Location getLocation() {
        return location;
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
