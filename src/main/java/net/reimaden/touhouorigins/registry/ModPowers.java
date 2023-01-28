package net.reimaden.touhouorigins.registry;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.registry.Registry;
import net.reimaden.touhouorigins.TouhouOrigins;
import net.reimaden.touhouorigins.power.FlipModelPower;
import net.reimaden.touhouorigins.power.ModifyBehaviorPower;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;

import java.util.Collections;

public class ModPowers {

    public static final PowerType<Power> ZOMBIE_ARMS = new PowerTypeReference<>(new Identifier(TouhouOrigins.MOD_ID, "zombie_arms"));
    public static final PowerType<Power> CLUMSY_ARCHER = new PowerTypeReference<>(new Identifier(TouhouOrigins.MOD_ID, "clumsy_archer"));
    public static final PowerType<Power> NO_MINING_EXHAUSTION = new PowerTypeReference<>(new Identifier(TouhouOrigins.MOD_ID, "no_mining_exhaustion"));
    public static final PowerType<Power> CAN_FLY = new PowerTypeReference<>(new Identifier(TouhouOrigins.MOD_ID, "can_fly"));

    public static final PowerFactory<Power> MODIFY_BEHAVIOR = new PowerFactory<>(new Identifier(TouhouOrigins.MOD_ID, "modify_behavior"), new SerializableData()
            .add("behavior", SerializableDataType.enumValue(ModifyBehaviorPower.EntityBehavior.class))
            .add("entities", SerializableDataType.list(SerializableDataTypes.ENTITY_TYPE),
                    Collections.emptyList()).add("inverted", SerializableDataTypes.BOOLEAN, false),
            data -> (type, entity) -> new ModifyBehaviorPower(type, (PlayerEntity) entity, data.get("behavior"), data.get("entities"), data.getBoolean("inverted"))).allowCondition();

    public static final PowerFactory<Power> FLIP_MODEL = new PowerFactory<>(new Identifier(TouhouOrigins.MOD_ID, "flip_model"), new SerializableData(),
            data -> (type, entity) -> new FlipModelPower(type, entity)).allowCondition();

    public static void register() {
        Registry.register(ApoliRegistries.POWER_FACTORY, MODIFY_BEHAVIOR.getSerializerId(), MODIFY_BEHAVIOR);
        Registry.register(ApoliRegistries.POWER_FACTORY, FLIP_MODEL.getSerializerId(), FLIP_MODEL);
    }
}
