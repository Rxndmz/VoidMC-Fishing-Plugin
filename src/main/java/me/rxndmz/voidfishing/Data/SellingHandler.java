package me.rxndmz.voidfishing.Data;

import me.rxndmz.voidfishing.Chat.MessageHandler;
import me.rxndmz.voidfishing.VoidFishing;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.io.IOException;

public class SellingHandler {

    private static VoidFishing plugin = VoidFishing.getPlugin();
    private static Economy eco = VoidFishing.getEco();

    public static void sellAll(Player player) throws IOException {
        double money = CoolerData.calcCoolerWorth(player);
        if (money != 0.00) {
            CoolerData.clearCooler(player);
            eco.depositPlayer(player, money);
            MessageHandler.goodAlert(player, "Successfully Sold All Fish Inside Cooler!");
            MessageHandler.depositMoney(player, money);
        } else {
            MessageHandler.badAlert(player, "Cooler Is Empty And Cannot Be Sold!");
            player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.00f, 1.00f);
        }
    }

    public static void sellByRarity(Player player, String rarity) throws IOException {
        double money = CoolerData.calcCoolerByRarity(player, rarity);
        if (money != 0.00) {
            CoolerData.clearByRarity(player, rarity);
            eco.depositPlayer(player, money);
            MessageHandler.goodAlert(player, "Successfully Sold All " + rarity + " Fish Inside Cooler!");
            MessageHandler.depositMoney(player, money);
        } else {
            MessageHandler.badAlert(player, "Cooler Does Not Contain Any " + rarity + " Fish!");
            player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_CHIME, 1.00f, 1.00f);
        }
    }

    private static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

}
