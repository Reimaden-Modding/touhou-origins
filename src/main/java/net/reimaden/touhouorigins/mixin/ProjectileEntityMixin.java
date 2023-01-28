package net.reimaden.touhouorigins.mixin;

import net.reimaden.touhouorigins.registry.ModPowers;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.ProjectileEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(ProjectileEntity.class)
public class ProjectileEntityMixin {

    @ModifyVariable(method = "setVelocity(Lnet/minecraft/entity/Entity;FFFFF)V", at = @At("HEAD"), ordinal = 4, argsOnly = true)
    private float modifyDivergence(float oldDivergence, Entity user) {
        if(ModPowers.CLUMSY_ARCHER.isActive(user)) {
            return 10F;
        }
        return oldDivergence;
    }
}
