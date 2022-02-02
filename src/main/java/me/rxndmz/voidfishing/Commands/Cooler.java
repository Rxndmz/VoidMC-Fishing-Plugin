package me.rxndmz.voidfishing.Commands;

import me.rxndmz.voidfishing.Chat.MessageHandler;
import me.rxndmz.voidfishing.Data.CoolerData;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.io.IOException;

public class Cooler implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Inventory inv = null;
            try {
                inv = CoolerData.getCooler(player);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (inv != null) {
                player.openInventory(inv);
            } else {
                MessageHandler.badAlert(player, "ERROR");
            }
        }
        return false;
    }
}
