package net.reimaden.touhouorigins.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.reimaden.touhouorigins.TouhouOrigins;

@SuppressWarnings("unused")
public class ModSoundEvents {

    public static final SoundEvent ORIGIN_ONI_STEP = registerSound("origin.oni.step");
    public static final SoundEvent ORIGIN_FAIRY_HEAL = registerSound("origin.fairy.heal");
    public static final SoundEvent ORIGIN_FAIRY_FLY = registerSound("origin.fairy.fly");
    public static final SoundEvent ORIGIN_KAPPA_CAMOUFLAGE_ACTIVATE = registerSound("origin.kappa.camouflage_activate");
    public static final SoundEvent ORIGIN_KAPPA_CAMOUFLAGE_DEACTIVATE = registerSound("origin.kappa.camouflage_deactivate");
    public static final SoundEvent ORIGIN_KAPPA_DRY = registerSound("origin.kappa.dry");

    private static SoundEvent registerSound(String name) {
        Identifier id = TouhouOrigins.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {
        TouhouOrigins.LOGGER.debug("Registering sound events for " + TouhouOrigins.MOD_ID);
    }
}
