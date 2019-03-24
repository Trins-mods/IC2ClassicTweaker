package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.liquid.ILiquidStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import net.minecraftforge.fluids.FluidStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Locale;

@ModOnly("ic2")
@ZenClass("mods.ic2.LiquidFuelGenerator")
@ZenRegister
public class LiquidFuelGeneratorSupport {

    @ZenMethod
    public static void addFluid(ILiquidStack liquid, int ticks, int powerOutput) {
        CraftTweakerActions.apply(new LiquidFuelGeneratorFuelAction(liquid, ticks, powerOutput));
    }

    private static final class LiquidFuelGeneratorFuelAction implements IAction {

        private final FluidStack fluid;
        private final int time;
        private final int power;

        LiquidFuelGeneratorFuelAction(ILiquidStack liquid, int time, int power) {
            this.fluid = CraftTweakerMC.getLiquidStack(liquid);
            this.time = time;
            this.power = power;
        }

        @Override
        public void apply() {
            ClassicRecipes.fluidGenerator.addEntry(fluid.getFluid(), time, power);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Recipe[%s, %s -> %s] to %s", this.fluid, ClassicRecipes.sawMill);
        }
    }
}
