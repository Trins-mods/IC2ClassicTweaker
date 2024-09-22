package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Locale;

@ModOnly("ic2")
@ZenClass("mods.ic2.Sawmill")
@ZenRegister
public class SawmillSupport {
    @ZenMethod
    public static void addRecipe(IItemStack output, IIngredient input) {
        CraftTweakerActions.apply(new BasicRecipeAddManager(ClassicRecipes.sawMill, IC2RecipeInputs.of(input),null, CraftTweakerMC.getItemStack(output)));
    }

    @ZenMethod
    public static void addLateRecipe(IItemStack output, IIngredient input) {
        CraftTweakerActions.apply(new BasicRecipeAddManager(ClassicRecipes.sawMill, IC2RecipeInputs.of(input),null, CraftTweakerMC.getItemStack(output)).setLate(true));
    }

    @ZenMethod
    public static void removeRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(ClassicRecipes.sawMill, IC2RecipeInputs.of(input)));
    }
}
