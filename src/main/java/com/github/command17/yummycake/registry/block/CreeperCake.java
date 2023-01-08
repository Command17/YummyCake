package com.github.command17.yummycake.registry.block;

import com.github.command17.yummycake.registry.Register;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class CreeperCake extends SliceCakeBlock{
    Random rand = new Random();

    public CreeperCake(Settings settings, Item slice) {
        super(settings, slice);
    }

    @Override
    public void onEat(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        int should = rand.nextInt(0, 2);

        if (should > 0) {
            player.addStatusEffect(new StatusEffectInstance(Register.EXPLOSIVE_EFFECT, 350, 0));
        }
    }
}
