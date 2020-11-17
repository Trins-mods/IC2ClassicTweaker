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
@ZenExpansion("mods.ic2.ThermalCentrifuge")
@ZenRegister
public class ThermalCentrifugeSupport {
    @ZenMethodStatic
    public static void addLateRecipe(IItemStack[] outputs, IIngredient input, @Optional(valueLong = 1000L) int minHeat) {
        NBTTagCompound data = new NBTTagCompound();
        data.setInteger("minHeat", minHeat);
        CraftTweakerActions.apply(new BasicRecipeAddManager(Ic2cExtrasRecipes.thermalCentrifuge, IC2RecipeInputs.of(input),data, CraftTweakerMC.getItemStacks(outputs)));
    }

    @ZenMethodStatic
    public static void removeRecipe(IIngredient input){
        CraftTweakerActions.apply(new BasicRecipeRemoveManager(Ic2cExtrasRecipes.thermalCentrifuge, IC2RecipeInputs.of(input)));
    }
}
