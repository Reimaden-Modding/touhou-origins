package net.reimaden.touhouorigins;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.reimaden.touhouorigins.registry.ModSoundEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TouhouOrigins implements ModInitializer {

	public static final String MOD_ID = "touhouorigins";
	public static final String MOD_NAME = "Touhou Origins";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	@Override
	public void onInitialize() {
		LOGGER.info(MOD_NAME + " is initializing. Please watch warmly until it is ready.");

		ModSoundEvents.register();
	}

	public static Identifier id(String path) {
		return new Identifier(MOD_ID, path);
	}
}
