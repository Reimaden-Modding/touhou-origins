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
    public static final SoundEvent ENTITY_CELESTIAL_EVOLVE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.celestial.evolve"));
    public static final SoundEvent ENTITY_CELESTIAL_DIVINITY_RESTORE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.celestial.divinity_restore"));
    public static final SoundEvent ENTITY_CELESTIAL_DIVINITY_DEPLETE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.celestial.divinity_deplete"));
    public static final SoundEvent ENTITY_CELESTIAL_PREVENT_DEATH = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.celestial.prevent_death"));
    public static final SoundEvent ENTITY_VENGEFUL_SPIRIT_HEAL = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.vengeful_spirit.heal"));
    public static final SoundEvent ENTITY_VENGEFUL_SPIRIT_HARVEST = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.vengeful_spirit.harvest"));
    public static final SoundEvent ENTITY_VENGEFUL_SPIRIT_HURT = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.vengeful_spirit.hurt"));
    public static final SoundEvent ENTITY_VENGEFUL_SPIRIT_DEATH = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.vengeful_spirit.death"));
    public static final SoundEvent ENTITY_HANIWA_RESIST = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.haniwa.resist"));
    public static final SoundEvent ENTITY_HANIWA_BREAK = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.haniwa.break"));
    public static final SoundEvent ENTITY_RABBIT_HOP = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.rabbit.hop"));
    public static final SoundEvent ENTITY_MOON_RABBIT_ACTIVATE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.moon_rabbit.activate"));
    public static final SoundEvent ENTITY_MOON_RABBIT_DEACTIVATE = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.moon_rabbit.deactivate"));
    public static final SoundEvent ENTITY_HELL_RAVEN_DECAY = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.hell_raven.decay"));
    public static final SoundEvent ENTITY_HELL_RAVEN_ALERT = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.hell_raven.alert"));
    public static final SoundEvent ENTITY_HELL_RAVEN_SHOOT = new SoundEvent(new Identifier(TouhouOrigins.MOD_ID,"entity.hell_raven.shoot"));

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
        Registry.register(Registry.SOUND_EVENT, ENTITY_CELESTIAL_EVOLVE.getId(), ENTITY_CELESTIAL_EVOLVE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_CELESTIAL_DIVINITY_RESTORE.getId(), ENTITY_CELESTIAL_DIVINITY_RESTORE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_CELESTIAL_DIVINITY_DEPLETE.getId(), ENTITY_CELESTIAL_DIVINITY_DEPLETE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_CELESTIAL_PREVENT_DEATH.getId(), ENTITY_CELESTIAL_PREVENT_DEATH);
        Registry.register(Registry.SOUND_EVENT, ENTITY_VENGEFUL_SPIRIT_HEAL.getId(), ENTITY_VENGEFUL_SPIRIT_HEAL);
        Registry.register(Registry.SOUND_EVENT, ENTITY_VENGEFUL_SPIRIT_HARVEST.getId(), ENTITY_VENGEFUL_SPIRIT_HARVEST);
        Registry.register(Registry.SOUND_EVENT, ENTITY_VENGEFUL_SPIRIT_HURT.getId(), ENTITY_VENGEFUL_SPIRIT_HURT);
        Registry.register(Registry.SOUND_EVENT, ENTITY_VENGEFUL_SPIRIT_DEATH.getId(), ENTITY_VENGEFUL_SPIRIT_DEATH);
        Registry.register(Registry.SOUND_EVENT, ENTITY_HANIWA_RESIST.getId(), ENTITY_HANIWA_RESIST);
        Registry.register(Registry.SOUND_EVENT, ENTITY_HANIWA_BREAK.getId(), ENTITY_HANIWA_BREAK);
        Registry.register(Registry.SOUND_EVENT, ENTITY_RABBIT_HOP.getId(), ENTITY_RABBIT_HOP);
        Registry.register(Registry.SOUND_EVENT, ENTITY_MOON_RABBIT_ACTIVATE.getId(), ENTITY_MOON_RABBIT_ACTIVATE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_MOON_RABBIT_DEACTIVATE.getId(), ENTITY_MOON_RABBIT_DEACTIVATE);
        Registry.register(Registry.SOUND_EVENT, ENTITY_HELL_RAVEN_DECAY.getId(), ENTITY_HELL_RAVEN_DECAY);
        Registry.register(Registry.SOUND_EVENT, ENTITY_HELL_RAVEN_ALERT.getId(), ENTITY_HELL_RAVEN_ALERT);
        Registry.register(Registry.SOUND_EVENT, ENTITY_HELL_RAVEN_SHOOT.getId(), ENTITY_HELL_RAVEN_SHOOT);
    }
}
