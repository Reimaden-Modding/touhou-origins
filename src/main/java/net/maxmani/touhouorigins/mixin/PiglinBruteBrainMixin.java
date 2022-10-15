package net.maxmani.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower.EntityBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.MemoryModuleType;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinBruteBrain;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;
import java.util.Optional;

@Mixin(PiglinBruteBrain.class)
public class PiglinBruteBrainMixin {

    @Inject(method = "getTargetIfInRange", at = @At("RETURN"), cancellable = true)
    private static void lobotomizePiglinBrute(AbstractPiglinEntity piglin, MemoryModuleType<? extends LivingEntity> memoryModuleType, CallbackInfoReturnable<Optional<? extends LivingEntity>> cir) {
        if (cir.getReturnValue().isPresent()) {
            piglin.getBrain().getOptionalMemory(memoryModuleType).filter(entity -> {
                List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(entity, ModifyBehaviorPower.class);
                powers.removeIf((power) -> !power.checkEntity(EntityType.PIGLIN_BRUTE));

                if (!powers.isEmpty()) {
                    EntityBehavior behavior = powers.get(0).getDesiredBehavior();
                    if(behavior == EntityBehavior.NEUTRAL) {
                        cir.setReturnValue(Optional.empty());
                    }
                }
                return false;
            });
        }
    }
}
