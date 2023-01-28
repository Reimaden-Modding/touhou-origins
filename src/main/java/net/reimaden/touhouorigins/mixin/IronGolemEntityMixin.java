package net.reimaden.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.reimaden.touhouorigins.power.ModifyBehaviorPower;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.GoalSelector;
import net.minecraft.entity.mob.Angerable;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.List;

@Mixin(IronGolemEntity.class)
public abstract class IronGolemEntityMixin extends GolemEntity implements Angerable {

    protected IronGolemEntityMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Redirect(method = "initGoals", at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/goal/GoalSelector;add(ILnet/minecraft/entity/ai/goal/Goal;)V", ordinal = 9))
    public void overrideFollowTargetGoalForZombies(GoalSelector goalSelector, int priority, Goal goal) {
        Goal newGoal = new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, (entity) -> {
            if(entity != null) {

                List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(entity, ModifyBehaviorPower.class);
                powers.removeIf((power) -> !power.checkEntity(EntityType.IRON_GOLEM));

                boolean zombified = false;

                if(!powers.isEmpty()) {
                    zombified = powers.get(0).getDesiredBehavior() == ModifyBehaviorPower.EntityBehavior.HOSTILE;
                }

                return this.shouldAngerAt(entity) || zombified;
            }

            return false;
        });
        goalSelector.add(priority, newGoal);
    }
}
