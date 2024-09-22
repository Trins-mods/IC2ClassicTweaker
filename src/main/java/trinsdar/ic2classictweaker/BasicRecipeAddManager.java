package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import ic2.api.classic.recipe.machine.IMachineRecipeList;
import ic2.api.classic.recipe.machine.MachineExpOutput;
import ic2.api.classic.recipe.machine.MachineOutput;
import ic2.api.recipe.IBasicMachineRecipeManager;
import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Locale;

public class BasicRecipeAddManager implements ILateAction {
    private final IMachineRecipeList manager;
    private final IRecipeInput input;
    private final NBTTagCompound data;
    private final ItemStack[] output;
    private boolean late = false;
    private final float exp;

    BasicRecipeAddManager(IMachineRecipeList manager, IRecipeInput input, @Nullable NBTTagCompound data, float exp, ItemStack... output) {
        this.manager = manager;
        this.input = input;
        this.data = data;
        this.output = output;
        this.exp = exp;
    }

    BasicRecipeAddManager setLate(boolean late){
        this.late = late;
        return this;
    }

    @Override
    public boolean isLate() {
        return late;
    }

    @Override
    public void apply() {
        if (exp > 0.0F) {
            this.manager.addRecipe(input, new MachineExpOutput(data, exp, output), output[0].getTranslationKey() + "_ct");
        } else {
            this.manager.addRecipe(this.input, new MachineOutput(this.data, output), output[0].getTranslationKey() + "_ct");
        }
    }

    @Override
    public String describe() {
        return String.format(Locale.ENGLISH, "Add Recipe[%s, %s -> %s] to %s", this.input, this.data, Arrays.deepToString(this.output), this.manager);
    }
}
