package net.cclz.HongThaiMod.worldgen;

import net.cclz.HongThaiMod.HongThaiMod;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

    public static void bootstrap(BootstapContext<BiomeModifier> context) {

    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(HongThaiMod.MOD_ID, name));
    }
}
