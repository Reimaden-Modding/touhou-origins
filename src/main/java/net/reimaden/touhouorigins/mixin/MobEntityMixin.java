package net.reimaden.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import net.reimaden.touhouorigins.power.ModifyBehaviorPower;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.List;

@Mixin(MobEntity.class)
public abstract class MobEntityMixin extends LivingEntity {

    protected MobEntityMixin(EntityType<? extends LivingEntity> entityType, World level) {
        super(entityType, level);
    }

    @ModifyVariable(method = "setTarget", at = @At("HEAD"), argsOnly = true)
    private LivingEntity modifyTarget(LivingEntity target) {
        if (world.isClient() || !(target instanceof PlayerEntity)) {
            return target;
        }

        List<ModifyBehaviorPower> powers = PowerHolderComponent.getPowers(target, ModifyBehaviorPower.class);
        boolean checkEntity = powers.stream().anyMatch(power -> power.checkEntity(this.getType()));

        if (!powers.isEmpty()) {
            ModifyBehaviorPower.EntityBehavior behavior = powers.get(0).getDesiredBehavior();
            if(behavior == ModifyBehaviorPower.EntityBehavior.PASSIVE) {
                return checkEntity ? null : target;
            }
        }
        return target;
    }
}
