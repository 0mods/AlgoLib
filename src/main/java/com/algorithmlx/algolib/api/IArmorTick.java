package com.algorithmlx.algolib.api;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface IArmorTick {
    void onArmorTick(ItemStack stack, Player player);
}
