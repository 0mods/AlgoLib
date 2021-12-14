package com.algorithmlx.algolib.item;

import com.algorithmlx.algolib.Registration;
import com.algorithmlx.algolib.api.IArmorTick;
import com.algorithmlx.algolib.api.ModArmorMaterials;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class ExampleArmor extends ArmorItem implements IArmorTick {
    public ExampleArmor(EquipmentSlot slot, Properties properties) {
        super(ModArmorMaterials.EXAMPLE, slot, properties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Player player) {
        ItemStack head = player.getItemBySlot(EquipmentSlot.HEAD);
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        ItemStack legs = player.getItemBySlot(EquipmentSlot.LEGS);
        ItemStack feet = player.getItemBySlot(EquipmentSlot.FEET);

        boolean fullArmor =
                head != null && head.getItem() == Registration.EXAMPLE_HELMET
                        && chest != null && chest.getItem() == Registration.EXAMPLE_CHEST
                        && legs != null && legs.getItem() == Registration.EXAMPLE_LEGS
                        && feet != null && feet.getItem() == Registration.EXAMPLE_BOOTS;

        if(!fullArmor && !player.isCreative()) {
            player.abilities.mayfly = false;
            player.abilities.flying = false;
        } else {
            player.abilities.mayfly = true;
        }
    }
}
