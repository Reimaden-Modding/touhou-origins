package net.maxmani.touhouorigins.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.collection.DefaultedList;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin {

    @Shadow
    @Final
    public DefaultedList<Slot> slots;


    @Inject(method = "internalOnSlotClick", at = @At("HEAD"), cancellable = true)
    private void preventDrop(int slotIndex, int button, SlotActionType actionType, PlayerEntity player, CallbackInfo ci) {
        ItemStack stack = player.currentScreenHandler.getCursorStack();
        if (stack.hasNbt()) {   //prevents NBT tagged items from being dropped via out of bounds GUI click
            NbtCompound nbt = stack.getNbt();
            if (nbt.contains("tsukumogami_bound")) {
                if (slotIndex == -999) {
                    ci.cancel();
                }
            }
        }
        else if ((actionType == SlotActionType.THROW && stack.isEmpty() && slotIndex >= 0)) {    //prevents NBT tagged items from being dropped via drop key in GUI
            Slot dropslot = this.slots.get(slotIndex);
            if (dropslot.hasStack()) {
                ItemStack stack1 = dropslot.getStack();
                if (stack1.hasNbt()) {
                    NbtCompound nbt = stack1.getNbt();
                    if (nbt.contains("tsukumogami_bound")) {
                        ci.cancel();
                    }
                }
            }
        }
    }
}
