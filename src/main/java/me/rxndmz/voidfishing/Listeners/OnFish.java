package me.rxndmz.voidfishing.Listeners;

import me.rxndmz.voidfishing.Chat.MessageHandler;
import me.rxndmz.voidfishing.Data.CoolerData;
import me.rxndmz.voidfishing.Enchants.CustomEnchants;
import me.rxndmz.voidfishing.Loot.LootHandler;
import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;

import java.io.IOException;

public class OnFish implements Listener {

    private static VoidFishing plugin = VoidFishing.getPlugin();

    @EventHandler
    public void onFish(PlayerFishEvent e) throws IOException {
        Player player = e.getPlayer();
        if (CoolerData.checkCooler(player)) {
            e.setCancelled(true);
            MessageHandler.badAlert(player, "Your Cooler Is Full!");
            player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.00f, 1.00f);
        } else {
            String state = e.getState().name();
            FishHook hook = e.getHook();
            if (state.equalsIgnoreCase("caught_fish")) {
                e.getCaught().remove();
                ItemStack rod = player.getInventory().getItemInMainHand();
                boolean failCheck = true;
                if (rod.hasItemMeta()) {
                    if (rod.getItemMeta().hasEnchant(CustomEnchants.MYTHICAL)) {
                        int level = rod.getItemMeta().getEnchantLevel(CustomEnchants.MYTHICAL);
                        double rand = Math.random();
                        switch(level) {
                            case 1:
                                if (rand <= 0.03) {
                                    LootHandler.rollMythic(player, rod);
                                    player.getWorld().strikeLightning(hook.getLocation());
                                    failCheck = false;
                                }
                                break;
                            case 2:
                                if (rand <= 0.06) {
                                    LootHandler.rollMythic(player, rod);
                                    player.getWorld().strikeLightning(hook.getLocation());
                                    failCheck = false;
                                }
                                break;
                            case 3:
                                if (rand <= 0.10) {
                                    LootHandler.rollMythic(player, rod);
                                    player.getWorld().strikeLightning(hook.getLocation());
                                    failCheck = false;
                                }
                                break;
                        }
                    }
                }
                if (failCheck) {
                    LootHandler.rollFish(player, rod);
                }
            }
        }
    }
}
