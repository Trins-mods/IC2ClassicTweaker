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

public class BasicRecipeAddManager implements IAction {
    private final IMachineRecipeList manager;
    private final IRecipeInput input;
    private final NBTTagCompound data;
    private final ItemStack[] output;

    BasicRecipeAddManager(IMachineRecipeList manager, IRecipeInput input, @Nullable NBTTagCompound data, ItemStack... output) {
        this.manager = manager;
        this.input = input;
        this.data = data;
        this.output = output;
    }

    @Override
    public void apply() {
        this.manager.addRecipe(this.input, new MachineOutput(this.data, output), output[0].getUnlocalizedName() + "_ct");
    }

    @Override
    public String describe() {
        return String.format(Locale.ENGLISH, "Add Recipe[%s, %s -> %s] to %s", this.input, this.data, Arrays.deepToString(this.output), this.manager);
    }
}
