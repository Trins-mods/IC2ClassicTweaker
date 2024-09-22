package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Locale;

@ZenClass("mods.ic2.Recycler")
@ZenRegister
public class RecyclerSupport {

    @ZenMethod
    public static void addBlacklist(IIngredient ingredient) {
        CraftTweakerActions.apply(new RecyclingBlacklistAction(IC2RecipeInputs.of(ingredient)));
    }

    @ZenMethod
    public static void removeRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(ClassicRecipes.recycler, IC2RecipeInputs.of(input)));
    }

    private static final class RecyclingBlacklistAction implements IAction {

        private final IRecipeInput in;

        RecyclingBlacklistAction(IRecipeInput in) {
            this.in = in;
        }

        @Override
        public void apply() {
            Recipes.recyclerBlacklist.add(this.in);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Blacklist %s from recycling", this.in);
        }
    }
}
