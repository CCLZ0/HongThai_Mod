package net.cclz.HongThaiMod.datagen;

import net.cclz.HongThaiMod.HongThaiMod;
import net.cclz.HongThaiMod.block.ModBlocks;
import net.cclz.HongThaiMod.item.ModItems;
import net.minecraft.core.Registry;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MinecartItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        //SHAPED RECIPES
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.KELP_PLASTIC_BLOCK.get())
                .pattern("PPP")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', ModItems.KELP_PLASTIC.get())
                .unlockedBy(getHasName(ModItems.KELP_PLASTIC.get()), has(ModItems.KELP_PLASTIC.get()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.KELP_PLASTIC.get())
                .pattern("   ")
                .pattern("KK ")
                .pattern("KK ")
                .define('K', Items.KELP)
                .unlockedBy(getHasName(Items.KELP), has(Items.KELP))
                .save(pWriter, HongThaiMod.MOD_ID + ":kelp_plastic_from_kelp");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.BOTTLE.get())
                .pattern("P P")
                .pattern("P P")
                .pattern("PPP")
                .define('P', ModItems.KELP_PLASTIC.get())
                .unlockedBy(getHasName(ModItems.KELP_PLASTIC.get()), has(ModItems.KELP_PLASTIC.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":bottle_from_plastic");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.STICK)
                .pattern("W")
                .pattern("W")
                .define('W', ItemTags.PLANKS)
                .unlockedBy("has_planks", has(ItemTags.PLANKS))
                .save(pWriter, HongThaiMod.MOD_ID + ":stick_from_eucalyptus_planks");

        //SHAPLESS RECIPES
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.KELP_PLASTIC.get(), 9)
                .requires(ModBlocks.KELP_PLASTIC_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.KELP_PLASTIC_BLOCK.get()), has(ModBlocks.KELP_PLASTIC_BLOCK.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":kelp_plastic_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.EUCALYPTUS_PLANKS.get(), 4)
                .requires(ModBlocks.EUCALYPTUS_LOG.get())
                .unlockedBy(getHasName(ModBlocks.EUCALYPTUS_LOG.get()), has(ModBlocks.EUCALYPTUS_LOG.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":eucalyptus_planks_from_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.EUCALYPTUS_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()), has(ModBlocks.STRIPPED_EUCALYPTUS_LOG.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":eucalyptus_planks_from_stripped_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.EUCALYPTUS_PLANKS.get(), 4)
                .requires(ModBlocks.EUCALYPTUS_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.EUCALYPTUS_WOOD.get()), has(ModBlocks.EUCALYPTUS_WOOD.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":eucalyptus_planks_from_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.EUCALYPTUS_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get()), has(ModBlocks.STRIPPED_EUCALYPTUS_WOOD.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":eucalyptus_planks_from_stripped_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CAMPHOR_PLANKS.get(), 4)
                .requires(ModBlocks.CAMPHOR_LOG.get())
                .unlockedBy(getHasName(ModBlocks.CAMPHOR_LOG.get()), has(ModBlocks.CAMPHOR_LOG.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":camphor_planks_from_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CAMPHOR_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_CAMPHOR_LOG.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_CAMPHOR_LOG.get()), has(ModBlocks.STRIPPED_CAMPHOR_LOG.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":camphor_planks_from_stripped_log");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CAMPHOR_PLANKS.get(), 4)
                .requires(ModBlocks.CAMPHOR_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.CAMPHOR_WOOD.get()), has(ModBlocks.CAMPHOR_WOOD.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":camphor_planks_from_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.CAMPHOR_PLANKS.get(), 4)
                .requires(ModBlocks.STRIPPED_CAMPHOR_WOOD.get())
                .unlockedBy(getHasName(ModBlocks.STRIPPED_CAMPHOR_WOOD.get()), has(ModBlocks.STRIPPED_CAMPHOR_WOOD.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":camphor_planks_from_stripped_wood");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.MINT_SEEDS.get())
                .requires(ModItems.MINT.get())
                .unlockedBy(getHasName(ModItems.MINT.get()), has(ModItems.MINT.get()))
                .save(pWriter, HongThaiMod.MOD_ID + ":mint_seed_from_mint");
    }
    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends net.minecraft.world.item.crafting.AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  HongThaiMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
