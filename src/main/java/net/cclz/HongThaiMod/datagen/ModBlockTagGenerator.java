package net.cclz.HongThaiMod.datagen;

import net.cclz.HongThaiMod.HongThaiMod;
import net.cclz.HongThaiMod.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {

    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HongThaiMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.KELP_PLASTIC_BLOCK.get());

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.KELP_PLASTIC_BLOCK.get());

        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.EUCALYPTUS_LOG.get(),
                        ModBlocks.EUCALYPTUS_WOOD.get(),
                        ModBlocks.STRIPPED_EUCALYPTUS_LOG.get(),
                        ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get(),
                        ModBlocks.CAMPHOR_LOG.get(),
                        ModBlocks.CAMPHOR_WOOD.get(),
                        ModBlocks.STRIPPED_CAMPHOR_LOG.get(),
                        ModBlocks.STRIPPED_CAMPHOR_WOOD.get());

        this.tag(BlockTags.LOGS)
                .add(ModBlocks.EUCALYPTUS_LOG.get(),
                        ModBlocks.STRIPPED_EUCALYPTUS_LOG.get(),
                        ModBlocks.EUCALYPTUS_WOOD.get(),
                        ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get(),
                        ModBlocks.CAMPHOR_LOG.get(),
                        ModBlocks.STRIPPED_CAMPHOR_LOG.get(),
                        ModBlocks.CAMPHOR_WOOD.get(),
                        ModBlocks.STRIPPED_CAMPHOR_WOOD.get());

        this.tag(BlockTags.PLANKS)
                .add(ModBlocks.EUCALYPTUS_PLANKS.get(),
                        ModBlocks.CAMPHOR_PLANKS.get());
    }

}
