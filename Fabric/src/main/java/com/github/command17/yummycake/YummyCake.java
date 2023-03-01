package com.github.command17.yummycake;

import com.github.command17.yummycake.registry.Register;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroupBuilderImpl;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class YummyCake implements ModInitializer {
	public static String MOD_ID = "yummycake";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		Register.registerAll();

		LOGGER.info("Initialized!");
	}

	public static final ItemGroup TAB = new FabricItemGroupBuilderImpl(new Identifier(MOD_ID, "tab"))
			.icon(() -> new ItemStack(Register.CREEPER_CAKE_ITEM))
			.displayName(Text.translatable("itemGroup." + MOD_ID + ".tab"))
			.build();
}
