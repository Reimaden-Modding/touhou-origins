package net.reimaden.touhouorigins.mixin;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.slot.ShulkerBoxSlot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ShulkerBoxSlot.class)
public class ShulkerBoxSlotMixin {

    @Inject(method = "canInsert", at = @At("HEAD"), cancellable = true)
    private void preventInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.hasNbt()) { //prevents NBT tagged items from being inserted into shulker boxes
            NbtCompound nbt = stack.getNbt();
            if (nbt.contains("tsukumogami_bound")) {
                cir.setReturnValue(false);
            }
        }
    }
}
