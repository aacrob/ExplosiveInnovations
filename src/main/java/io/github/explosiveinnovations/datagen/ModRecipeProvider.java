package io.github.explosiveinnovations.datagen;

import io.github.explosiveinnovations.ExplosiveInnovations;
import io.github.explosiveinnovations.block.ModBlocks;
import io.github.explosiveinnovations.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> LOW_RETURN_METEORITE_SMELTABLES = List.of(
            ModBlocks.METEORITE_BEARING_ORE.get());
    private static final List<ItemLike> HIGH_RETURN_METEORITE_SMELTABLES = List.of(
            ModItems.RAW_METEORITE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, LOW_RETURN_METEORITE_SMELTABLES, RecipeCategory.MISC, ModItems.METEORITE_NUGGET.get(), 0.25f, 100, "meteorite");
        oreSmelting(pWriter, LOW_RETURN_METEORITE_SMELTABLES, RecipeCategory.MISC, ModItems.METEORITE_NUGGET.get(), 0.25f, 200, "meteorite");

        oreBlasting(pWriter, HIGH_RETURN_METEORITE_SMELTABLES, RecipeCategory.MISC, ModItems.METEORITE_INGOT.get(), 0.25f, 100, "meteorite");
        oreSmelting(pWriter, HIGH_RETURN_METEORITE_SMELTABLES, RecipeCategory.MISC, ModItems.METEORITE_INGOT.get(), 0.25f, 200, "meteorite");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.METEORITE_CASING.get())
                .pattern("PPP")
                .pattern("P P")
                .pattern("PPP")
                .define('P', ModItems.METEORITE_PLATE.get())
                .unlockedBy(getHasName(ModItems.METEORITE_PLATE.get()), has(ModItems.METEORITE_PLATE.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METEORITE_PLATE.get(), 2)
                .pattern("I")
                .pattern("I")
                .define('I', ModItems.METEORITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.METEORITE_INGOT.get()), has(ModItems.METEORITE_INGOT.get()))
                .save(pWriter);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.METEORITE_INGOT.get())
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.METEORITE_NUGGET.get())
                .unlockedBy(getHasName(ModItems.METEORITE_NUGGET.get()), has(ModItems.METEORITE_NUGGET.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.METEORITE_NUGGET.get(), 9)
                .requires(ModItems.METEORITE_INGOT.get())
                .unlockedBy(getHasName(ModItems.METEORITE_INGOT.get()), has(ModItems.METEORITE_INGOT.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                    pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, ExplosiveInnovations.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
