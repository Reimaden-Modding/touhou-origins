package net.maxmani.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.maxmani.touhouorigins.power.ModifyBehavior;
import net.maxmani.touhouorigins.power.ModifyBehavior.EntityBehavior;
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

    IronGolemEntityMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Redirect(at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/goal/GoalSelector;add(ILnet/minecraft/entity/ai/goal/Goal;)V", ordinal = 9), method = "initGoals")
    public void overrideFollowTargetGoalForZombies(GoalSelector goalSelector, int priority, Goal goal) {
        Goal newGoal = new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, (entity) -> {
            if(entity != null) {

                List<ModifyBehavior> powers = PowerHolderComponent.getPowers(entity, ModifyBehavior.class);
                powers.removeIf((power) -> !power.checkEntity(EntityType.IRON_GOLEM));

                boolean zombified = false;

                if(!powers.isEmpty()) {
                    zombified = powers.get(0).getDesiredBehavior() == EntityBehavior.HOSTILE;
                }

                return this.shouldAngerAt(entity) || zombified;
            }

            return false;
        });
        goalSelector.add(priority, newGoal);
    }
}
