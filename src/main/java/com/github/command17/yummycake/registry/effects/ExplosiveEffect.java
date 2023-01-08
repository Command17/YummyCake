package com.github.command17.yummycake.registry.effects;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.world.explosion.Explosion;

public class ExplosiveEffect extends StatusEffect {
    public ExplosiveEffect() {
        super(StatusEffectCategory.HARMFUL, 0xd40404);
    }

    @Override
    public StatusEffectCategory getCategory() {
        return StatusEffectCategory.HARMFUL;
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if (!entity.getWorld().isClient()) {
            amplifier++;

            Explosion explosion = entity.getWorld().createExplosion(entity, entity.getX(), entity.getY(), entity.getZ(), 2.5f * amplifier, Explosion.DestructionType.BREAK);

            entity.damage(DamageSource.explosion(explosion), 20 * amplifier);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }

    @Override
    public int getColor() {
        return super.getColor();
    }
}
