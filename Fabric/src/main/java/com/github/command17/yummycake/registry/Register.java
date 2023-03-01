package com.github.command17.yummycake.registry;

import com.github.command17.yummycake.YummyCake;
import com.github.command17.yummycake.blocks.*;
import com.github.command17.yummycake.effects.ExplosiveEffect;
import com.github.command17.yummycake.items.SandCakeSliceItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class Register {
    // Effects

    public static final StatusEffect EXPLOSIVE_EFFECT = Registry.register(Registries.STATUS_EFFECT, new Identifier(YummyCake.MOD_ID, "explosive"), new ExplosiveEffect());

    // Items

    public static final Item CAKE_KNIFE = createItem("cake_knife", new FabricItemSettings().maxCount(1), YummyCake.TAB);

    public static final Item CHOCO_CAKE_SLICE = createItem("choco_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, 0), 1f)
            .build()), YummyCake.TAB);

    public static final Item CREEPER_CAKE_SLICE = createItem("creeper_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(EXPLOSIVE_EFFECT, 350, 0), 0.5f)
            .build()), YummyCake.TAB);

    public static final Item APPLE_CAKE_SLICE = createItem("apple_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0), 1f)
            .build()), YummyCake.TAB);

    public static final Item CLOUD_CAKE_SLICE = createItem("cloud_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 120, 0), 1f)
            .build()), YummyCake.TAB);

    public static final Item COOKIE_CAKE_SLICE = createItem("cookie_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200, 1), 1f)
            .build()), YummyCake.TAB);

    public static final Item SAND_CAKE_SLICE = Registry.register(Registries.ITEM, new Identifier(YummyCake.MOD_ID, "sand_cake_slice"), new SandCakeSliceItem(new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .build())));

    public static final Item BROWNIE_CAKE_SLICE = createItem("brownie_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, 1), 1)
            .build()), YummyCake.TAB);

    // Blocks

    public static final Block CHOCO_CAKE = createBlock("choco_cake", new ChocoCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE).sounds(BlockSoundGroup.WOOL), CHOCO_CAKE_SLICE));
    public static final Block CREEPER_CAKE = createBlock("creeper_cake", new CreeperCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE).sounds(BlockSoundGroup.WOOL), CREEPER_CAKE_SLICE));
    public static final Block APPLE_CAKE = createBlock("apple_cake", new AppleCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE).sounds(BlockSoundGroup.WOOL), APPLE_CAKE_SLICE));
    public static final Block CLOUD_CAKE = createBlock("cloud_cake", new CloudCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE).sounds(BlockSoundGroup.WOOL), CLOUD_CAKE_SLICE));
    public static final Block COOKIE_CAKE = createBlock("cookie_cake", new CookieCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE).sounds(BlockSoundGroup.WOOL), COOKIE_CAKE_SLICE));
    public static final Block SAND_CAKE = createBlock("sand_cake", new SandCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE).sounds(BlockSoundGroup.WOOL), SAND_CAKE_SLICE));
    public static final Block BROWNIE_CAKE = createBlock("brownie_cake", new BrownieCakeBlock(FabricBlockSettings.copyOf(Blocks.CAKE).sounds(BlockSoundGroup.WOOL), BROWNIE_CAKE_SLICE));

    // Block Items

    public static final Item CHOCO_CAKE_ITEM = createBlockItem("choco_cake", CHOCO_CAKE, new FabricItemSettings(), YummyCake.TAB);
    public static final Item CREEPER_CAKE_ITEM = createBlockItem("creeper_cake", CREEPER_CAKE, new FabricItemSettings(), YummyCake.TAB);
    public static final Item APPLE_CAKE_ITEM = createBlockItem("apple_cake", APPLE_CAKE, new FabricItemSettings(), YummyCake.TAB);
    public static final Item CLOUD_CAKE_ITEM = createBlockItem("cloud_cake", CLOUD_CAKE, new FabricItemSettings(), YummyCake.TAB);
    public static final Item COOKIE_CAKE_ITEM = createBlockItem("cookie_cake", COOKIE_CAKE, new FabricItemSettings(), YummyCake.TAB);
    public static final Item SAND_CAKE_ITEM = createBlockItem("sand_cake", SAND_CAKE, new FabricItemSettings(), YummyCake.TAB);
    public static final Item BROWNIE_CAKE_ITEM = createBlockItem("brownie_cake", BROWNIE_CAKE, new FabricItemSettings(), YummyCake.TAB);

    // Functions

    private static Item createItem(String name, Item.Settings settings, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(YummyCake.MOD_ID, name), new Item(settings));

        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));

        return item;
    }

    private static Block createBlock(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(YummyCake.MOD_ID, name), block);
    }

    private static Item createBlockItem(String name, Block block, Item.Settings settings, ItemGroup tab) {
        Item item = Registry.register(Registries.ITEM, new Identifier(YummyCake.MOD_ID, name), new BlockItem(block, settings));

        ItemGroupEvents.modifyEntriesEvent(tab).register(entries -> entries.add(item));

        return item;
    }

    public static void registerAll() {
        // Special Items

        ItemGroupEvents.modifyEntriesEvent(YummyCake.TAB).register(entries -> entries.add(SAND_CAKE_SLICE));

        // Log

        YummyCake.LOGGER.info("Registered Blocks, Items and Effects.");
    }
}
