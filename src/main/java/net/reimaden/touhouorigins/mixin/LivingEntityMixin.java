package net.reimaden.touhouorigins.mixin;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public class LivingEntityMixin {

    @Inject(method = "getPreferredEquipmentSlot", at = @At("HEAD"), cancellable = true)
    private static void canEquipHead(ItemStack stack, CallbackInfoReturnable<EquipmentSlot> cir) {
        if (stack.hasNbt()) { //Allows NBT tagged items to be placed on the player's head, vanilla behavior has special rendering rules for most items
            NbtCompound nbt = stack.getNbt();
            if (nbt.contains("head_slottable")) {
                cir.setReturnValue(EquipmentSlot.HEAD);
            }
        }
    }
}
