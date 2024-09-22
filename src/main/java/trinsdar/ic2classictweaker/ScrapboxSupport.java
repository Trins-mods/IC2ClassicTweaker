package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.item.WeightedItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenMethodStatic;

import java.util.AbstractMap;
import java.util.Locale;

@ZenClass("mods.ic2.ScrapBox")
@ZenRegister
public class ScrapboxSupport {
    @ZenMethod
    public static void addDrop(WeightedItemStack weightedItem) {
        CraftTweakerActions.apply(new AddScrapBoxDropAction(weightedItem));
    }

    @ZenMethod
    public static void addDrop(IItemStack item, float chance) {
        CraftTweakerActions.apply(new AddScrapBoxDropAction(item, chance));
    }

    @ZenMethod
    public static void removeDrop(IItemStack item){
        CraftTweakerActions.apply(new ScrapBoxRemoveAction(CraftTweakerMC.getItemStack(item)));
    }

    private static final class AddScrapBoxDropAction implements IAction {

        private final float weight;
        private final ItemStack item;

        AddScrapBoxDropAction(WeightedItemStack weightedItem) {
            this(weightedItem.getStack(), weightedItem.getChance());
        }

        AddScrapBoxDropAction(IItemStack item, float weight) {
            this.item = CraftTweakerMC.getItemStack(item);
            this.weight = weight;
        }

        @Override
        public void apply() {
            ClassicRecipes.scrapboxDrops.addDrop(this.item, weight);
        }

        @Override
        public String describe() {
            if (!Configuration.debug){
                return null;
            }
            return String.format(Locale.ENGLISH, "Added drop %s with weight %s to %s", item, weight, ClassicRecipes.scrapboxDrops);
        }
    }

    private static final class ScrapBoxRemoveAction implements IAction {
        ItemStack item;

        ScrapBoxRemoveAction(ItemStack item){
            this.item = item;
        }

        @Override
        public void apply() {
            IC2ClassicTweaker.scrapboxToRemove.add(item);
        }

        @Override
        public String describe() {
            if (!Configuration.debug){
                return null;
            }
            return String.format(Locale.ENGLISH, "Removed drop %s from %s", item, ClassicRecipes.scrapboxDrops);
        }
    }
}
