package net.maxmani.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower;
import net.maxmani.touhouorigins.power.ModifyBehaviorPower.EntityBehavior;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Shearable;
import net.minecraft.entity.ai.RangedAttackMob;
import net.minecraft.entity.ai.goal.ActiveTargetGoal;
import net.minecraft.entity.passive.GolemEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(SnowGolemEntity.class)
public abstract class SnowGolemEntityMixin extends GolemEntity implements Shearable, RangedAttackMob {

    SnowGolemEntityMixin(EntityType<? extends GolemEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(at = @At(value = "RETURN"), method = "initGoals")
    public void initPlayerZombieGoals(CallbackInfo info) {
        this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, 10, true, false, (entity) -> {
            if(entity instanceof PlayerEntity player) {
                List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(player, ModifyBehaviorPower.class);
                powers.removeIf((power) -> !power.checkEntity(this.getType()));

                if (!powers.isEmpty()) {
                    EntityBehavior behavior = powers.get(0).getDesiredBehavior();
                    return behavior == EntityBehavior.HOSTILE;
                }
            }
            return false;
        }));
    }
}
