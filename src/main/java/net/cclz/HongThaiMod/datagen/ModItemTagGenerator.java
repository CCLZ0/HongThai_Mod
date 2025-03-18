package net.cclz.HongThaiMod.datagen;

import net.cclz.HongThaiMod.HongThaiMod;
import net.cclz.HongThaiMod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, HongThaiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.EUCALYPTUS_LOG.get().asItem())
                .add(ModBlocks.EUCALYPTUS_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get().asItem())
                .add(ModBlocks.CAMPHOR_LOG.get().asItem())
                .add(ModBlocks.CAMPHOR_WOOD.get().asItem())
                .add(ModBlocks.STRIPPED_CAMPHOR_LOG.get().asItem())
                .add(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get().asItem());

        this.tag(ItemTags.PLANKS)
                .add(ModBlocks.EUCALYPTUS_PLANKS.get().asItem())
                .add(ModBlocks.CAMPHOR_PLANKS.get().asItem());
    }
}
