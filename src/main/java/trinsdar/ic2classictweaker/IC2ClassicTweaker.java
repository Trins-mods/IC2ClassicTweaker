package trinsdar.ic2classictweaker;

import ic2.api.classic.recipe.ClassicRecipes;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = IC2ClassicTweaker.MODID, name = IC2ClassicTweaker.MODNAME, version = IC2ClassicTweaker.VERSION, dependencies = "required-after:ic2;required-after:ic2-classic-spmod;required-after:crafttweaker;required-after:ic2_tweaker;before:jei")
public class IC2ClassicTweaker {
    public static final String MODID = "ic2_classic_tweaker";
    public static final String MODNAME = "IC2 Classic Tweaker";
    public static final String VERSION = "@VERSION@";

    public static Logger logger;
    public static Configuration config;

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event){
        logger = event.getModLog();
        File directory = event.getModConfigurationDirectory();
        config = new Configuration(new File(directory.getPath(), "ic2/ic2classictweaker.cfg"));
        Config.readConfig();
    }

    @Mod.EventHandler
    public static void init(FMLInitializationEvent event){
        initRemoveCanningMachineRecipes();
        initRemoveRareEarthRecipes();
    }

    private static void initRemoveRareEarthRecipes(){
        if (Config.disableAllDefaultRareEarthRecipes){
            ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Blocks.COBBLESTONE), new ItemStack(Blocks.STONE, 1, 1), new ItemStack(Blocks.STONE, 1, 3), new ItemStack(Blocks.STONE, 1, 5), new ItemStack(Blocks.NETHERRACK), new ItemStack(Blocks.MYCELIUM), new ItemStack(Items.CLAY_BALL), new ItemStack(Blocks.OBSIDIAN), new ItemStack(Blocks.SOUL_SAND));
        }else {
            if (Config.disableCobblestone){
                ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Blocks.COBBLESTONE));
            }
            if (Config.disableGranite){
                ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Blocks.STONE, 1, 1));
            }
            if (Config.disableDiorite){
                ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Blocks.STONE, 1, 3));
            }
            if (Config.disableAndestie){
                ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Blocks.STONE, 1, 5));
            }
            if (Config.disableNetherrack){
                ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Blocks.NETHERRACK));
            }
            if (Config.disableMycelium){
                ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Blocks.MYCELIUM));
            }
            if (Config.disableClay){
                ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Items.CLAY_BALL));
            }
            if (Config.disableObsidian){
                ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Blocks.OBSIDIAN));
            }
            if (Config.disableSoulSand){
                ClassicRecipes.earthExtractor.removeEntry(new ItemStack(Blocks.SOUL_SAND));
            }
        }
    }

    private static void initRemoveCanningMachineRecipes(){
        if (Config.disableAllEmptyCanFillingRecipes){
            ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell);
        }else {
            if (Config.disableHCoalCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, Ic2Items.hydratedCoalClump);
            }
            if (Config.disableBioCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, Ic2Items.bioBall);
            }
            if (Config.disableLavaCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, new ItemStack(Blocks.LAVA));
            }
            if (Config.disableWaterCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, new ItemStack(Blocks.WATER));
            }
            if (Config.disableUraniumFuelCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, Ic2Items.uraniumIngot);
            }
            if (Config.disableRedstoneUraniumFuelCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, Ic2Items.redstoneUraniumIngot);
            }
            if (Config.disableBlazeUraniumFuelCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, Ic2Items.blazeUraniumIngot);
            }
            if (Config.disableEnderpearlUraniumFuelCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, Ic2Items.enderPearlUraniumIngot);
            }
            if (Config.disableNetherStarUraniumFuelCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, Ic2Items.netherStarUraniumIngot);
            }
            if (Config.disableCharcoalUraniumFuelCell){
                ClassicRecipes.canningMachine.removeCanningRecipe(Ic2Items.emptyCell, Ic2Items.charcoalUraniumIngot);
            }
        }
    }
}
