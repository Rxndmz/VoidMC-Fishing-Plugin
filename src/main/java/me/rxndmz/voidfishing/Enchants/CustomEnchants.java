package me.rxndmz.voidfishing.Enchants;

import org.bukkit.enchantments.Enchantment;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CustomEnchants {

    public static final Enchantment DOUBLE = new EnchantWrapper("double", "Double", 1);
    public static final Enchantment LUCKY = new EnchantWrapper("lucky", "Lucky", 1);
    public static final Enchantment EXPERIENCE = new EnchantWrapper("experience", "Experience", 3);
    public static final Enchantment CHARMED = new EnchantWrapper("charmed", "Charmed", 3);
    public static final Enchantment MYTHICAL = new EnchantWrapper("mythical", "Mythical", 3);

    public static void register() {
        if (!Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(DOUBLE)) {
            registerEnchantment(DOUBLE);
        }
        if (!Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(LUCKY)) {
            registerEnchantment(LUCKY);
        }
        if (!Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(EXPERIENCE)) {
            registerEnchantment(EXPERIENCE);
        }
        if (!Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(CHARMED)) {
            registerEnchantment(CHARMED);
        }
        if (!Arrays.stream(Enchantment.values()).collect(Collectors.toList()).contains(MYTHICAL)) {
            registerEnchantment(MYTHICAL);
        }
    }

    public static void registerEnchantment(Enchantment enchantment) {
        boolean registered = true;
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (Exception e) {
            registered = false;
            e.printStackTrace();
        }
    }

}
