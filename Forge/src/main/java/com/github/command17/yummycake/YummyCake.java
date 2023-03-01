package com.github.command17.yummycake;

import com.github.command17.yummycake.items.creativemodetabs.ModCreativeModeTab;
import com.github.command17.yummycake.registry.Register;
import com.mojang.logging.LogUtils;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

@Mod(YummyCake.MOD_ID)
public class YummyCake
{
    public static final String MOD_ID = "yummycake";
    public static final Logger LOGGER = LogUtils.getLogger();

    public YummyCake() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        Register.registerAll(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        LOGGER.info("Initialized!");
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        for (RegistryObject<Item> item: Register.itemTabsMap) {
            if (event.getTab() == ModCreativeModeTab.TAB) {
                event.accept(item);
            }
        }
    }
}
