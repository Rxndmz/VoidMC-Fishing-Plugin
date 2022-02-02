package me.rxndmz.voidfishing.Chat;

import me.rxndmz.voidfishing.VoidFishing;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MessageHandler {

    private static VoidFishing plugin = VoidFishing.getPlugin();

    private static ChatColor bold = ChatColor.BOLD;

    public static void successfulCatch(Player player, String fishName, ChatColor color, String rarity, Boolean doubled) {
        if (doubled) {
            player.sendMessage(format("&8&l(&b&l!&8&l) &dYou Caught a ") + color + bold + rarity + " " + fishName + format(" &8&l[&b&lx2&8&l]"));
        } else {
            player.sendMessage(format("&8&l(&b&l!&8&l) &dYou Caught a ") + color + bold + rarity + " " + fishName);
        }
        player.sendMessage(format("&8&l(&b&l!&8&l) &dYour Fish Has Been Placed Into Your Cooler! &8(/cooler)"));
    }

    public static void xpEarned(Player player, int amount) {
        player.sendMessage(format("&8&l(&b&l!&8&l) &aYou Earned &a&l" + amount + "xp!"));
    }

    public static void goodAlert(Player player, String msg) {
        player.sendMessage(format("&8&l(&b&l!&8&l) &a") + msg);
    }

    public static void badAlert(Player player, String msg) {
        player.sendMessage(format("&8&l(&c&l!&8&l) &c") + msg);
    }

    private static String format(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void depositMoney(Player player, double money) {
        player.sendMessage(format("&8&l(&b&l!&8&l) &a&l$" + roundMoney(money) + " &r&aHas Been Deposited Into Your Balance!"));
    }

    public static void withdrawMoney(Player player, double money) {
        player.sendMessage(format("&8&l(&c&l!&8&l) &c&l-$" + roundMoney(money) ));
    }

    private static String roundMoney(Double money) {
        int i = (int) Math.round(money);
        String str = String.valueOf(i);
        if (str.length() >= 4 && str.length() <= 6) {
            if (str.length() == 4) {
                str = str.substring(0, 1) + "." + str.substring(1,2) + "K";
            } else if (str.length() == 5) {
                str = str.substring(0,2) + "." + str.substring(2,3) + "K";
            } else {
                str = str.substring(0, 3) + "." + str.substring(3,4) + "K";
            }
        } else if (str.length() >= 7 && str.length() <= 9) {
            if (str.length() == 7) {
                str = str.substring(0, 1) + "." + str.substring(1,2) + "M";
            } else if (str.length() == 8) {
                str = str.substring(0,2) + "." + str.substring(2,3) + "M";
            } else {
                str = str.substring(0, 3) + "." + str.substring(3,4) + "M";
            }
        }
        return str;
    }

}
