package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;
import java.util.Locale;

@ModOnly("ic2")
@ZenClass("mods.ic2.RareEarthExtractor")
@ZenRegister
public class RareEarthExtractorSupport {

    @ZenMethod
    public static void addRareEarthEntries(float value, IItemStack... input) {
        CraftTweakerActions.apply(new RareEarthValueAdditionAction(value, CraftTweakerMC.getItemStacks(input)));
    }

    @ZenMethod
    public static void removeRareEarthEntries(String input, @Optional() int meta) {
        CraftTweakerActions.apply(new RareEarthValueRemovalAction(input, meta));
    }

    private static final class RareEarthValueAdditionAction implements IAction {

        private final ItemStack[] input;
        private final float value;

        RareEarthValueAdditionAction(float value, ItemStack... input) {
            this.input = input;
            this.value = value;
        }

        @Override
        public void apply() {
            ClassicRecipes.earthExtractor.registerValue(value, input);
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Add Entry[%s, %s] to %s", this.value, Arrays.deepToString(this.input), ClassicRecipes.earthExtractor);
        }
    }

    private static final class RareEarthValueRemovalAction implements IAction {

        private final String input;
        private final int meta;

        RareEarthValueRemovalAction(String input, int meta) {
            this.input = input;
            this.meta = meta;
        }

        @Override
        public void apply() {
            ResourceLocation id = new ResourceLocation(input);
            ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Item.getByNameOrId(input), 1, meta));
        }

        @Override
        public String describe() {
            return String.format(Locale.ENGLISH, "Remove Entry[%s] from %s", this.input, ClassicRecipes.earthExtractor);
        }
    }
}
