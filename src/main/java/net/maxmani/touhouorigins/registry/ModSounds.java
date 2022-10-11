package net.maxmani.touhouorigins.registry;

import net.maxmani.touhouorigins.TouhouOrigins;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static final SoundEvent ENTITY_ONI_STEP = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID, "entity.oni.step"));
    public static final SoundEvent ENTITY_FAIRY_HEAL = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID, "entity.fairy.heal"));
    public static final SoundEvent ENTITY_FAIRY_FLY = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID, "entity.fairy.fly"));
    public static final SoundEvent ENTITY_KAPPA_CAMOUFLAGE_ACTIVATE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID, "entity.kappa.camouflage_activate"));
    public static final SoundEvent ENTITY_KAPPA_CAMOUFLAGE_DEACTIVATE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID, "entity.kappa.camouflage_deactivate"));
    public static final SoundEvent ENTITY_KAPPA_DRY = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID, "entity.kappa.dry"));

    public static void init() {
        Registry.register(Registry.SOUND_EVENT, ENTITY_ONI_STEP.getId(), ENTITY_ONI_STEP);
        Registry.register(Registry.SOUND_EVENT, ENTITY_FAIRY_HEAL.getId(), ENTITY_FAIRY_HEAL);
        Registry.register(Registry.SOUND_EVENT, ENTITY_FAIRY_FLY.getId(), ENTITY_FAIRY_FLY);
        Registry.register(Registry.SOUND_EVENT, ENTITY_KAPPA_CAMOUFLAGE_ACTIVATE.getId(), ENTITY_KAPPA_CAMOUFLAGE_ACTIVATE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_KAPPA_CAMOUFLAGE_DEACTIVATE.getId(), ENTITY_KAPPA_CAMOUFLAGE_DEACTIVATE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_KAPPA_DRY.getId(), ENTITY_KAPPA_DRY);
    }
}
