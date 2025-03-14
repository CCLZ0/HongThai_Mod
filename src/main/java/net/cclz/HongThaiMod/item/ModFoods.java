package net.cclz.HongThaiMod.item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties HONGTHAI = new FoodProperties.Builder()
            .nutrition(0)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 400, 1), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 1), 1.0f)
            .alwaysEat().build();
}
