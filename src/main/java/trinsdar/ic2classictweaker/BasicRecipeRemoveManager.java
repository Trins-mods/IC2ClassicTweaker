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
        /*List<IMachineRecipeList.RecipeEntry> copy = new ArrayList<>();
        int i = 0;
        for (IMachineRecipeList.RecipeEntry entry : ClassicRecipes.macerator.getRecipeMap()){
            IRecipeInput listInput = entry.getInput();
            i++;
            for (ItemStack stack : input.getInputs()){
                if (listInput.matches(stack)){
                    copy.add(entry);
                    CraftTweakerAPI.logInfo("Removing recipe of " + stack.getDisplayName() + " in " + "ic2-classic-tweaker");
                    break;
                }
            }
        }
        i = 0;
        for (IMachineRecipeList.RecipeEntry entry : list.getRecipeMap()){
        }
        System.out.println(i);*/
    }

    @Override
    public String describe() {
        return String.format(Locale.ENGLISH, "Remove Recipe[%s] from %s", this.input, this.list);
    }
}
