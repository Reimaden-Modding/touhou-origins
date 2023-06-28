package net.reimaden.touhouorigins.registry;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.reimaden.touhouorigins.TouhouOrigins;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ModSounds {

    public static final SoundEvent ENTITY_ONI_STEP = registerSound("entity.oni.step");
    public static final SoundEvent ENTITY_FAIRY_HEAL = registerSound("entity.fairy.heal");
    public static final SoundEvent ENTITY_FAIRY_FLY = registerSound("entity.fairy.fly");
    public static final SoundEvent ENTITY_KAPPA_CAMOUFLAGE_ACTIVATE = registerSound("entity.kappa.camouflage_activate");
    public static final SoundEvent ENTITY_KAPPA_CAMOUFLAGE_DEACTIVATE = registerSound("entity.kappa.camouflage_deactivate");
    public static final SoundEvent ENTITY_KAPPA_DRY = registerSound("entity.kappa.dry");
    public static final SoundEvent ENTITY_SATORI_RECOLLECT = registerSound("entity.satori.recollect");
    public static final SoundEvent ENTITY_SATORI_CLOSE_EYE = registerSound("entity.satori.close_eye");
    public static final SoundEvent ENTITY_GENERIC_GUST = registerSound("entity.generic.gust");
    public static final SoundEvent ENTITY_WOLF_TENGU_GROWL = registerSound("entity.wolf_tengu.growl");
    public static final SoundEvent ENTITY_GHOST_HURT = registerSound("entity.ghost.hurt");
    public static final SoundEvent ENTITY_GHOST_DEATH = registerSound("entity.ghost.death");
    public static final SoundEvent ENTITY_CELESTIAL_EVOLVE = registerSound("entity.celestial.evolve");
    public static final SoundEvent ENTITY_CELESTIAL_DIVINITY_RESTORE = registerSound("entity.celestial.divinity_restore");
    public static final SoundEvent ENTITY_CELESTIAL_DIVINITY_DEPLETE = registerSound("entity.celestial.divinity_deplete");
    public static final SoundEvent ENTITY_CELESTIAL_PREVENT_DEATH = registerSound("entity.celestial.prevent_death");
    public static final SoundEvent ENTITY_VENGEFUL_SPIRIT_HEAL = registerSound("entity.vengeful_spirit.heal");
    public static final SoundEvent ENTITY_VENGEFUL_SPIRIT_HARVEST = registerSound("entity.vengeful_spirit.harvest");
    public static final SoundEvent ENTITY_VENGEFUL_SPIRIT_HURT = registerSound("entity.vengeful_spirit.hurt");
    public static final SoundEvent ENTITY_VENGEFUL_SPIRIT_DEATH = registerSound("entity.vengeful_spirit.death");
    public static final SoundEvent ENTITY_HANIWA_RESIST = registerSound("entity.haniwa.resist");
    public static final SoundEvent ENTITY_HANIWA_BREAK = registerSound("entity.haniwa.break");
    public static final SoundEvent ENTITY_RABBIT_HOP = registerSound("entity.rabbit.hop");
    public static final SoundEvent ENTITY_MOON_RABBIT_ACTIVATE = registerSound("entity.moon_rabbit.activate");
    public static final SoundEvent ENTITY_MOON_RABBIT_DEACTIVATE = registerSound("entity.moon_rabbit.deactivate");
    public static final SoundEvent ENTITY_HELL_RAVEN_DECAY = registerSound("entity.hell_raven.decay");
    public static final SoundEvent ENTITY_HELL_RAVEN_ALERT = registerSound("entity.hell_raven.alert");
    public static final SoundEvent ENTITY_HELL_RAVEN_SHOOT = registerSound("entity.hell_raven.shoot");
    public static final SoundEvent ENTITY_KURAYAMI_FLIGHT = registerSound("entity.kurayami.flight");
    public static final SoundEvent ENTITY_KURAYAMI_DARKNESS = registerSound("entity.kurayami.darkness");
    public static final SoundEvent ENTITY_KURAYAMI_CHOMP = registerSound("entity.kurayami.chomp");
    public static final SoundEvent ENTITY_FUKURO_GAP_UPGRADE = registerSound("entity.fukuro.gap_upgrade");
    public static final SoundEvent ENTITY_FUKURO_BAG_OPEN = registerSound("entity.fukuro.bag_open");
    public static final SoundEvent ENTITY_EXFUKURO_BAG_OPEN = registerSound("entity.exfukuro.bag_open");
    public static final SoundEvent ENTITY_KARAKASA_ESCAPE = registerSound("entity.karakasa.escape");
    public static final SoundEvent ENTITY_MENREIKI_SWAP = registerSound("entity.menreiki.swap");
    public static final SoundEvent ENTITY_MENREIKI_THORNS = registerSound("entity.menreiki.thorns");

    private static SoundEvent registerSound(String name) {
        Identifier id = new Identifier(TouhouOrigins.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {
        TouhouOrigins.LOGGER.debug("Registering sounds for " + TouhouOrigins.class);
    }
}
