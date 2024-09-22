package trinsdar.ic2classictweaker;

import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.custom.IClassicScrapBoxManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = IC2ClassicTweaker.MODID, name = IC2ClassicTweaker.MODNAME, version = IC2ClassicTweaker.VERSION, dependencies = "required-after:ic2;required-after:ic2-classic-spmod;required-after:crafttweaker;before:ic2_tweaker;before:jei")
public class IC2ClassicTweaker {
    public static final String MODID = "ic2_classic_tweaker";
    public static final String MODNAME = "IC2 Classic Tweaker";
    public static final String VERSION = "@VERSION@";

    public static Logger logger;
    public static List<ItemStack> scrapboxToRemove;
    @SidedProxy(
            clientSide = "trinsdar.ic2classictweaker.ProxyClient",
            serverSide = "trinsdar.ic2classictweaker.Proxy")
    public static Proxy proxy;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        if (Loader.isModLoaded("ic2_tweaker")){
           proxy.error();
        }
        scrapboxToRemove = new ArrayList<>();
    }

    @Mod.EventHandler
    public static void postInit(FMLPostInitializationEvent event){
        for (ItemStack stack : scrapboxToRemove){
            for (IClassicScrapBoxManager.IDrop drop : ClassicRecipes.scrapboxDrops.getEntries()){
                if (drop.getDrop().isItemEqual(stack)){
                    ClassicRecipes.scrapboxDrops.removeDrop(drop);
                }
            }
        }
    }
}
