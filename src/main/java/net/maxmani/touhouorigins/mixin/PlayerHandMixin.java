package net.maxmani.touhouorigins.mixin;

import net.maxmani.touhouorigins.registry.ModPowers;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BipedEntityModel.class)
public class PlayerHandMixin<T extends LivingEntity> {

    @Shadow @Final public ModelPart rightArm;

    @Shadow @Final public ModelPart leftArm;

    @Inject(method = "setAngles(Lnet/minecraft/entity/LivingEntity;FFFFF)V",at = @At("TAIL"))
    public void setAngles(T livingEntity, float f, float g, float h, float i, float j, CallbackInfo ci) {
        if (ModPowers.ZOMBIE_ARMS.isActive(livingEntity) && (!livingEntity.isInSwimmingPose() && (!livingEntity.isFallFlying()) && (!livingEntity.isUsingItem()))) {
            this.rightArm.pitch = rightArm.pitch * 0.05F - 1.4137167F;
            this.leftArm.pitch = leftArm.pitch * 0.05F - 1.4137167F;
        }
    }
}
