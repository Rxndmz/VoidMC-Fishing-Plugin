package me.rxndmz.voidfishing.Listeners;

import me.rxndmz.voidfishing.events.SendNotification;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class MakeNotification implements Listener {

    @EventHandler
    public void makeNotification(SendNotification e) {

        Player player = e.getPlayer();
        Integer fadeIn = e.getFadeIn();
        Integer fadeOut = e.getFadeOut();
        Integer stayTime = e.getStayTime();
        String title = e.getTitle();
        String subtitle = e.getSubtitle();

        if (!e.forActionBar()) {
            player.sendTitle(title, subtitle, fadeIn, stayTime, fadeOut);
        } else {
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(title));
        }
    }

}
