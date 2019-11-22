package trinsdar.ic2classictweaker;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import ic2.api.recipe.IRecipeInput;
import ic2.api.recipe.Recipes;

public class IC2RecipeInputs {
    static IRecipeInput of(IItemStack item) {
        return Recipes.inputFactory.forStack(CraftTweakerMC.getItemStack(item));
    }

    static IRecipeInput of(IIngredient ingredient) {
        // TODO Dealing with null
        if (ingredient instanceof IItemStack) {
            return IC2RecipeInputs.of((IItemStack)ingredient);
        } else if (ingredient instanceof IOreDictEntry) {
            return Recipes.inputFactory.forOreDict(((IOreDictEntry)ingredient).getName(), ingredient.getAmount());
        } else {
            // Fallback to the universal solution if we can't take any shortcut
            return new CraftTweakerIngredientInput(ingredient);
        }
    }

    static IRecipeInput[] of(IIngredient[] ingredient) {
        // TODO Dealing with null
        IRecipeInput[] inputs = new IRecipeInput[ingredient.length];
        for (int i = 0; i < ingredient.length; i++ ){
            IIngredient input = ingredient[i];
            if (input instanceof IItemStack) {
                inputs[i] = IC2RecipeInputs.of((IItemStack)input);
            } else if (input instanceof IOreDictEntry) {
                inputs[i] = Recipes.inputFactory.forOreDict(((IOreDictEntry)input).getName(), input.getAmount());
            } else {
                // Fallback to the universal solution if we can't take any shortcut
                inputs[i] = new CraftTweakerIngredientInput(input);
            }
        }
        return inputs;
    }
}
