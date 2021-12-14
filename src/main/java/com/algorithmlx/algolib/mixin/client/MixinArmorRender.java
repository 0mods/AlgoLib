package com.algorithmlx.algolib.mixin.client;

import com.algorithmlx.algolib.api.IArmorMaterial;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ArmorItem;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

//Thanks Domaman202 per help with this mixin. Migrate in official mappings by AlgorithmLX
@Mixin(HumanoidArmorLayer.class)
public class MixinArmorRender {
    @Final
    @Shadow
    private static Map<String, ResourceLocation> ARMOR_LOCATION_CACHE;

    @Inject(method = "getArmorLocation", at = @At("HEAD"), cancellable = true)
    private void getArmorLocationInject(ArmorItem item, boolean legs, String overlay, CallbackInfoReturnable<ResourceLocation> cir) {
        if (item.getMaterial() instanceof IArmorMaterial material) {
            cir.setReturnValue(ARMOR_LOCATION_CACHE.computeIfAbsent(material.getModId() + ":textures/armor/" + material.getName() + "/" + (legs ? 2 : 1) + (overlay == null ? "" : overlay) + ".png", ResourceLocation::new));
            cir.cancel();
        }
    }
}
