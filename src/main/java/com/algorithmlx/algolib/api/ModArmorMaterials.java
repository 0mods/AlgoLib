package com.algorithmlx.algolib.api;

import com.algorithmlx.algolib.AlgoLib;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModArmorMaterials implements IArmorMaterial{
    EXAMPLE("example", 5, new int[]{123, 214, 2144, 2143}, 2147483647, SoundEvents.ARMOR_EQUIP_NETHERITE, 2147483647F, 2147483647F, () -> {
        return Ingredient.of(Items.DIAMOND);
    });

    private static final int[] durability = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] defense;
    private final int enchantability;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredientSupplier;

    ModArmorMaterials(String name, int durabilityMultiplier, int[] defense, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.defense = defense;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = new LazyLoadedValue(repairIngredientSupplier);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot equipmentSlot) {
        return durability[equipmentSlot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot equipmentSlot) {
        return this.defense[equipmentSlot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Environment(EnvType.CLIENT)
    public String getName() {
        return this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    @Override
    public String getModId() {
        return AlgoLib.ID;
    }
}
