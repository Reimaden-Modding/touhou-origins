package net.reimaden.touhouorigins.power;

import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.power.factory.PowerFactorySupplier;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.registry.Registry;
import net.reimaden.touhouorigins.TouhouOrigins;

public class ModPowers {

    public static void register() {
        TouhouOrigins.LOGGER.debug("Registering power types for " + TouhouOrigins.MOD_ID);

        registerPower(ActionOnOriginGuiPower::createFactory);
    }

    private static void registerPower(PowerFactory<?> factory) {
        Registry.register(ApoliRegistries.POWER_FACTORY, factory.getSerializerId(), factory);
    }

    private static void registerPower(PowerFactorySupplier<?> factorySupplier) {
        registerPower(factorySupplier.createFactory());
    }
}
