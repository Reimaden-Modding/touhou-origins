package net.maxmani.touhouorigins.registry;

import net.maxmani.touhouorigins.TouhouOrigins;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModSounds {
    public static final SoundEvent ENTITY_ONI_STEP = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.oni.step"));
    public static final SoundEvent ENTITY_FAIRY_HEAL = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.fairy.heal"));
    public static final SoundEvent ENTITY_FAIRY_FLY = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.fairy.fly"));
    public static final SoundEvent ENTITY_KAPPA_CAMOUFLAGE_ACTIVATE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.kappa.camouflage_activate"));
    public static final SoundEvent ENTITY_KAPPA_CAMOUFLAGE_DEACTIVATE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.kappa.camouflage_deactivate"));
    public static final SoundEvent ENTITY_KAPPA_DRY = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.kappa.dry"));
    public static final SoundEvent ENTITY_SATORI_RECOLLECT = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.satori.recollect"));
    public static final SoundEvent ENTITY_SATORI_CLOSE_EYE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.satori.close_eye"));
    public static final SoundEvent ENTITY_GENERIC_GUST = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.generic.gust"));
    public static final SoundEvent ENTITY_WOLF_TENGU_GROWL = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.wolf_tengu.growl"));
    public static final SoundEvent ENTITY_GHOST_HURT = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.ghost.hurt"));
    public static final SoundEvent ENTITY_GHOST_DEATH = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.ghost.death"));

    public static void register() {
        Registry.register(Registry.SOUND_EVENT, ENTITY_ONI_STEP.getId(), ENTITY_ONI_STEP);
        Registry.register(Registry.SOUND_EVENT, ENTITY_FAIRY_HEAL.getId(), ENTITY_FAIRY_HEAL);
        Registry.register(Registry.SOUND_EVENT, ENTITY_FAIRY_FLY.getId(), ENTITY_FAIRY_FLY);
        Registry.register(Registry.SOUND_EVENT, ENTITY_KAPPA_CAMOUFLAGE_ACTIVATE.getId(), ENTITY_KAPPA_CAMOUFLAGE_ACTIVATE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_KAPPA_CAMOUFLAGE_DEACTIVATE.getId(), ENTITY_KAPPA_CAMOUFLAGE_DEACTIVATE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_KAPPA_DRY.getId(), ENTITY_KAPPA_DRY);
        Registry.register(Registry.SOUND_EVENT, ENTITY_SATORI_RECOLLECT.getId(), ENTITY_SATORI_RECOLLECT);
        Registry.register(Registry.SOUND_EVENT, ENTITY_SATORI_CLOSE_EYE.getId(), ENTITY_SATORI_CLOSE_EYE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_GENERIC_GUST.getId(), ENTITY_GENERIC_GUST);
        Registry.register(Registry.SOUND_EVENT, ENTITY_WOLF_TENGU_GROWL.getId(), ENTITY_WOLF_TENGU_GROWL);
        Registry.register(Registry.SOUND_EVENT, ENTITY_GHOST_HURT.getId(), ENTITY_GHOST_HURT);
        Registry.register(Registry.SOUND_EVENT, ENTITY_GHOST_DEATH.getId(), ENTITY_GHOST_DEATH);
    }
}
