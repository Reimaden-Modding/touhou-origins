package net.reimaden.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.reimaden.touhouorigins.power.ModifyBehaviorPower;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.AbstractPiglinEntity;
import net.minecraft.entity.mob.PiglinBrain;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(PiglinBrain.class)
public class PiglinBrainMixin {

    @Inject(method = "wearsGoldArmor", at = @At("HEAD"), cancellable = true)
    private static void lobotomizePiglin(LivingEntity target, CallbackInfoReturnable<Boolean> cir) {
        List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(target, ModifyBehaviorPower.class);
        powers.removeIf((power) -> !power.checkEntity(EntityType.PIGLIN));

        if (!powers.isEmpty()) {
            ModifyBehaviorPower.EntityBehavior behavior = powers.get(0).getDesiredBehavior();
            if(behavior == ModifyBehaviorPower.EntityBehavior.NEUTRAL || behavior == ModifyBehaviorPower.EntityBehavior.PASSIVE) {
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(method = "onGuardedBlockInteracted", at = @At("HEAD"), cancellable = true)
    private static void lobotomizePiglin(PlayerEntity player, boolean blockOpen, CallbackInfo ci) {
        List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(player, ModifyBehaviorPower.class);
        powers.removeIf((power) -> !power.checkEntity(EntityType.PIGLIN));

        if (!powers.isEmpty()) {
            ModifyBehaviorPower.EntityBehavior behavior = powers.get(0).getDesiredBehavior();
            if(behavior == ModifyBehaviorPower.EntityBehavior.NEUTRAL || behavior == ModifyBehaviorPower.EntityBehavior.PASSIVE) {
                ci.cancel();
            }
        }
    }

    @Inject(method = "tryRevenge", at = @At("HEAD"), cancellable = true)
    private static void lobotomizePiglin(AbstractPiglinEntity piglin, LivingEntity target, CallbackInfo ci) {
        List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(target, ModifyBehaviorPower.class);
        powers.removeIf((power) -> !power.checkEntity(EntityType.PIGLIN));

        if (!powers.isEmpty()) {
            ModifyBehaviorPower.EntityBehavior behavior = powers.get(0).getDesiredBehavior();
            if(behavior == ModifyBehaviorPower.EntityBehavior.PASSIVE) {
                ci.cancel();
            }
        }
    }
}
