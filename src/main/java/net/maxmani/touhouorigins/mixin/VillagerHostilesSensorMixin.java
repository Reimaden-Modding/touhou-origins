package net.maxmani.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower.EntityBehavior;
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

    @Inject(at = @At(value = "HEAD"), method = "isHostile", cancellable = true)
    public void markZombiePlayerAsHostile(final LivingEntity entity, CallbackInfoReturnable<Boolean> info) {
        List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(entity, ModifyBehaviorPower.class);

        if (!powers.isEmpty()) {
            EntityBehavior behavior = powers.get(0).getDesiredBehavior();
            if(behavior == EntityBehavior.HOSTILE) {
                info.setReturnValue(true);
            }
        }
    }

    @Inject(at = @At(value = "HEAD"), method = "isCloseEnoughForDanger", cancellable = true)
    public void zombiePlayerIsCloseEnoughForDanger(LivingEntity entity, LivingEntity hostile, CallbackInfoReturnable<Boolean> info) {
        if(hostile instanceof PlayerEntity player) {
            List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(player, ModifyBehaviorPower.class);

            if (!powers.isEmpty() && !player.isCreative()) {
                EntityBehavior behavior = powers.get(0).getDesiredBehavior();
                if(behavior == EntityBehavior.HOSTILE) {
                    float distanceRequired = 8.0f;
                    if(hostile.squaredDistanceTo(entity) <= (double)(distanceRequired * distanceRequired)) {
                        info.setReturnValue(true);
                    } else {
                        info.setReturnValue(false);
                    }
                } else {
                    info.setReturnValue(false);
                }
            } else {
                info.setReturnValue(false);
            }
        }
    }
}
