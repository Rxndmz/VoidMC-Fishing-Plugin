package me.rxndmz.voidfishing.events;

import me.rxndmz.voidfishing.Data.PlayerData;
import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class GainedXP extends Event {

    private Integer xp;
    private Player player;
    private Integer level;
    private ItemStack rod;

    public GainedXP(Integer xp, Player player, ItemStack rod) {
        this.xp = xp;
        this.player = player;
        this.level = Objects.requireNonNull(PlayerData.getData().getConfigurationSection(player.getUniqueId().toString())).getInt("Fishing Level");
        this.rod = rod;
    }

    // Getters //

    public Integer getXp() {
        return xp;
    }

    public Player getPlayer() {
        return player;
    }

    public Integer getLevel() { return level; }

    public ItemStack getRod() { return rod;}

    // Handler thing //

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
