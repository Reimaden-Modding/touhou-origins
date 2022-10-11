package net.maxmani.touhouorigins.registry;

import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.PowerTypeReference;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataType;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.maxmani.touhouorigins.TouhouOrigins;
import net.maxmani.touhouorigins.power.ModifyBehavior;
import net.maxmani.touhouorigins.power.ModifyBehavior.EntityBehavior;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModPowers {

    public static final PowerType<Power> ZOMBIE_ARMS = new PowerTypeReference<>(new Identifier(TouhouOrigins.MOD_ID, "zombie_arms"));

    public static final PowerFactory<Power> MODIFY_BEHAVIOR = new PowerFactory<>(new Identifier(TouhouOrigins.MOD_ID, "modify_behavior"), new SerializableData()
            .add("behavior", SerializableDataType.enumValue(EntityBehavior.class))
            .add("entities", SerializableDataType.list(SerializableDataTypes.ENTITY_TYPE)),
            data -> (type, entity) -> new ModifyBehavior(type, (PlayerEntity) entity, data.get("behavior"), data.get("entities")));

    public static void init() {
        Registry.register(ApoliRegistries.POWER_FACTORY, MODIFY_BEHAVIOR.getSerializerId(), MODIFY_BEHAVIOR);
    }
}
