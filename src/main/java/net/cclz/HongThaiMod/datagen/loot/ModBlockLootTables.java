package net.cclz.HongThaiMod.datagen.loot;

import net.cclz.HongThaiMod.block.ModBlocks;
import net.cclz.HongThaiMod.block.custom.MintCropBlock;
import net.cclz.HongThaiMod.item.ModFoods;
import net.cclz.HongThaiMod.item.ModItems;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.BonusLevelTableCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.KELP_PLASTIC_BLOCK.get());
        this.dropSelf(ModBlocks.EUCALYPTUS_LOG.get());
        this.dropSelf(ModBlocks.EUCALYPTUS_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get());
        this.dropSelf(ModBlocks.EUCALYPTUS_PLANKS.get());
        this.dropSelf(ModBlocks.CAMPHOR_LOG.get());
        this.dropSelf(ModBlocks.CAMPHOR_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_CAMPHOR_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_CAMPHOR_WOOD.get());
        this.dropSelf(ModBlocks.CAMPHOR_PLANKS.get());
        this.dropSelf(ModBlocks.EUCALYPTUS_SAPLING.get());
        this.dropSelf(ModBlocks.CAMPHOR_SAPLING.get());

        this.add(ModBlocks.EUCALYPTUS_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.EUCALYPTUS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));
        this.add(ModBlocks.CAMPHOR_LEAVES.get(), block ->
                createCamphorLeavesDrops(block, ModBlocks.CAMPHOR_SAPLING.get(), ModItems.CAMPHOR_FRUIT.get() ,NORMAL_LEAVES_SAPLING_CHANCES));

        LootItemCondition.Builder lootitemcondition$builder = LootItemBlockStatePropertyCondition
                .hasBlockStateProperties(ModBlocks.MINT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(MintCropBlock.AGE,5));
        this.add(ModBlocks.MINT_CROP.get(), createCropDrops(ModBlocks.MINT_CROP.get(), ModItems.MINT.get(),
                ModItems.MINT_SEEDS.get(), lootitemcondition$builder));

    }

    protected LootTable.Builder createCamphorLeavesDrops(Block pCamphorLeavesBlock, Block pSaplingBlock, Item pCamphorFruit, float... pSaplingChances) {
        LootTable.Builder builder = createSilkTouchOrShearsDispatchTable(
                pCamphorLeavesBlock,
                applyExplosionDecay(pCamphorLeavesBlock, LootItem.lootTableItem(pSaplingBlock))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE, pSaplingChances))
        );

        builder.withPool(LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1.0F))
                .when(HAS_NO_SILK_TOUCH)
                .add(LootItem.lootTableItem(pCamphorFruit)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .when(BonusLevelTableCondition.bonusLevelFlatChance(Enchantments.BLOCK_FORTUNE,
                                new float[] {0.02F, 0.022F, 0.025F, 0.03F, 0.05F}))
                )
        );

        return builder;
    }



    @Override
    protected Iterable<Block> getKnownBlocks(){
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
