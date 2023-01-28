package net.reimaden.touhouorigins;

import net.fabricmc.api.ModInitializer;
import net.reimaden.touhouorigins.registry.ModConditions;
import net.reimaden.touhouorigins.registry.ModPowers;
import net.reimaden.touhouorigins.registry.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TouhouOrigins implements ModInitializer {

	public static final String MOD_ID = "touhouorigins";
	public static final String MOD_NAME = "Touhou Origins";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

	@Override
	public void onInitialize() {
		LOGGER.info("Touhou Origins is initializing. Please watch warmly until it is ready.");

		ModSounds.register();
		ModPowers.register();
		ModConditions.register();
	}
}
