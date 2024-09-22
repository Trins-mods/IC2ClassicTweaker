package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import ic2.api.classic.recipe.machine.IMachineRecipeList;
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

    BasicRecipeAddManager(IMachineRecipeList manager, IRecipeInput input, @Nullable NBTTagCompound data, ItemStack... output) {
        this.manager = manager;
        this.input = input;
        this.data = data;
        this.output = output;
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
        this.manager.addRecipe(this.input, new MachineOutput(this.data, output), output[0].getTranslationKey() + "_ct");
    }

    @Override
    public String describe() {
        if (!Configuration.debug){
            return null;
        }
        return String.format(Locale.ENGLISH, "Add Recipe[%s, %s -> %s] to %s", this.input, this.data, Arrays.deepToString(this.output), this.manager);
    }
}
