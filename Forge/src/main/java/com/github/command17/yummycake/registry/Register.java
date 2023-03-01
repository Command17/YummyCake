package com.github.command17.yummycake.registry;

import com.github.command17.yummycake.YummyCake;
import com.github.command17.yummycake.blocks.*;
import com.github.command17.yummycake.effects.ExplosiveEffect;
import com.github.command17.yummycake.items.SandCakeSliceItem;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Register {
    public static List<RegistryObject<Item>> itemTabsMap = new ArrayList<>();

    public static final DeferredRegister<Item> ITEMS_REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, YummyCake.MOD_ID);
    public static final DeferredRegister<Block> BLOCK_REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, YummyCake.MOD_ID);
    public static final DeferredRegister<MobEffect> EFFECTS_REGISTER = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, YummyCake.MOD_ID);

    // Effects

    public static final RegistryObject<MobEffect> EXPLOSIVE_EFFECT = EFFECTS_REGISTER.register("explosive", ExplosiveEffect::new);

    // Items

    public static final RegistryObject<Item> CAKE_KNIFE = createItem("cake_knife", new Item.Properties().stacksTo(1));

    public static final RegistryObject<Item> CHOCO_CAKE_SLICE = createItem("choco_cake_slice", new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 0), 1f)
            .build()));

    public static final RegistryObject<Item> CREEPER_CAKE_SLICE = createItem("creeper_cake_slice", new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(EXPLOSIVE_EFFECT.get(), 350, 0), 0.5f)
            .build()));

    public static final RegistryObject<Item> APPLE_CAKE_SLICE = createItem("apple_cake_slice", new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 20, 0), 1f)
            .build()));

    public static final RegistryObject<Item> CLOUD_CAKE_SLICE = createItem("cloud_cake_slice", new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 120, 0), 1f)
            .build()));

    public static final RegistryObject<Item> COOKIE_CAKE_SLICE = createItem("cookie_cake_slice", new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.SATURATION, 200, 1), 1f)
            .build()));

    public static final RegistryObject<Item> SAND_CAKE_SLICE = ITEMS_REGISTER.register("sand_cake_slice", () -> new SandCakeSliceItem(new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .build())));

    public static final RegistryObject<Item> BROWNIE_CAKE_SLICE = createItem("brownie_cake_slice", new Item.Properties().food(new FoodProperties.Builder()
            .nutrition(1)
            .saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 120, 1), 1)
            .build()));

    // Blocks

    public static final RegistryObject<Block> CHOCO_CAKE = createBlock("choco_cake", () -> new ChocoCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL), CHOCO_CAKE_SLICE));
    public static final RegistryObject<Block> CREEPER_CAKE = createBlock("creeper_cake", () -> new CreeperCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL), CREEPER_CAKE_SLICE));
    public static final RegistryObject<Block> APPLE_CAKE = createBlock("apple_cake", () -> new AppleCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL), APPLE_CAKE_SLICE));
    public static final RegistryObject<Block> CLOUD_CAKE = createBlock("cloud_cake", () -> new CloudCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL), CLOUD_CAKE_SLICE));
    public static final RegistryObject<Block> COOKIE_CAKE = createBlock("cookie_cake", () -> new CookieCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL), COOKIE_CAKE_SLICE));
    public static final RegistryObject<Block> SAND_CAKE = createBlock("sand_cake", () -> new SandCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL), SAND_CAKE_SLICE));
    public static final RegistryObject<Block> BROWNIE_CAKE = createBlock("brownie_cake", () -> new BrownieCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE).sound(SoundType.WOOL), BROWNIE_CAKE_SLICE));

    // Block Items

    public static final RegistryObject<Item> CHOCO_CAKE_ITEM = createBlockItem("choco_cake", CHOCO_CAKE, new Item.Properties());
    public static final RegistryObject<Item> CREEPER_CAKE_ITEM = createBlockItem("creeper_cake", CREEPER_CAKE, new Item.Properties());
    public static final RegistryObject<Item> APPLE_CAKE_ITEM = createBlockItem("apple_cake", APPLE_CAKE, new Item.Properties());
    public static final RegistryObject<Item> CLOUD_CAKE_ITEM = createBlockItem("cloud_cake", CLOUD_CAKE, new Item.Properties());
    public static final RegistryObject<Item> COOKIE_CAKE_ITEM = createBlockItem("cookie_cake", COOKIE_CAKE, new Item.Properties());
    public static final RegistryObject<Item> SAND_CAKE_ITEM = createBlockItem("sand_cake", SAND_CAKE, new Item.Properties());
    public static final RegistryObject<Item> BROWNIE_CAKE_ITEM = createBlockItem("brownie_cake", BROWNIE_CAKE, new Item.Properties());

    // Functions

    private static RegistryObject<Item> createItem(String name, Item.Properties settings) {
        RegistryObject<Item> item = ITEMS_REGISTER.register(name, () -> new Item(settings));

        itemTabsMap.add(item);

        return item;
    }

    private static RegistryObject<Block> createBlock(String name, Supplier<? extends Block> block) {
        return BLOCK_REGISTER.register(name, block);
    }

    private static RegistryObject<Item> createBlockItem(String name, RegistryObject<Block> block, Item.Properties settings) {
        RegistryObject<Item> item = ITEMS_REGISTER.register(name, () -> new BlockItem(block.get(), settings));

        itemTabsMap.add(item);

        return item;
    }

    public static void registerAll(IEventBus modEventBus) {
        // Special Items

        itemTabsMap.add(SAND_CAKE_SLICE);

        // Register

        ITEMS_REGISTER.register(modEventBus);
        BLOCK_REGISTER.register(modEventBus);
        EFFECTS_REGISTER.register(modEventBus);

        // Log

        YummyCake.LOGGER.info("Registered Items, Blocks and Effects.");
    }
}
