package com.github.command17.yummycake.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CookieCakeBlock extends SliceCakeBlock {
    public CookieCakeBlock(Settings settings, Item slice) {
        super(settings, slice);
    }

    @Override
    public void onEat(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SATURATION, 200, 1));
    }
}
