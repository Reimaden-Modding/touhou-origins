package net.reimaden.touhouorigins;

import io.github.apace100.apoli.ApoliClient;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.reimaden.touhouorigins.particle.ModParticles;
import net.reimaden.touhouorigins.particle.OrbParticle;
import org.lwjgl.glfw.GLFW;

import java.util.List;

public class TouhouOriginsClient implements ClientModInitializer {

    private static final String CATEGORY_TOUHOU_ORIGINS = "category." + TouhouOrigins.MOD_ID;
    private static final List<String> KEYS = List.of("primary", "secondary");

    @Override
    public void onInitializeClient() {
        for (String key : KEYS) {
            KeyBinding keyBinding = new KeyBinding(
                    "key." + TouhouOrigins.MOD_ID + "." + key + "_extra", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_UNKNOWN, CATEGORY_TOUHOU_ORIGINS
            );
            ApoliClient.registerPowerKeybinding(keyBinding.getTranslationKey(), keyBinding);
            ApoliClient.registerPowerKeybinding(key, keyBinding);
            KeyBindingHelper.registerKeyBinding(keyBinding);
        }

        ParticleFactoryRegistry.getInstance().register(ModParticles.ORB, OrbParticle.Factory::new);
    }
}
