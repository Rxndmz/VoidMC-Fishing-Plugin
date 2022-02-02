package me.rxndmz.voidfishing;

import me.rxndmz.voidfishing.Commands.Cooler;
import me.rxndmz.voidfishing.Commands.FishingEnchanter;
import me.rxndmz.voidfishing.Commands.FishingMerchant;
import me.rxndmz.voidfishing.Commands.Test;
import me.rxndmz.voidfishing.Data.PlayerData;
import me.rxndmz.voidfishing.Enchants.CustomEnchants;
import me.rxndmz.voidfishing.GUI.GUIHandler;
import me.rxndmz.voidfishing.LevelSystem.LevelUpEvent;
import me.rxndmz.voidfishing.LevelSystem.LevelHandler;
import me.rxndmz.voidfishing.Listeners.*;
import me.rxndmz.voidfishing.Listeners.Cooler.*;
import me.rxndmz.voidfishing.Listeners.GUI.OnCloseInv;
import me.rxndmz.voidfishing.Listeners.GUI.OnInvClick;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class VoidFishing extends JavaPlugin {

    private static VoidFishing plugin;
    private static FileConfiguration config;

    private static Economy eco;

    @Override
    public void onEnable() {
        plugin = this;

        if (!setupEconomy()) {
            System.out.println(ChatColor.RED + "[Void Fishing] Please install Vault and an Economy Plugin Installed!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        eco.deleteBank("Jack");
        eco.deleteBank("Jaack");
        eco.deleteBank("Jaaack");
        eco.deleteBank("Jaaaack");

        // GUI Setup //

        GUIHandler.setup();

        // Player Data Setup //

        PlayerData.setup();
        PlayerData.getData().options().copyDefaults(true);
        PlayerData.saveData();

        getConfig().options().copyDefaults(true);
        saveDefaultConfig();
        config = getConfig();

        // Commands //

        getCommand("Cooler").setExecutor(new Cooler());
        getCommand("Test").setExecutor(new Test());
        getCommand("FishingMerchant").setExecutor(new FishingMerchant());
        getCommand("FishingEnchanter").setExecutor(new FishingEnchanter());

        // Registering Enchants //

        CustomEnchants.register();

        // Listeners //

        Bukkit.getServer().getPluginManager().registerEvents(new OnFish(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MakeHologram(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new MakeNotification(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LevelUpEvent(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new LevelHandler(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CoolerClick(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new CoolerClose(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnInvClick(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new OnCloseInv(), this);

    }

    @Override
    public void onDisable() {

        // Data Saving //

        PlayerData.saveData();

    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economy = getServer().getServicesManager().getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economy != null)
            eco = economy.getProvider();
        return (eco != null);
    }

    // Getters

    public static Economy getEco() { return eco; }

    public static VoidFishing getPlugin() { return plugin; }

    public static FileConfiguration getDefaultConfig() { return config; }

}
