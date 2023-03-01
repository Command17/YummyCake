package com.github.command17.yummycake.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class SandCakeSliceItem extends Item {
    public SandCakeSliceItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity user) {
        if (!level.isClientSide()) {
            ItemEntity itemEntity = user.spawnAtLocation(new ItemStack(Items.SAND));

            itemEntity.setThrower(user.getUUID());

            level.addFreshEntity(itemEntity);
        }

        return super.finishUsingItem(stack, level, user);
    }
}
