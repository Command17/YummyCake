package com.github.command17.yummycake.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

public class SandCakeBlock extends SliceCakeBlock{
    public SandCakeBlock(Properties properties, RegistryObject<Item> slice) {
        super(properties, slice);
    }

    @Override
    public void onEat(Level level, BlockPos pos, BlockState state, Player player) {
        player.drop(new ItemStack(Items.SAND), true);
    }
}
