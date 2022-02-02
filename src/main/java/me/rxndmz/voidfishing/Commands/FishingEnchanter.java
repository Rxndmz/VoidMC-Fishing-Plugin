package me.rxndmz.voidfishing.Commands;

import me.rxndmz.voidfishing.GUI.GUIHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FishingEnchanter implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.openInventory(GUIHandler.getEnchMain());
        }
        return false;
    }

}
