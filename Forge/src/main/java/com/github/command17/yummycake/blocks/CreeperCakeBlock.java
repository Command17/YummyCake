package com.github.command17.yummycake.blocks;

import com.github.command17.yummycake.registry.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.RegistryObject;

import java.util.Random;

public class CreeperCakeBlock extends SliceCakeBlock {
    Random rand = new Random();

    public CreeperCakeBlock(Properties properties, RegistryObject<Item> slice) {
        super(properties, slice);
    }

    @Override
    public void onEat(Level level, BlockPos pos, BlockState state, Player player) {
        int should = rand.nextInt(0, 2);

        if (should > 0) {
            player.addEffect(new MobEffectInstance(Register.EXPLOSIVE_EFFECT.get(), 350, 0));
        }
    }
}
