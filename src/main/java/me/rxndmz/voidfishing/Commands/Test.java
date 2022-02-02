package me.rxndmz.voidfishing.Commands;

import me.rxndmz.voidfishing.Data.CoolerData;
import me.rxndmz.voidfishing.Data.PlayerData;
import me.rxndmz.voidfishing.GUI.GUIHandler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class Test implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            PlayerData.getData().getConfigurationSection(player.getUniqueId().toString()).set("Cooler Upgrades", 0);
            PlayerData.getData().getConfigurationSection(player.getUniqueId().toString()).set("Cooler Size", 9);
        }
        return false;
    }

}
