package com.algorithmlx.algolib.api;

import net.minecraft.world.item.ItemStack;

public class ItemUtil {
    public static boolean isItemEqual(final ItemStack a, final ItemStack b, final boolean matchNBT) {
        if (a.isEmpty() || b.isEmpty()) {
            return false;
        }
        if (a.getItem() != b.getItem()) {
            return false;
        }
        return !matchNBT || ItemStack.tagMatches(a, b);
    }

    public static boolean isItemEqual(ItemStack a, ItemStack b, boolean matchNBT, boolean useTags) {
        if (a.isEmpty() && b.isEmpty()) {
            return true;
        }
        if (isItemEqual(a, b, matchNBT)) {
            return true;
        }
        if (a.isEmpty() || b.isEmpty()) {
            return false;
        }
        if (useTags) {

        }
        return false;
    }
}
