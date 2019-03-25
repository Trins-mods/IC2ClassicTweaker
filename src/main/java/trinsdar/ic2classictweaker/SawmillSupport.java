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
        CraftTweakerActions.apply(new SawmillRecipeAction(IC2RecipeInputs.of(input),CraftTweakerMC.getItemStack(output)));
    }

    private static final class SawmillRecipeAction implements IAction {

        private final IRecipeInput input;
        private final ItemStack output;

        SawmillRecipeAction(IRecipeInput input, ItemStack output) {
            this.input = input;
            this.output = output;
        }

        @Override
        public void apply() {
            ClassicRecipes.sawMill.addRecipe(this.input, this.output, 0.0F, input.getInputs().get(0).getDisplayName());
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Recipe[%s -> %s] to %s", this.input, this.output, ClassicRecipes.sawMill);
        }
    }

}
