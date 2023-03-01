package com.github.command17.yummycake.items.creativemodetabs;

import com.github.command17.yummycake.YummyCake;
import com.github.command17.yummycake.registry.Register;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
@Mod.EventBusSubscriber(modid = YummyCake.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TAB = event.registerCreativeModeTab(new ResourceLocation(YummyCake.MOD_ID, "tab"),
                builder -> builder.icon(() -> new ItemStack(Register.CREEPER_CAKE_ITEM.get()))
                        .title(Component.translatable("itemGroup.yummycake.tab")));
    }
}