package net.reimaden.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import io.github.apace100.origins.command.OriginCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.reimaden.touhouorigins.power.ActionOnOriginGuiPower;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(OriginCommand.class)
public class OriginCommandMixin {

    @Inject(method = "openLayerScreen(Lnet/minecraft/server/network/ServerPlayerEntity;)V", at = @At("HEAD"))
    private static void touhouorigins$invokeActions(ServerPlayerEntity target, CallbackInfo ci) {
        List<ActionOnOriginGuiPower> powers = PowerHolderComponent.getPowers(target, ActionOnOriginGuiPower.class);
        if (!powers.isEmpty()) {
            powers.forEach(ActionOnOriginGuiPower::onGuiOpen);
        }
    }
}
