package me.rxndmz.voidfishing.LevelSystem;

import me.rxndmz.voidfishing.Data.PlayerData;
import me.rxndmz.voidfishing.events.LevelUp;
import me.rxndmz.voidfishing.events.SendNotification;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;

public class LevelUpEvent implements Listener {

    @EventHandler
    public void levelUp(LevelUp e) {
        Integer level = e.getLevel();
        Player player = e.getPlayer();

        // Sends The player a notification //
        Bukkit.getServer().getPluginManager().callEvent(new SendNotification(
                player,
                ChatColor.GREEN + "" + ChatColor.BOLD + "LEVEL UP",
                "You Leveled Up!",
                10,
                30,
                10,
                false
        ));

        // Launches a firework on the player //
        Firework fw = player.getWorld().spawn(player.getLocation(), Firework.class);
        FireworkMeta fwm = fw.getFireworkMeta();
        FireworkEffect.Builder builder = FireworkEffect.builder();

        fwm.addEffect(builder.trail(true).withColor(Color.GREEN).build());
        fwm.addEffect(builder.withFade(Color.GREEN).build());
        fwm.addEffect(builder.withColor(Color.GREEN).build());
        fwm.setPower(0);
        fw.setFireworkMeta(fwm);

        // Sends the player a message //
        player.sendMessage(format("&2&l&m▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅"));
        player.sendMessage("");
        player.sendMessage(ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + "   (!) " + ChatColor.GREEN.toString() + ChatColor.BOLD + "Your Fishing Level Has Increased To " + PlayerData.getData().getConfigurationSection(player.getUniqueId().toString()).getInt("Fishing Level") + "!" + ChatColor.DARK_GREEN.toString() + ChatColor.BOLD + " (!)");
        player.sendMessage("");
        player.sendMessage(format("   &2&lYou Can Now:"));
        player.sendMessage("");
        player.sendMessage(format("   &a&lCatch Uncommon Fish!"));
        player.sendMessage("");
        player.sendMessage(format("&2&l&m▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅▅"));
        player.sendMessage("");

    }

    private static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
