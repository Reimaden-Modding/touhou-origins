package net.maxmani.touhouorigins;

import net.fabricmc.api.ModInitializer;
import net.maxmani.touhouorigins.registry.ModPowers;
import net.maxmani.touhouorigins.registry.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TouhouOrigins implements ModInitializer {

	public static final String MOD_ID = "touhouorigins";
	public static final Logger LOGGER = LoggerFactory.getLogger(TouhouOrigins.class);

	@Override
	public void onInitialize() {
		LOGGER.info("Touhou Origins is initializing. Please watch warmly until it is ready.");

		ModSounds.init();
		ModPowers.init();
	}
}
