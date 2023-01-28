package net.reimaden.touhouorigins.registry;

import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.factory.condition.ConditionFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.apoli.util.Comparison;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.registry.Registry;
import net.reimaden.touhouorigins.TouhouOrigins;
import net.minecraft.entity.Entity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;

public class ModConditions {

    public static final ConditionFactory<ItemStack> ENCHANTABILITY = new ConditionFactory<>(new Identifier(TouhouOrigins.MOD_ID, "enchantability"), new SerializableData()
            .add("comparison", ApoliDataTypes.COMPARISON)
            .add("compare_to", SerializableDataTypes.INT),
            (data, itemStack) -> {
                int itemEnchantability;
                if (itemStack.getItem() instanceof ToolItem item) {
                    itemEnchantability = item.getMaterial().getEnchantability();
                } else if (itemStack.getItem() instanceof ArmorItem item) {
                    itemEnchantability = item.getMaterial().getEnchantability();
                } else {
                    Item item = itemStack.getItem();
                    itemEnchantability = item.getEnchantability();
                }
                return ((Comparison)data.get("comparison")).compare(itemEnchantability, data.getInt("compare_to"));
            });

    public static final ConditionFactory<Entity> MOON_PHASE = new ConditionFactory<>(new Identifier(TouhouOrigins.MOD_ID, "moon_phase"), new SerializableData()
            .add("comparison", ApoliDataTypes.COMPARISON)
            .add("compare_to", SerializableDataTypes.INT),
            (data, entity) ->
                    ((Comparison)data.get("comparison")).compare(entity.getEntityWorld().getMoonPhase(), data.getInt("compare_to")));

    public static void register() {
        Registry.register(ApoliRegistries.ENTITY_CONDITION, MOON_PHASE.getSerializerId(), MOON_PHASE);
        Registry.register(ApoliRegistries.ITEM_CONDITION, ENCHANTABILITY.getSerializerId(), ENCHANTABILITY);
    }
}
