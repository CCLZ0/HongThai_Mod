package net.cclz.HongThaiMod.datagen;

import net.cclz.HongThaiMod.HongThaiMod;
import net.cclz.HongThaiMod.block.ModBlocks;
import net.cclz.HongThaiMod.block.custom.MintCropBlock;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Function;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper){
        super(output, HongThaiMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels(){
        blockWithItem(ModBlocks.KELP_PLASTIC_BLOCK);

        makeMintCrop((CropBlock) ModBlocks.MINT_CROP.get(), "mint_stage","mint_stage");

        logBlock(((RotatedPillarBlock) ModBlocks.EUCALYPTUS_LOG.get()));
        axisBlock(((RotatedPillarBlock) ModBlocks.EUCALYPTUS_WOOD.get()), blockTexture(ModBlocks.EUCALYPTUS_LOG.get()),blockTexture(ModBlocks.EUCALYPTUS_LOG.get()));

        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()), blockTexture(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()),
                new ResourceLocation(HongThaiMod.MOD_ID, "block/stripped_eucalyptus_log_top"));
        axisBlock(((RotatedPillarBlock) ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get()), blockTexture(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()),
                blockTexture(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()));

        blockItem(ModBlocks.EUCALYPTUS_LOG);
        blockItem(ModBlocks.EUCALYPTUS_WOOD);
        blockItem(ModBlocks.STRIPPED_EUCALYPTUS_LOG);
        blockItem(ModBlocks.STRIPPED_EUCALYPTUS_WOOD);

        blockWithItem(ModBlocks.EUCALYPTUS_PLANKS);

        leavesBlock(ModBlocks.EUCALYPTUS_LEAVES);

    }

    private void leavesBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), new ResourceLocation("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile(HongThaiMod.MOD_ID +
                ":block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    public void makeMintCrop(CropBlock block, String modelName, String textureName) {
        Function<BlockState, ConfiguredModel[]> function = state -> mintStates(state, block, modelName, textureName);

        getVariantBuilder(block).forAllStates(function);
    }

    private ConfiguredModel[] mintStates(BlockState state, CropBlock block, String modelName, String textureName) {
        ConfiguredModel[] models = new ConfiguredModel[1];
        models[0] = new ConfiguredModel(models().crop(modelName + state.getValue(((MintCropBlock) block).getAgeProperty()),
                new ResourceLocation(HongThaiMod.MOD_ID, "block/" + textureName + state.getValue(((MintCropBlock) block).getAgeProperty()))).renderType("cutout"));

        return models;
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
