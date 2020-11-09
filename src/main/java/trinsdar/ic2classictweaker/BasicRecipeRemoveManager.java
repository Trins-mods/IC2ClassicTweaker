package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.machine.IMachineRecipeList;
import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BasicRecipeRemoveManager implements IAction {
    IMachineRecipeList list;
    IRecipeInput input;

    public BasicRecipeRemoveManager(IMachineRecipeList list, IRecipeInput input){
        this.list = list;
        this.input = input;
    }

    @Override
    public void apply() {
        List<IMachineRecipeList.RecipeEntry> copy = new ArrayList<>(list.getRecipeMap());
        for (IMachineRecipeList.RecipeEntry entry : copy){
            IRecipeInput listInput = entry.getInput();
            for (ItemStack stack : input.getInputs()){
                if (listInput.matches(stack)){
                    list.removeRecipe(listInput);
                    break;
                }
            }
        }
    }

    @Override
    public String describe() {
        return String.format(Locale.ENGLISH, "Remove Recipe[%s] from %s", this.input, this.list);
    }
}
