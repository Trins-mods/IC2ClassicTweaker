package trinsdar.ic2classictweaker;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;

@ZenClass("mods.ic2.Extractor")
@ZenRegister
public class ExtractorSupport {
    @ZenMethod
    public static void addRecipe(IItemStack output, IIngredient input) {
        CraftTweakerActions.apply(new BasicRecipeAddManager(ClassicRecipes.extractor, IC2RecipeInputs.of(input),null, CraftTweakerMC.getItemStack(output)));
    }

    @ZenMethod
    public static void addLateRecipe(IItemStack output, IIngredient input) {
        CraftTweakerActions.apply(new BasicRecipeAddManager(ClassicRecipes.extractor, IC2RecipeInputs.of(input),null, CraftTweakerMC.getItemStack(output)).setLate(true));
    }

    @ZenMethod
    public static void removeRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(ClassicRecipes.extractor, IC2RecipeInputs.of(input)));
    }
}
