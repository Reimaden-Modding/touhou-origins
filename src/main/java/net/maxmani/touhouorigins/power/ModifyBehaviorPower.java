package net.maxmani.touhouorigins.power;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Pair;

import java.util.function.Predicate;

public class ModifyBehaviorPower extends Power {

    Predicate<Entity> mobCondition;
    Predicate<Pair<Entity, Entity>> biEntityCondition;
    EntityBehavior desiredBehavior;

    public ModifyBehaviorPower(PowerType<?> type, PlayerEntity player, EntityBehavior desiredBehavior, Predicate<Entity> mobCondition, Predicate<Pair<Entity, Entity>> biEntityCondition) {
        super(type, player);
        this.mobCondition = mobCondition;
        this.biEntityCondition = biEntityCondition;
        this.desiredBehavior = desiredBehavior;
    }

    public boolean checkEntity(Entity mob) {
        return (this.mobCondition == null || this.mobCondition.test(mob)) && (this.biEntityCondition == null || this.biEntityCondition.test(new Pair<>(entity, mob)));
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
