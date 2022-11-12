package net.maxmani.touhouorigins.mixin;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.slot.Slot;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Slot.class)
public class SlotMixin {

    @Inject(method = "canInsert", at = @At("HEAD"), cancellable = true)
    private void preventInsert(ItemStack stack, CallbackInfoReturnable<Boolean> cir) {
        if (stack.hasNbt()) { //prevents NBT tagged items from being inserted into (almost) any inventory GUI that isn't the player's inventory
            NbtCompound nbt = stack.getNbt();
            if (nbt.contains("tsukumogami_bound")) {
                if (!(((Slot) (Object) this).inventory instanceof PlayerInventory)) {
                    cir.cancel();
                }
            }
        }
    }
}
