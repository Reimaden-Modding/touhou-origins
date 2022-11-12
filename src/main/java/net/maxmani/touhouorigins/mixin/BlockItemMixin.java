package net.maxmani.touhouorigins.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BlockItem.class)
public class BlockItemMixin {

    @Inject(method = "canPlace", at = @At("HEAD"), cancellable = true)
    public void preventPlace(ItemPlacementContext context, BlockState state, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = context.getStack();
        if (stack.hasNbt()) { //NBT tagged items can't be placed
            NbtCompound nbt = stack.getNbt();
            if (nbt.contains("tsukumogami_bound")) {
                cir.cancel();
            }
        }
    }
}
