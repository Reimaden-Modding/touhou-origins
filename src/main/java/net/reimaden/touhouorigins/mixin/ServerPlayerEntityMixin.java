package net.reimaden.touhouorigins.mixin;

import com.mojang.authlib.GameProfile;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayerEntity.class)
public abstract class ServerPlayerEntityMixin extends PlayerEntity {

    public ServerPlayerEntityMixin(World world, BlockPos pos, float yaw, GameProfile gameProfile) {
        super(world, pos, yaw, gameProfile);
    }

    @Inject(method = "dropSelectedItem", at = @At("HEAD"), cancellable = true)
    private void preventItemDrop(boolean entireStack, CallbackInfoReturnable<Boolean> cir) {
        ItemStack stack = getMainHandStack();
        if (stack.hasNbt()) { //prevents NBT tagged items from being dropped via drop key
            NbtCompound nbt = stack.getNbt();
            if (nbt.contains("tsukumogami_bound")) {
                cir.setReturnValue(false);
            }
        }
    }
}