package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Locale;

@ModOnly("ic2")
@ZenClass("mods.ic2.ClassicElectrolyzer")
@ZenRegister
public class ClassicElectrolyzerSupport {
    @ZenMethod
    public static void addBothRecipe(IItemStack output, IItemStack input, int energy) {
        CraftTweakerActions.apply(new ElectrolyzerBothRecipeAction(CraftTweakerMC.getItemStack(input), CraftTweakerMC.getItemStack(output), energy));
    }

    @ZenMethod
    public static void addChargeRecipe(IItemStack output, IItemStack input, int energy) {
        CraftTweakerActions.apply(new ElectrolyzerChargeRecipeAction(CraftTweakerMC.getItemStack(input), CraftTweakerMC.getItemStack(output), energy));
    }

    @ZenMethod
    public static void addDischargeRecipe(IItemStack output, IItemStack input, int energy) {
        CraftTweakerActions.apply(new ElectrolyzerDischargeRecipeAction(CraftTweakerMC.getItemStack(input), CraftTweakerMC.getItemStack(output), energy));
    }

    private static final class ElectrolyzerBothRecipeAction implements IAction {

        private final ItemStack input;
        private final ItemStack output;
        private final int charge;

        ElectrolyzerBothRecipeAction(ItemStack input, ItemStack output, int charge) {
            this.input = input;
            this.output = output;
            this.charge = charge;
        }

        @Override
        public void apply() {
            ClassicRecipes.electrolyzer.addBothRecipe(input, output, charge, input.getDisplayName());
        }

        @Override
        public String describe() {
            if (!Configuration.debug){
                return null;
            }
            return String.format(Locale.ENGLISH, "Add Both Recipe[%s, %s -> %s] to %s", this.input, this.charge, this.output, ClassicRecipes.electrolyzer);
        }
    }

    private static final class ElectrolyzerChargeRecipeAction implements IAction {

        private final ItemStack input;
        private final ItemStack output;
        private final int charge;

        ElectrolyzerChargeRecipeAction(ItemStack input, ItemStack output, int charge) {
            this.input = input;
            this.output = output;
            this.charge = charge;
        }

        @Override
        public void apply() {
            ClassicRecipes.electrolyzer.addChargeRecipe(input, output, charge, input.getDisplayName());
        }

        @Override
        public String describe() {
            if (!Configuration.debug){
                return null;
            }
            return String.format(Locale.ENGLISH, "Add Charge Recipe[%s, %s -> %s] to %s", this.input, this.charge, this.output, ClassicRecipes.electrolyzer);
        }
    }

    private static final class ElectrolyzerDischargeRecipeAction implements IAction {

        private final ItemStack input;
        private final ItemStack output;
        private final int charge;

        ElectrolyzerDischargeRecipeAction(ItemStack input, ItemStack output, int charge) {
            this.input = input;
            this.output = output;
            this.charge = charge;
        }

        @Override
        public void apply() {
            ClassicRecipes.electrolyzer.addDischargeRecipe(input, output, charge, input.getDisplayName());
        }

        @Override
        public String describe() {
            if (!Configuration.debug){
                return null;
            }
            return String.format(Locale.ENGLISH, "Add Discharge Recipe[%s, %s -> %s] to %s", this.input, this.charge, this.output, ClassicRecipes.electrolyzer);
        }
    }
}
