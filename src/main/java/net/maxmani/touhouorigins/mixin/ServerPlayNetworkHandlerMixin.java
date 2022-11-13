package net.maxmani.touhouorigins.mixin;

import net.maxmani.touhouorigins.registry.ModPowers;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin  {

    @Shadow public ServerPlayerEntity player;
    @Shadow private int floatingTicks;

    @Inject(method = "tick", at = @At("HEAD"))
    public void noFlightKick(CallbackInfo ci) {
        if (ModPowers.CAN_FLY.isActive(player) && this.floatingTicks >= 60) { //there is probably a better way, but this works
            this.floatingTicks = 0;
        }
    }
}
