package net.maxmani.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.maxmani.touhouorigins.power.ModifyBehavior;
import net.maxmani.touhouorigins.power.ModifyBehavior.EntityBehavior;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(ActiveTargetGoal.class)
public class ActiveTargetGoalMixin {

    @Inject(at = @At(value = "HEAD"), method = "start", cancellable = true)
    public void blockZombieTarget(CallbackInfo info) {
        ActiveTargetGoal target = (ActiveTargetGoal) (Object) this;

        List<ModifyBehavior> powers = PowerHolderComponent.getPowers(((ActiveTargetGoalAccessor) target).targetEntity(), ModifyBehavior.class);
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
