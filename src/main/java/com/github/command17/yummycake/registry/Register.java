package com.github.command17.yummycake.registry;

import com.github.command17.yummycake.YummyCake;
import com.github.command17.yummycake.registry.block.*;
import com.github.command17.yummycake.registry.effects.ExplosiveEffect;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
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

    public static final Item CAKE_KNIFE = createItem("cake_knife", new FabricItemSettings().maxCount(1), ItemGroups.TOOLS);
    public static final Item CHOCO_CAKE_SLICE = createItem("choco_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, 0), 1f)
            .alwaysEdible()
            .build()), ItemGroups.FOOD_AND_DRINK);

    public static final Item CREEPER_CAKE_SLICE = createItem("creeper_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(EXPLOSIVE_EFFECT, 350, 0), 0.5f)
            .alwaysEdible()
            .build()), ItemGroups.FOOD_AND_DRINK);

    public static final Item APPLE_CAKE_SLICE = createItem("apple_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 20, 0), 1f)
            .alwaysEdible()
            .build()), ItemGroups.FOOD_AND_DRINK);

    public static final Item CLOUD_CAKE_SLICE = createItem("cloud_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 120, 0), 1f)
            .alwaysEdible()
            .build()), ItemGroups.FOOD_AND_DRINK);

    public static final Item COOKIE_CAKE_SLICE = createItem("cookie_cake_slice", new FabricItemSettings().food(new FoodComponent.Builder()
            .hunger(1)
            .saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200, 1), 1f)
            .alwaysEdible()
            .build()), ItemGroups.FOOD_AND_DRINK);

    // Blocks

    public static final Block CHOCO_CAKE = createBlock("choco_cake", new ChocoCake(FabricBlockSettings.of(Material.CAKE).sounds(BlockSoundGroup.WOOL), CHOCO_CAKE_SLICE));
    public static final Block CREEPER_CAKE = createBlock("creeper_cake", new CreeperCake(FabricBlockSettings.of(Material.CAKE).sounds(BlockSoundGroup.WOOL), CREEPER_CAKE_SLICE));
    public static final Block APPLE_CAKE = createBlock("apple_cake", new AppleCake(FabricBlockSettings.of(Material.CAKE).sounds(BlockSoundGroup.WOOL), APPLE_CAKE_SLICE));
    public static final Block CLOUD_CAKE = createBlock("cloud_cake", new CloudCake(FabricBlockSettings.of(Material.CAKE).sounds(BlockSoundGroup.WOOL), CLOUD_CAKE_SLICE));
    public static final Block COOKIE_CAKE = createBlock("cookie_cake", new CookieCake(FabricBlockSettings.of(Material.CAKE).sounds(BlockSoundGroup.WOOL), COOKIE_CAKE_SLICE));

    // BlockItems

    public static final Item CHOCO_CAKE_ITEM = createBlockItem("choco_cake", CHOCO_CAKE, new FabricItemSettings(), ItemGroups.FOOD_AND_DRINK);
    public static final Item CREEPER_CAKE_ITEM = createBlockItem("creeper_cake", CREEPER_CAKE, new FabricItemSettings(), ItemGroups.FOOD_AND_DRINK);
    public static final Item APPLE_CAKE_ITEM = createBlockItem("apple_cake", APPLE_CAKE, new FabricItemSettings(), ItemGroups.FOOD_AND_DRINK);
    public static final Item CLOUD_CAKE_ITEM = createBlockItem("cloud_cake", CLOUD_CAKE, new FabricItemSettings(), ItemGroups.FOOD_AND_DRINK);
    public static final Item COOKIE_CAKE_ITEM = createBlockItem("cookie_cake", COOKIE_CAKE, new FabricItemSettings(), ItemGroups.FOOD_AND_DRINK);

    // Methods

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
        YummyCake.LOGGER.info("Registered all.");
    }
}
