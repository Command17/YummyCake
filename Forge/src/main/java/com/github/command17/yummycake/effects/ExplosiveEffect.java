package com.github.command17.yummycake.effects;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class ExplosiveEffect extends MobEffect {
    public ExplosiveEffect() {
        super(MobEffectCategory.HARMFUL, 0xd40404);
    }

    @Override
    public MobEffectCategory getCategory() {
        return MobEffectCategory.HARMFUL;
    }

    @Override
    public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributes, int amplifier) {
        if (!entity.getLevel().isClientSide()) {
            amplifier++;

            Explosion explosion = entity.getLevel().explode(entity, entity.getX(), entity.getY(), entity.getZ(), 2.5f * amplifier, Level.ExplosionInteraction.MOB);

            entity.hurt(DamageSource.explosion(explosion), 20 * amplifier);
        }
    }

    @Override
    public boolean isDurationEffectTick(int p_19455_, int p_19456_) {
        return true;
    }

    @Override
    public int getColor() {
        return super.getColor();
    }
}
