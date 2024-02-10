package net.reimaden.touhouorigins.sound;

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
    public static final SoundEvent ORIGIN_GHOST_HURT = registerSound("origin.ghost.hurt");
    public static final SoundEvent ORIGIN_GHOST_DEATH = registerSound("origin.ghost.death");
    public static final SoundEvent ORIGIN_VENGEFUL_SPIRIT_HEAL = registerSound("origin.vengeful_spirit.heal");
    public static final SoundEvent ORIGIN_VENGEFUL_SPIRIT_HARVEST = registerSound("origin.vengeful_spirit.harvest");
    public static final SoundEvent ORIGIN_VENGEFUL_SPIRIT_HURT = registerSound("origin.vengeful_spirit.hurt");
    public static final SoundEvent ORIGIN_VENGEFUL_SPIRIT_DEATH = registerSound("origin.vengeful_spirit.death");
    public static final SoundEvent ORIGIN_WOLF_TENGU_GROWL = registerSound("origin.wolf_tengu.growl");
    public static final SoundEvent ORIGIN_WOLF_TENGU_PARRY = registerSound("origin.wolf_tengu.parry");
    public static final SoundEvent ORIGIN_RABBIT_HOP = registerSound("origin.rabbit.hop");
    public static final SoundEvent ORIGIN_MOON_RABBIT_ACTIVATE = registerSound("origin.moon_rabbit.activate");
    public static final SoundEvent ORIGIN_MOON_RABBIT_DEACTIVATE = registerSound("origin.moon_rabbit.deactivate");
    public static final SoundEvent ORIGIN_HANIWA_RESIST = registerSound("origin.haniwa.resist");
    public static final SoundEvent ORIGIN_HANIWA_BREAK = registerSound("origin.haniwa.break");
    public static final SoundEvent ORIGIN_SATORI_RECOLLECT = registerSound("origin.satori.recollect");
    public static final SoundEvent ORIGIN_SATORI_CLOSE_EYE = registerSound("origin.satori.close_eye");
    public static final SoundEvent ORIGIN_CELESTIAL_ENLIGHTENMENT = registerSound("origin.celestial.enlightenment");
    public static final SoundEvent ORIGIN_CELESTIAL_TEMPER = registerSound("origin.celestial.temper");
    public static final SoundEvent ORIGIN_OARFISH_DRY = registerSound("origin.oarfish.dry");
    public static final SoundEvent ORIGIN_OARFISH_PREPARE_LIGHTNING = registerSound("origin.oarfish.prepare_lightning");
    public static final SoundEvent ORIGIN_AMANOJAKU_FLIP = registerSound("origin.amanojaku.flip");
    public static final SoundEvent ORIGIN_SHIKIGAMI_LOCATE_FAIL = registerSound("origin.shikigami.locate_fail");
    public static final SoundEvent ORIGIN_SHIKIGAMI_CHANNEL = registerSound("origin.shikigami.channel");
    public static final SoundEvent ORIGIN_SHIKIGAMI_TELEPORT_FAIL = registerSound("origin.shikigami.teleport_fail");
    public static final SoundEvent ORIGIN_SHIKIGAMI_TELEPORT = registerSound("origin.shikigami.teleport");

    // Generic
    public static final SoundEvent ENTITY_GENERIC_GUST = registerSound("entity.generic.gust");
    public static final SoundEvent ENTITY_GENERIC_FLIP = registerSound("entity.generic.flip");
    public static final SoundEvent ENTITY_GENERIC_REVERSE = registerSound("entity.generic.reverse");
    public static final SoundEvent ENTITY_GENERIC_SHIKIGAMI_LINK = registerSound("entity.generic.shikigami_link");

    private static SoundEvent registerSound(String name) {
        Identifier id = TouhouOrigins.id(name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void register() {
        TouhouOrigins.LOGGER.debug("Registering sound events for " + TouhouOrigins.MOD_ID);
    }
}
