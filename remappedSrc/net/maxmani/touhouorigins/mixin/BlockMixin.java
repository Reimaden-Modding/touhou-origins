package net.maxmani.touhouorigins.mixin;

import net.maxmani.touhouorigins.registry.ModPowers;
import net.minecraft.block.Block;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(Block.class)
public class BlockMixin {

    @ModifyConstant(method = "afterBreak", constant = @Constant(floatValue = 0.005F))
    private float preventMiningExhaustion(float exhaustion, World world, PlayerEntity playerEntity) {
        if(ModPowers.NO_MINING_EXHAUSTION.isActive(playerEntity)) {
            return 0F;
        }
        return exhaustion;
    }
}
