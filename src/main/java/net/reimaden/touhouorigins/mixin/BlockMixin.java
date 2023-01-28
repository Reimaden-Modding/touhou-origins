package net.reimaden.touhouorigins.mixin;

import net.reimaden.touhouorigins.registry.ModPowers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stat.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import static net.minecraft.block.Block.dropStacks;

@Mixin(Block.class)
public class BlockMixin {

    @Inject(method = "afterBreak", at = @At("HEAD"), cancellable = true)
    private void noMixingExhaustion(World world, PlayerEntity player, BlockPos pos, BlockState state, BlockEntity blockEntity, ItemStack stack, CallbackInfo ci) {
        Block block = ((Block) (Object) this);
        if(ModPowers.NO_MINING_EXHAUSTION.isActive(player)) {
            // This is kinda scuffed, but it works ¯\_(ツ)_/¯
            ci.cancel();
            player.incrementStat(Stats.MINED.getOrCreateStat(block));
            dropStacks(state, world, pos, blockEntity, player, stack);
        }
    }
}
