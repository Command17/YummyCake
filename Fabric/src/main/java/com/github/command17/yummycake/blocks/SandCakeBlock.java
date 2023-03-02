package com.github.command17.yummycake.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SandCakeBlock extends SliceCakeBlock {
    public SandCakeBlock(Settings settings, Item slice) {
        super(settings, slice);
    }

    @Override
    public void onEat(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        player.dropItem(new ItemStack(Items.SAND), true);
    }
}
