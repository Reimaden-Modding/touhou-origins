package net.maxmani.touhouorigins.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.StackReference;
import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.ClickType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

//prevents NBT tagged items from being inserted into bundles

@Mixin(BundleItem.class)
public class BundleItemMixin{

    @Inject(method = "onClicked", at = @At("HEAD"), cancellable = true)
    private void preventInsert(ItemStack stack, ItemStack otherStack, Slot slot, ClickType clickType, PlayerEntity player, StackReference cursorStackReference, CallbackInfoReturnable<Boolean> cir) {
        if (otherStack.hasNbt()) {
            NbtCompound nbt = otherStack.getNbt();
            if (nbt.contains("tsukumogami_bound")) {
                cir.cancel();
            }
        }
    }

    @Inject(method = "onStackClicked", at = @At("HEAD"), cancellable = true)
    private void preventInsert(ItemStack stack, Slot slot, ClickType clickType, PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        if (slot.hasStack()){
            ItemStack slotStack = slot.getStack();
            if (slotStack.hasNbt()) {
                NbtCompound nbt = slotStack.getNbt();
                if (nbt.contains("tsukumogami_bound")) {
                    cir.cancel();
                }
            }
        }
    }
}
