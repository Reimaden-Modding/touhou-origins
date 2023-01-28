package net.reimaden.touhouorigins.mixin;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ActiveTargetGoal.class)
public interface ActiveTargetGoalAccessor {

    @Accessor("targetEntity")
    LivingEntity targetEntity();
}
