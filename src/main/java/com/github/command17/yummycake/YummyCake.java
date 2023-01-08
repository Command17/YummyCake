package com.github.command17.yummycake;

import com.github.command17.yummycake.registry.Register;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YummyCake implements ModInitializer {
	public static String MOD_ID = "yummycake";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Register.registerAll();
	}
}
