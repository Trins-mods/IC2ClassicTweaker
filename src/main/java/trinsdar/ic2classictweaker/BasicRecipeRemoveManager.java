package trinsdar.ic2classictweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.machine.IMachineRecipeList;
import ic2.api.recipe.IRecipeInput;
import ic2.core.IC2;
import ic2.core.block.machine.recipes.managers.BasicMachineRecipeList;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BasicRecipeRemoveManager implements ILateAction {
    IMachineRecipeList list;
    IRecipeInput input;

    public BasicRecipeRemoveManager(IMachineRecipeList list, IRecipeInput input){
        this.list = list;
        this.input = input;
    }

    @Override
    public void apply() {
        list.removeRecipe(input);
    }

    @Override
    public String describe() {
        return String.format(Locale.ENGLISH, "Remove Recipe[%s] from %s", this.input, this.list);
    }
}
