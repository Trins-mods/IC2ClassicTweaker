package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.crafting.ICraftingRecipeList;
import ic2.api.recipe.IRecipeInput;
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
        CraftTweakerActions.apply(new AdvRecipeShapedAction(CraftTweakerMC.getItemStack(output), input));
    }

    @ZenMethod
    public static void addShapeless(IItemStack output, IIngredient[] input){
        CraftTweakerActions.apply(new AdvRecipeShapelessAction(CraftTweakerMC.getItemStack(output), IC2RecipeInputs.of(input)));
    }

    private static final class AdvRecipeShapelessAction implements IAction {
        ItemStack output;
        IRecipeInput[] inputs;

        AdvRecipeShapelessAction(ItemStack output, IRecipeInput[] inputs){
            this.output = output;
            this.inputs = inputs;
        }

        @Override
        public void apply() {
            ClassicRecipes.advCrafting.addShapelessRecipe(output, inputs);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Stacked Shapeless Crafting Recipe[%s -> %s] to %s", Arrays.deepToString(this.inputs), this.output, ClassicRecipes.advCrafting);
        }
    }

    private static final class AdvRecipeShapedAction implements IAction {
        ItemStack output;
        IIngredient[][] input;

        AdvRecipeShapedAction(ItemStack output, IIngredient[][] input){
            this.output = output;
            this.input = input;
        }

        @Override
        public void apply() {
            ICraftingRecipeList recipes = ClassicRecipes.advCrafting;
            int height = input.length;
            int width;
            if (height > 3){
                CraftTweakerActions.printError("Outer Recipe Array can only have a max of 3 inner arrays!");
            }
            if (height == 1){
                width = input[0].length;
                if (width > 3){
                    CraftTweakerActions.printError("Inner Recipe Array can only have a max of 3 inputs!");
                }
                if (width == 1){
                    if (input[0][0] != null){
                        recipes.addRecipe(output, "A", 'A', IC2RecipeInputs.of(input[0][0]));
                    } else {
                        CraftTweakerActions.printError("Recipe must have at least one nonnull input!");
                    }
                } else if (width == 2){
                    IRecipeInput in00 = input[0][0] != null ? IC2RecipeInputs.of(input[0][0]) : null;
                    IRecipeInput in01 = input[0][1] != null ? IC2RecipeInputs.of(input[0][1]) : null;
                    if (in00 == null && in01 == null){
                        CraftTweakerActions.printError("Recipe must have at least one nonnull input!");
                    } else {
                        recipes.addRecipe(output, "AB", 'A', in00, 'B', in01);
                    }
                } else if (width == 3){
                    IRecipeInput in00 = input[0][0] != null ? IC2RecipeInputs.of(input[0][0]) : null;
                    IRecipeInput in01 = input[0][1] != null ? IC2RecipeInputs.of(input[0][1]) : null;
                    IRecipeInput in02 = input[0][2] != null ? IC2RecipeInputs.of(input[0][1]) : null;
                    if (in00 == null && in01 == null && in02 == null){
                        CraftTweakerActions.printError("Recipe must have at least one nonnull input!");
                    } else {
                        recipes.addRecipe(output, "ABC", 'A', in00, 'B', in01, 'C', in02);
                    }
                }
            } else if (height == 2){
                width = input[0].length;
                int width2 = input[1].length;
                if (width != width2){
                    CraftTweakerActions.printError("Inner Recipe Arrays must all be the same lengths!");
                }
                if (width > 3 || width2 > 3){
                    CraftTweakerActions.printError("Inner Recipe Array can only have a max of 3 inputs!");
                }
                if (width == 1){
                    IRecipeInput in00 = input[0][0] != null ? IC2RecipeInputs.of(input[0][0]) : null;
                    IRecipeInput in10 = input[1][0] != null ? IC2RecipeInputs.of(input[1][0]) : null;
                    if (in00 == null && in10 == null){
                        CraftTweakerActions.printError("Recipe must have at least one nonnull input!");
                    } else {
                        recipes.addRecipe(output, "A", "B", 'A', in00, 'B', in10);
                    }
                } else if (width == 2){
                    IRecipeInput in00 = input[0][0] != null ? IC2RecipeInputs.of(input[0][0]) : null;
                    IRecipeInput in10 = input[1][0] != null ? IC2RecipeInputs.of(input[1][0]) : null;
                    IRecipeInput in01 = input[0][1] != null ? IC2RecipeInputs.of(input[0][1]) : null;
                    IRecipeInput in11 = input[1][1] != null ? IC2RecipeInputs.of(input[1][1]) : null;
                    if (in00 == null && in10 == null && in01 == null && in11 == null){
                        CraftTweakerActions.printError("Recipe must have at least one nonnull input!");
                    } else {
                        recipes.addRecipe(output, "AB", "CD", 'A', in00, 'B', in01, 'C', in10, 'D', in11);
                    }
                } else if (width == 3){
                    IRecipeInput in00 = input[0][0] != null ? IC2RecipeInputs.of(input[0][0]) : null;
                    IRecipeInput in10 = input[1][0] != null ? IC2RecipeInputs.of(input[1][0]) : null;
                    IRecipeInput in01 = input[0][1] != null ? IC2RecipeInputs.of(input[0][1]) : null;
                    IRecipeInput in11 = input[1][1] != null ? IC2RecipeInputs.of(input[1][1]) : null;
                    IRecipeInput in02 = input[0][2] != null ? IC2RecipeInputs.of(input[0][2]) : null;
                    IRecipeInput in12 = input[1][2] != null ? IC2RecipeInputs.of(input[1][2]) : null;
                    if (in00 == null && in10 == null && in01 == null && in11 == null && in02 == null && in12 == null){
                        CraftTweakerActions.printError("Recipe must have at least one nonnull input!");
                    } else {
                        recipes.addRecipe(output, "ABC", "DEF", 'A', in00, 'B', in01, 'C', in02, 'D', in10, 'E', in11, 'F', in12);
                    }
                }
            } else if (height == 3){
                width = input[0].length;
                int width2 = input[1].length;
                int width3 = input[2].length;
                if (width > 3 || width2 > 3 || width3 > 3){
                    CraftTweakerActions.printError("Inner Recipe Array can only have a max of 3 inputs!");
                }
                if (width == width2 && width == width3){
                    if (width == 1){
                        IRecipeInput in00 = input[0][0] != null ? IC2RecipeInputs.of(input[0][0]) : null;
                        IRecipeInput in10 = input[1][0] != null ? IC2RecipeInputs.of(input[1][0]) : null;
                        IRecipeInput in20 = input[2][0] != null ? IC2RecipeInputs.of(input[2][0]) : null;
                        if (in00 == null && in10 == null && in20 == null){
                            CraftTweakerActions.printError("Recipe must have at least one nonnull input!");
                        } else {
                            recipes.addRecipe(output, "A", "B", "C", 'A', in00, 'B', in10, 'C', in20);
                        }
                    } else if (width == 2){
                        IRecipeInput in00 = input[0][0] != null ? IC2RecipeInputs.of(input[0][0]) : null;
                        IRecipeInput in10 = input[1][0] != null ? IC2RecipeInputs.of(input[1][0]) : null;
                        IRecipeInput in20 = input[2][0] != null ? IC2RecipeInputs.of(input[2][0]) : null;
                        IRecipeInput in01 = input[0][1] != null ? IC2RecipeInputs.of(input[0][1]) : null;
                        IRecipeInput in11 = input[1][1] != null ? IC2RecipeInputs.of(input[1][1]) : null;
                        IRecipeInput in21 = input[2][1] != null ? IC2RecipeInputs.of(input[2][1]) : null;
                        if (in00 == null && in10 == null && in20 == null && in01 == null && in11 == null && in21 == null){
                            CraftTweakerActions.printError("Recipe must have at least one nonnull input!");
                        } else {
                            recipes.addRecipe(output, "AB", "CD", "EF", 'A', in00, 'B', in01, 'C', in10, 'D', in11, 'E', in20, 'F', in21);
                        }
                    } else if (width == 3){
                        IRecipeInput in00 = input[0][0] != null ? IC2RecipeInputs.of(input[0][0]) : null;
                        IRecipeInput in10 = input[1][0] != null ? IC2RecipeInputs.of(input[1][0]) : null;
                        IRecipeInput in20 = input[2][0] != null ? IC2RecipeInputs.of(input[2][0]) : null;
                        IRecipeInput in01 = input[0][1] != null ? IC2RecipeInputs.of(input[0][1]) : null;
                        IRecipeInput in11 = input[1][1] != null ? IC2RecipeInputs.of(input[1][1]) : null;
                        IRecipeInput in21 = input[2][1] != null ? IC2RecipeInputs.of(input[2][1]) : null;
                        IRecipeInput in02 = input[0][2] != null ? IC2RecipeInputs.of(input[0][2]) : null;
                        IRecipeInput in12 = input[1][2] != null ? IC2RecipeInputs.of(input[1][2]) : null;
                        IRecipeInput in22 = input[2][2] != null ? IC2RecipeInputs.of(input[2][2]) : null;
                        if (in00 == null && in10 == null && in20 == null && in01 == null && in11 == null && in21 == null && in02 == null && in12 == null && in22 == null){
                            CraftTweakerActions.printError("Recipe must have at least one nonnull input!");
                        } else {
                            recipes.addRecipe(output, "ABC", "DEF", "GHI", 'A', in00, 'B', in01, 'C', in02, 'D', in10, 'E', in11, 'F', in12, 'G', in20, 'H', in21, 'I', in22);
                        }
                    }
                } else {
                    CraftTweakerActions.printError("Inner Recipe Arrays must all be the same lengths!");
                }
            }
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Stacked Shaped Crafting Recipe[%s -> %s] to %s", Arrays.deepToString(this.input), this.output, ClassicRecipes.advCrafting);
        }
    }

}
