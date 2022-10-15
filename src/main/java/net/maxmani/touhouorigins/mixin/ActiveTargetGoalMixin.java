package net.maxmani.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower.EntityBehavior;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ActiveTargetGoal.class)
public class ActiveTargetGoalMixin {

    @Inject(method = "start", at = @At("HEAD"), cancellable = true)
    public void blockZombieTarget(CallbackInfo info) {
        ActiveTargetGoal target = (ActiveTargetGoal) (Object) this;

        List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(((ActiveTargetGoalAccessor) target).targetEntity(), ModifyBehaviorPower.class);
        powers.removeIf((power) -> !power.checkEntity(((TrackTargetGoalAccessor) target).getMob().getType()));

        if (!powers.isEmpty()) {
            EntityBehavior behavior = powers.get(0).getDesiredBehavior();
            if(behavior == EntityBehavior.NEUTRAL) {
                target.stop();
                info.cancel();
            }
        }
    }
}
