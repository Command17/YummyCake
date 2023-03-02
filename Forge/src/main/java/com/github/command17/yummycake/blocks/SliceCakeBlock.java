package com.github.command17.yummycake.blocks;

import com.github.command17.yummycake.registry.Register;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.registries.RegistryObject;

public class SliceCakeBlock extends CakeBlock {
    private RegistryObject<Item> slice;

    public SliceCakeBlock(Properties properties, RegistryObject<Item> slice) {
        super(properties);

        this.slice = slice;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        ItemStack itemStack = player.getItemInHand(hand);

        Item item = itemStack.getItem();

        if (item.equals(Register.CAKE_KNIFE.get())) {
            ItemStack stack = new ItemStack(this.slice.get());

            ItemEntity itemEntity = new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), stack, 0d, 0.3d, 0d);

            level.addFreshEntity(itemEntity);

            int i = state.getValue(BITES);

            if (i < 6) {
                level.setBlock(pos, state.setValue(BITES, Integer.valueOf(i + 1)), 3);
            } else {
                level.destroyBlock(pos, false);
                level.gameEvent(player, GameEvent.BLOCK_DESTROY, pos);
            }

            return InteractionResult.SUCCESS;
        }

        if (level.isClientSide()) {
            if (eat(level, pos, state, player).consumesAction()) {
                return InteractionResult.SUCCESS;
            }

            if (itemStack.isEmpty()) {
                return InteractionResult.CONSUME;
            }
        } else {
            if (eat(level, pos, state, player).consumesAction()) {
                onEat(level, pos, state, player);

                return InteractionResult.SUCCESS;
            }
        }

        return eat(level, pos, state, player);
    }

    public void onEat(Level level, BlockPos pos, BlockState state, Player player) {}
}
