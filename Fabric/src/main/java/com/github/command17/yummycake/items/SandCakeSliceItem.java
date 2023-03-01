package com.github.command17.yummycake.items;

import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class SandCakeSliceItem extends Item {
    public SandCakeSliceItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (!world.isClient) {
            ItemEntity itemEntity = user.dropStack(new ItemStack(Items.SAND));

            itemEntity.setThrower(user.getUuid());

            world.spawnEntity(itemEntity);
        }

        return super.finishUsing(stack, world, user);
    }
}
