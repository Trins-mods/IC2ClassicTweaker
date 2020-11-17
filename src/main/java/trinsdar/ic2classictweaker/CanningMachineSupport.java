package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.recipe.IRecipeInput;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Locale;

@ModOnly("ic2")
@ZenClass("mods.ic2.CanningMachine")
@ZenRegister
public class CanningMachineSupport {
    @ZenMethod
    public static void registerItemsForEffect(int id, IItemStack... input) {
        CraftTweakerActions.apply(new RegisterItemsForEffectAction(id, CraftTweakerMC.getItemStacks(input)));
    }

    @ZenMethod
    public static void deleteEffectId(int id, boolean deleteItems){
        CraftTweakerActions.apply(new DeleteEffectIdAction(id, deleteItems));
    }

    @ZenMethod
    public static void registerFuelValue(int value, IItemStack input) {
        CraftTweakerActions.apply(new RegisterFuelValueAction(value, CraftTweakerMC.getItemStack(input)));
    }

    @ZenMethod
    public static void registerFuelMultiplier(float multiplier, IItemStack input) {
        CraftTweakerActions.apply(new RegisterFuelMultiplierAction(multiplier, CraftTweakerMC.getItemStack(input)));
    }

    @ZenMethod
    public static void deleteItemFuel(IItemStack fuel) {
        CraftTweakerActions.apply(new DeleteItemFuelAction(CraftTweakerMC.getItemStack(fuel)));
    }

    @ZenMethod
    public static void addCanningRecipe(IItemStack output, IIngredient input, IItemStack container) {
        CraftTweakerActions.apply(new AddCanningRecipeAction(CraftTweakerMC.getItemStack(output), IC2RecipeInputs.of(input), CraftTweakerMC.getItemStack(container)));
    }

    @ZenMethod
    public static void removeCanningContainer(IItemStack container) {
        CraftTweakerActions.apply(new RemoveCanningContainerAction(CraftTweakerMC.getItemStack(container)));
    }

    @ZenMethod
    public static void removeCanningRecipe(IItemStack container, IItemStack input) {
        CraftTweakerActions.apply(new RemoveCanningRecipeAction(CraftTweakerMC.getItemStack(container), CraftTweakerMC.getItemStack(input)));
    }

    private static final class RegisterItemsForEffectAction implements IAction {

        private final int id;
        private final ItemStack[] input;

        RegisterItemsForEffectAction(int id, ItemStack... input) {
            this.id = id;
            this.input = input;
        }

        @Override
        public void apply() {
            ClassicRecipes.canningMachine.registerItemsForEffect(id, input);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Recipe[%s %s] to %s", this.id, Arrays.deepToString(this.input), ClassicRecipes.canningMachine);
        }
    }

    private static final class RegisterFuelValueAction implements IAction {

        private final int value;
        private final ItemStack input;

        RegisterFuelValueAction(int value, ItemStack input) {
            this.value = value;
            this.input = input;
        }

        @Override
        public void apply() {
            ClassicRecipes.canningMachine.registerFuelValue(input, value);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Recipe[%s %s] to %s", this.value, this.input, ClassicRecipes.canningMachine);
        }
    }

    private static final class RegisterFuelMultiplierAction implements IAction {

        private final float multiplier;
        private final ItemStack input;

        RegisterFuelMultiplierAction(float multiplier, ItemStack input) {
            this.multiplier = multiplier;
            this.input = input;
        }

        @Override
        public void apply() {
            ClassicRecipes.canningMachine.registerFuelMultiplier(input, multiplier);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Recipe[%s %s] to %s", this.multiplier, this.input, ClassicRecipes.canningMachine);
        }
    }

    private static final class AddCanningRecipeAction implements IAction {

        private final ItemStack output;
        private final IRecipeInput input;
        private final ItemStack container;

        AddCanningRecipeAction(ItemStack output, IRecipeInput input, ItemStack container) {
            this.output = output;
            this.input = input;
            this.container = container;
        }

        @Override
        public void apply() {
            ClassicRecipes.canningMachine.registerCannerItem(container, input, output);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Recipe[%s %s -> %s] to %s", this.input, this.container, this.output, ClassicRecipes.canningMachine);
        }
    }

    private static final class RemoveCanningContainerAction implements ILateAction {

        private final ItemStack container;

        RemoveCanningContainerAction(ItemStack container) {
            this.container = container;
        }

        @Override
        public void apply() {
            ClassicRecipes.canningMachine.removeCanningRecipe(container);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Remove Canning Container[%s] from %s", this.container, ClassicRecipes.canningMachine);
        }
    }

    private static final class RemoveCanningRecipeAction implements ILateAction {

        private final ItemStack input;
        private final ItemStack container;

        RemoveCanningRecipeAction(ItemStack input, ItemStack container) {
            this.input = input;
            this.container = container;
        }

        @Override
        public void apply() {
            ClassicRecipes.canningMachine.removeCanningRecipe(container, input);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Remove Recipe[%s %s] from %s", this.input, this.container, ClassicRecipes.canningMachine);
        }
    }

    private static final class DeleteItemFuelAction implements ILateAction {

        private final ItemStack fuel;

        DeleteItemFuelAction(ItemStack fuel) {
            this.fuel = fuel;
        }

        @Override
        public void apply() {
            ClassicRecipes.canningMachine.deleteItemFuel(fuel);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Recipe[%s %s] to %s", this.fuel, ClassicRecipes.canningMachine);
        }
    }

    private static final class DeleteEffectIdAction implements ILateAction {

        private final int id;
        private final boolean items;

        DeleteEffectIdAction(int id, boolean items) {
            this.id = id;
            this.items = items;
        }

        @Override
        public void apply() {
            ClassicRecipes.canningMachine.deleteEffectID(id, items);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Remove Food Effect[%s %s] from %s", this.id, this.items, ClassicRecipes.canningMachine);
        }
    }
}
