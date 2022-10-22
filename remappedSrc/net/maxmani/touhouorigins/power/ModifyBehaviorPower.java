package net.maxmani.touhouorigins.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;

import java.util.List;

public class ModifyBehaviorPower extends Power {

    private final List<EntityType<?>> affectedEntities;
    private final EntityBehavior desiredBehavior;
    private final boolean inverted;

    public ModifyBehaviorPower(PowerType<?> type, PlayerEntity player, EntityBehavior desiredBehavior, List<EntityType<?>> affectedEntities, boolean inverted) {
        super(type, player);
        this.affectedEntities = affectedEntities;
        this.desiredBehavior = desiredBehavior;
        this.inverted = inverted;
    }

    public boolean checkEntity(EntityType<?> type) {
        if (inverted) {
            return !affectedEntities.contains(type);
        }
        return affectedEntities.contains(type);
    }

    public EntityBehavior getDesiredBehavior() {
        return this.desiredBehavior;
    }

    public enum EntityBehavior {
        HOSTILE,
        NEUTRAL,
        PASSIVE
    }
}
