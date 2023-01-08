package com.github.command17.yummycake.registry.block;

import com.github.command17.yummycake.registry.Register;
import net.minecraft.block.*;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

public class SliceCakeBlock extends CakeBlock {
    private final Item slice;

    public SliceCakeBlock(Settings settings, Item slice) {
        super(settings);

        this.slice = slice;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.getItem() == Register.CAKE_KNIFE) {
            int i = (Integer) state.get(BITES);

            world.emitGameEvent(player, GameEvent.EAT, pos);

            if (i < 6) {
                world.setBlockState(pos, (BlockState) state.with(BITES, i + 1), 3);

                ItemStack stack = new ItemStack(this.slice, 1);

                ItemEntity itemEntity = new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), stack, 0d, 0.3d, 0d);

                world.spawnEntity(itemEntity);

                player.playSound(SoundEvents.ITEM_DYE_USE, 1f, 1f);
            } else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return ActionResult.SUCCESS;
        }

        if (world.isClient) {
            if (tryEat(world, pos, state, player).isAccepted()) {
                return ActionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return ActionResult.CONSUME;
            }
        } else {
            if (tryEat(world, pos, state, player).isAccepted()) {
                onEat(world, pos, state, player);
            }
        }

        return tryEat(world, pos, state, player);
    }

    public void onEat(World world, BlockPos pos, BlockState state, PlayerEntity player) {}

    protected static ActionResult tryEat(WorldAccess world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!player.canConsume(false)) {
            return ActionResult.PASS;
        } else {
            player.incrementStat(Stats.EAT_CAKE_SLICE);
            player.getHungerManager().add(1, 0.1F);

            int i = (Integer) state.get(BITES);

            world.emitGameEvent(player, GameEvent.EAT, pos);

            if (i < 6) {
                world.setBlockState(pos, (BlockState) state.with(BITES, i + 1), 3);
            } else {
                world.removeBlock(pos, false);
                world.emitGameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return ActionResult.SUCCESS;
        }
    }
}
