package me.rxndmz.voidfishing.Commands;

import me.rxndmz.voidfishing.GUI.GUIHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class FishingMerchant implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            try {
                player.openInventory(GUIHandler.shopMainGUI(player));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
