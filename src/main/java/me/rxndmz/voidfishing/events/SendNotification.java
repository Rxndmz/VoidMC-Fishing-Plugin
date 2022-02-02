package me.rxndmz.voidfishing.events;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SendNotification extends Event {

    private Player player;
    private String title;
    private String subtitle;
    private Integer fadeIn;
    private Integer stayTime;
    private Integer fadeOut;
    private Boolean actionBar;

    public SendNotification(Player player, String title, String subtitle, Integer fadeIn, Integer stayTime, Integer fadeOut, Boolean actionBar) {
        this.player = player;
        this.title = title;
        this.subtitle = subtitle;
        this.fadeIn = fadeIn;
        this.stayTime = stayTime;
        this.fadeOut = fadeOut;
        this.actionBar = actionBar;
    }

    // Getters //

    public Player getPlayer() { return player; }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public Integer getFadeIn() {
        return fadeIn;
    }

    public Integer getStayTime() {
        return stayTime;
    }

    public Integer getFadeOut() {
        return fadeOut;
    }

    public Boolean forActionBar() { return actionBar; }


    // Handler thing //

    private static final HandlerList handlers = new HandlerList();

    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

}
