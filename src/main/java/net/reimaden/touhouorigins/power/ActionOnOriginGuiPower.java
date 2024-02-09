package net.reimaden.touhouorigins.power;

import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.calio.data.SerializableData;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.reimaden.touhouorigins.TouhouOrigins;

import java.util.function.Consumer;

public class ActionOnOriginGuiPower extends Power {

    private final Consumer<Entity> entityAction;

    public ActionOnOriginGuiPower(PowerType<?> type, LivingEntity entity, Consumer<Entity> entityAction) {
        super(type, entity);
        this.entityAction = entityAction;
    }

    public void onGuiOpen() {
        this.entityAction.accept(this.entity);
    }

    public static PowerFactory<Power> createFactory() {
        return new PowerFactory<>(
                TouhouOrigins.id("action_on_origin_gui"),
                new SerializableData()
                        .add("entity_action", ApoliDataTypes.ENTITY_ACTION),
                data -> (type, entity) -> new ActionOnOriginGuiPower(type, entity, data.get("entity_action"))
        ).allowCondition();
    }
}
