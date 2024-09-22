package trinsdar.ic2classictweaker;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;
import trinsdar.ic2c_extras.recipes.Ic2cExtrasRecipes;

@ModOnly("ic2c_extras")
@ZenClass("mods.ic2.OreWasher")
@ZenRegister
public class OreWasherSupport {
    @ZenMethod
    public static void addRecipe(IItemStack[] outputs, IIngredient input, @Optional(valueLong = 1000L) int water) {
        NBTTagCompound data = new NBTTagCompound();
        data.setInteger("amount", water);
        CraftTweakerActions.apply(new BasicRecipeAddManager(Ic2cExtrasRecipes.oreWashingPlant, IC2RecipeInputs.of(input), data, 0.0f, CraftTweakerMC.getItemStacks(outputs)));
    }

    @ZenMethod
    public static void addLateRecipe(IItemStack[] outputs, IIngredient input, @Optional(valueLong = 1000L) int water) {
        NBTTagCompound data = new NBTTagCompound();
        data.setInteger("amount", water);
        CraftTweakerActions.apply(new BasicRecipeAddManager(Ic2cExtrasRecipes.oreWashingPlant, IC2RecipeInputs.of(input), data, 0.0f, CraftTweakerMC.getItemStacks(outputs)).setLate(true));
    }

    @ZenMethodStatic
    public static void removeRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(Ic2cExtrasRecipes.oreWashingPlant, IC2RecipeInputs.of(input)));
    }
}
