package com.algorithmlx.algolib;

import com.algorithmlx.algolib.item.ExampleArmor;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class Registration {
    public static ExampleArmor EXAMPLE_HELMET;
    public static ExampleArmor EXAMPLE_CHEST;
    public static ExampleArmor EXAMPLE_LEGS;
    public static ExampleArmor EXAMPLE_BOOTS;

    public static void init(){
        EXAMPLE_HELMET = Registry.register(Registry.ITEM, new ResourceLocation(AlgoLib.ID, "example_helmet"), new ExampleArmor(EquipmentSlot.HEAD, new Item.Properties()));
        EXAMPLE_CHEST = Registry.register(Registry.ITEM, new ResourceLocation(AlgoLib.ID, "example_chestplate"), new ExampleArmor(EquipmentSlot.CHEST, new Item.Properties()));
        EXAMPLE_LEGS = Registry.register(Registry.ITEM, new ResourceLocation(AlgoLib.ID, "example_leggings"), new ExampleArmor(EquipmentSlot.LEGS, new Item.Properties()));
        EXAMPLE_BOOTS = Registry.register(Registry.ITEM, new ResourceLocation(AlgoLib.ID, "example_boots"), new ExampleArmor(EquipmentSlot.FEET, new Item.Properties()));
    }
}
