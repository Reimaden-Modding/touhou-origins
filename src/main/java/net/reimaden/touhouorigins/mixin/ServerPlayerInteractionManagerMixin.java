package net.reimaden.touhouorigins.mixin;

import net.minecraft.block.ComposterBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LockableContainerBlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.network.ServerPlayerInteractionManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;

@Mixin(ServerPlayerInteractionManager.class)
public class ServerPlayerInteractionManagerMixin {

    private static final List<BlockEntityType<?>> BLOCK_WHITELIST = Arrays.asList(
            BlockEntityType.BEACON,
            BlockEntityType.BED,
            BlockEntityType.BEEHIVE,
            BlockEntityType.BELL,
            BlockEntityType.COMMAND_BLOCK,
            BlockEntityType.COMPARATOR,
            BlockEntityType.DAYLIGHT_DETECTOR,
            BlockEntityType.ENCHANTING_TABLE,
            BlockEntityType.ENDER_CHEST,
            BlockEntityType.SIGN
    );

    @Inject(method = "interactBlock", at = @At("HEAD"), cancellable = true)
    public void interactBlock(ServerPlayerEntity player, World world, ItemStack stack, Hand hand, BlockHitResult hitResult, CallbackInfoReturnable<ActionResult> cir) {
        if (stack.hasNbt()) {
            NbtCompound nbt = stack.getNbt();
            if (nbt.contains("tsukumogami_bound")) {
                BlockEntityType<?> targetBlockEntityType = player.world.getBlockEntity(hitResult.getBlockPos()).getType();
                BlockEntity targetBlockEntity = player.world.getBlockEntity(hitResult.getBlockPos());
                if (!(BLOCK_WHITELIST.contains(targetBlockEntityType)) && !(targetBlockEntity instanceof LockableContainerBlockEntity)) { //Anything that is not a LockableContainerBlockEntity (inventory with GUIs) and not part of the trusted whitelist cannot be interacted with, this prevents onUse actions from inserting the NBT tagged hand item into the block
                    cir.setReturnValue(ActionResult.FAIL);
                }
                if (player.world.getBlockState(hitResult.getBlockPos()).getBlock() instanceof ComposterBlock) { //This doesn't need clientside sync for some reason TODO: 29-Nov-22 get a more comprehensive list of non-blockentity blocks with onUse actions that consume items
                    cir.setReturnValue(ActionResult.FAIL);
                }
            }
        }
    }
}