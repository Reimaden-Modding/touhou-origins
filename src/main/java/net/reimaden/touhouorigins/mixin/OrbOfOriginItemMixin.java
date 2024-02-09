package net.reimaden.touhouorigins.mixin;

import io.github.apace100.apoli.component.PowerHolderComponent;
import io.github.apace100.origins.content.OrbOfOriginItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.reimaden.touhouorigins.power.ActionOnOriginGuiPower;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(OrbOfOriginItem.class)
public class OrbOfOriginItemMixin {

    @Inject(method = "use", at = @At("HEAD"))
    private void touhouorigins$invokeActions(World world, PlayerEntity user, Hand hand, CallbackInfoReturnable<TypedActionResult<ItemStack>> cir) {
        List<ActionOnOriginGuiPower> powers = PowerHolderComponent.getPowers(user, ActionOnOriginGuiPower.class);
        if (!powers.isEmpty()) {
            powers.forEach(ActionOnOriginGuiPower::onGuiOpen);
        }
    }
}
