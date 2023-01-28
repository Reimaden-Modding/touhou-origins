package net.reimaden.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.reimaden.touhouorigins.power.ModifyBehaviorPower;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.sensor.VillagerHostilesSensor;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(VillagerHostilesSensor.class)
public class VillagerHostilesSensorMixin {

    @Inject(method = "isHostile", at = @At("HEAD"), cancellable = true)
    private void markZombiePlayerAsHostile(LivingEntity entity, CallbackInfoReturnable<Boolean> cir) {
        List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(entity, ModifyBehaviorPower.class);
        powers.removeIf((power) -> !power.checkEntity(EntityType.VILLAGER));

        if (!powers.isEmpty()) {
            ModifyBehaviorPower.EntityBehavior behavior = powers.get(0).getDesiredBehavior();
            if(behavior == ModifyBehaviorPower.EntityBehavior.HOSTILE) {
                cir.setReturnValue(true);
            }
        }
    }

    @Inject(method = "isCloseEnoughForDanger", at = @At(value = "HEAD"), cancellable = true)
    private void zombiePlayerIsCloseEnoughForDanger(LivingEntity entity, LivingEntity hostile, CallbackInfoReturnable<Boolean> cir) {
        if(hostile instanceof PlayerEntity player) {
            List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(player, ModifyBehaviorPower.class);
            powers.removeIf((power) -> !power.checkEntity(EntityType.VILLAGER));

            if (!powers.isEmpty() && !player.isCreative()) {
                ModifyBehaviorPower.EntityBehavior behavior = powers.get(0).getDesiredBehavior();
                if(behavior == ModifyBehaviorPower.EntityBehavior.HOSTILE) {
                    float distanceRequired = 8.0f;
                    if(hostile.squaredDistanceTo(entity) <= (double)(distanceRequired * distanceRequired)) {
                        cir.setReturnValue(true);
                    } else {
                        cir.setReturnValue(false);
                    }
                } else {
                    cir.setReturnValue(false);
                }
            } else {
                cir.setReturnValue(false);
            }
        }
    }
}
