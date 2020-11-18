package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.recipe.IRecipeInput;
import ic2.core.item.recipe.AdvRecipeBase;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Locale;

@ModOnly("ic2")
@ZenClass("mods.ic2.AdvRecipes")
@ZenRegister
public class AdvRecipeSupport {
    @ZenMethod
    public static void addShaped(IItemStack output, IIngredient[][] input){
        CraftTweakerActions.apply(new AdvRecipeShapedAction(CraftTweakerMC.getItemStack(output), input, false));
    }

    @ZenMethod
    public static void addShapeless(IItemStack output, IIngredient[] input){
        CraftTweakerActions.apply(new AdvRecipeShapelessAction(CraftTweakerMC.getItemStack(output), IC2RecipeInputs.of(input), false));
    }

    @ZenMethod
    public static void addHiddenShaped(IItemStack output, IIngredient[][] input){
        CraftTweakerActions.apply(new AdvRecipeShapedAction(CraftTweakerMC.getItemStack(output), input, true));
    }

    @ZenMethod
    public static void addHiddenShapeless(IItemStack output, IIngredient[] input){
        CraftTweakerActions.apply(new AdvRecipeShapelessAction(CraftTweakerMC.getItemStack(output), IC2RecipeInputs.of(input), true));
    }

    private static final class AdvRecipeShapelessAction implements IAction {
        ItemStack output;
        IRecipeInput[] inputs;
        boolean hidden;

        AdvRecipeShapelessAction(ItemStack output, IRecipeInput[] inputs, boolean hidden){
            this.output = output;
            this.inputs = inputs;
            this.hidden = hidden;
        }

        @Override
        public void apply() {
            ClassicRecipes.advCrafting.addShapelessRecipe(output, inputs, hidden);
        }

        @Override
        public String describe() {
            if (!Configuration.debug){
                return null;
            }
            return String.format(Locale.ENGLISH, "Add Stacked Shapeless Crafting Recipe[%s -> %s] to %s", Arrays.deepToString(this.inputs), this.output, ClassicRecipes.advCrafting);
        }
    }

    private static final class AdvRecipeShapedAction implements IAction {
        ItemStack output;
        IIngredient[][] input;
        boolean hidden;

        AdvRecipeShapedAction(ItemStack output, IIngredient[][] input, boolean hidden){
            this.output = output;
            this.input = input;
            this.hidden = hidden;
        }

        @Override
        public void apply() {
            try {
                AdvRecipeBase.registerRecipe(new AdvRecipeCT(output, input, hidden));
            } catch (Exception e){
                CraftTweakerActions.printError(e.getLocalizedMessage());
            }
        }

        @Override
        public String describe() {
            if (!Configuration.debug){
                return null;
            }
            return String.format(Locale.ENGLISH, "Add Stacked Shaped Crafting Recipe[%s -> %s] to %s", Arrays.deepToString(this.input), this.output, ClassicRecipes.advCrafting);
        }
    }

}
