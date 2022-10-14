package net.maxmani.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower.EntityBehavior;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.WardenEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(WardenEntity.class)
public abstract class WardenEntityMixin {

    @Inject(method = "isValidTarget", at = @At("HEAD"), cancellable = true)
    public void blockWardenTarget(Entity entity, CallbackInfoReturnable<Boolean> cir) {
        List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(entity, ModifyBehaviorPower.class);

        if (!powers.isEmpty()) {
            EntityBehavior behavior = powers.get(0).getDesiredBehavior();
            if(behavior == EntityBehavior.PASSIVE) {
                cir.setReturnValue(false);
            }
        }
    }
}
