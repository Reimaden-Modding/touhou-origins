package net.maxmani.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower.EntityBehavior;
import net.minecraft.entity.mob.EndermanEntity;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(EndermanEntity.class)
public class EndermanEntityMixin {

    @Inject(method = "isPlayerStaring", at = @At("HEAD"), cancellable = true)
    public void blockEndermanTarget(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(player, ModifyBehaviorPower.class);
        powers.removeIf((power) -> !power.checkEntity(player.getType()));

        if (!powers.isEmpty()) {
            EntityBehavior behavior = powers.get(0).getDesiredBehavior();
            if(behavior == EntityBehavior.NEUTRAL) {
                cir.setReturnValue(false);
            }
        }
    }
}
