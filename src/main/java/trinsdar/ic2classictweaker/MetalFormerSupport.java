package trinsdar.ic2classictweaker;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;
import trinsdar.ic2c_extras.recipes.Ic2cExtrasRecipes;

@ModOnly("ic2c_extras")
@ZenExpansion("mods.ic2.MetalFormer")
@ZenRegister
public class MetalFormerSupport {
    @ZenMethodStatic
    public static void addLateCuttingRecipe(IItemStack output, IIngredient input) {
        CraftTweakerActions.apply(new BasicRecipeAddManager(Ic2cExtrasRecipes.cutting, IC2RecipeInputs.of(input),null, CraftTweakerMC.getItemStack(output)));
    }

    @ZenMethodStatic
    public static void addLateRollingRecipe(IItemStack output, IIngredient input) {
        CraftTweakerActions.apply(new BasicRecipeAddManager(Ic2cExtrasRecipes.rolling, IC2RecipeInputs.of(input),null, CraftTweakerMC.getItemStack(output)));
    }

    @ZenMethodStatic
    public static void addLateExtrudingRecipe(IItemStack output, IIngredient input) {
        CraftTweakerActions.apply(new BasicRecipeAddManager(Ic2cExtrasRecipes.extruding, IC2RecipeInputs.of(input),null, CraftTweakerMC.getItemStack(output)));
    }

    @ZenMethodStatic
    public static void removeCuttingRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(Ic2cExtrasRecipes.cutting, IC2RecipeInputs.of(input)));
    }

    @ZenMethodStatic
    public static void removeRollingRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(Ic2cExtrasRecipes.rolling, IC2RecipeInputs.of(input)));
    }

    @ZenMethodStatic
    public static void removeExtrudingRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(Ic2cExtrasRecipes.extruding, IC2RecipeInputs.of(input)));
    }
}
