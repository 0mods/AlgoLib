package com.algorithmlx.algolib.mixin;

import com.algorithmlx.algolib.api.IArmorTick;
import com.algorithmlx.algolib.api.ArmorRemove;
import com.algorithmlx.algolib.api.ItemUtil;
import net.minecraft.core.NonNullList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {

    @Shadow
    public abstract Iterable<ItemStack> getArmorSlots();

    protected PlayerMixin(EntityType<? extends LivingEntity> type, Level level) {
        super(type, level);
    }

    private final NonNullList<ItemStack> armorCache = NonNullList.withSize(4, ItemStack.EMPTY);

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo info) {
        int i = 0;
        for (ItemStack stack : getArmorSlots()) {
            ItemStack cachedStack = armorCache.get(i);
            if (!ItemUtil.isItemEqual(cachedStack, stack, false, false)) {
                if (cachedStack.getItem() instanceof ArmorRemove) {
                    ((ArmorRemove) cachedStack.getItem()).onRemove((Player) (Object) this);
                }
                armorCache.set(i, stack.copy());
            }
            i++;

            if (!stack.isEmpty() && stack.getItem() instanceof IArmorTick) {
                ((IArmorTick) stack.getItem()).onArmorTick(stack, (Player) (Object) this);
            }
        }
    }
}
