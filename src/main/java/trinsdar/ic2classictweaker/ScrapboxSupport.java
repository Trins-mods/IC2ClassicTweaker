package trinsdar.ic2classictweaker;

import crafttweaker.IAction;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import ic2.api.classic.recipe.ClassicRecipes;
import net.minecraft.item.ItemStack;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethodStatic;

import java.util.Locale;

@ModOnly("ic2-classic-spmod")
@ZenRegister
@ZenExpansion("mods.ic2.ScrapBox")
public class ScrapboxSupport {

    @ZenMethodStatic
    public static void removeDrop(IItemStack item){
        CraftTweakerActions.apply(new ScrapBoxRemoveAction(CraftTweakerMC.getItemStack(item)));
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
