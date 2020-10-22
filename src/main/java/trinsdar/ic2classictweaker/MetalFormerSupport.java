package trinsdar.ic2classictweaker;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import trinsdar.ic2c_extras.recipes.Ic2cExtrasRecipes;

@ModOnly("ic2c_extras")
@ZenExpansion("mods.ic2.MetalFormer")
@ZenRegister
public class MetalFormerSupport {
    @ZenMethod
    public static void removeCuttingRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(Ic2cExtrasRecipes.cutting, IC2RecipeInputs.of(input)));
    }

    @ZenMethod
    public static void removeRollingRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(Ic2cExtrasRecipes.rolling, IC2RecipeInputs.of(input)));
    }

    @ZenMethod
    public static void removeExtrudingRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(Ic2cExtrasRecipes.extruding, IC2RecipeInputs.of(input)));
    }
}
