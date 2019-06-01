package trinsdar.ic2classictweaker;

import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {
    private static final String CATEGORY_RARE_EARTH_EXTRACTOR = "rare earth extractor";
    private static final String CATEGORY_CANNING_MACHINE = "canning machine";

    public static boolean
    disableAllEmptyCanFillingRecipes = false,
    disableHCoalCell = false,
    disableBioCell = false,
    disableWaterCell = false,
    disableLavaCell = false,
    disableUraniumFuelCell = false,
    disableRedstoneUraniumFuelCell = false,
    disableBlazeUraniumFuelCell = false,
    disableEnderpearlUraniumFuelCell = false,
    disableNetherStarUraniumFuelCell = false,
    disableCharcoalUraniumFuelCell = false;

    public static boolean
    disableAllDefaultRareEarthRecipes = false,
    disableCobblestone = false,
    disableGranite = false,
    disableDiorite = false,
    disableAndestie = false,
    disableNetherrack = false,
    disableMycelium = false,
    disableClay = false,
    disableObsidian = false,
    disableSoulSand = false;

    public static void readConfig() {
        Configuration cfg = IC2ClassicTweaker.config;
        try {
            cfg.load();
            initGeneralConfig(cfg);
        } catch (Exception e1) {
            IC2ClassicTweaker.logger.log(Level.ERROR, "Problem loading config file!", e1);
        } finally {
            if (cfg.hasChanged()) {
                cfg.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration cfg) {
        cfg.addCustomCategoryComment(CATEGORY_CANNING_MACHINE, "Disable default filling recipes in the canning machine here.");
        disableAllEmptyCanFillingRecipes = cfg.getBoolean("disableAllEmptyCanFillingRecipes", CATEGORY_CANNING_MACHINE, disableAllEmptyCanFillingRecipes, "Disables all the filing recipes. The other entries have no effect if this is true.");
        disableHCoalCell = cfg.getBoolean("disableHCoalCell", CATEGORY_CANNING_MACHINE, disableHCoalCell, "");
        disableBioCell = cfg.getBoolean("disableBioCell", CATEGORY_CANNING_MACHINE, disableBioCell, "");
        disableWaterCell = cfg.getBoolean("disableWaterCell", CATEGORY_CANNING_MACHINE, disableWaterCell, "");
        disableLavaCell = cfg.getBoolean("disableLavaCell", CATEGORY_CANNING_MACHINE, disableLavaCell, "");
        disableUraniumFuelCell = cfg.getBoolean("disableUraniumFuelCell", CATEGORY_CANNING_MACHINE, disableUraniumFuelCell, "");
        disableRedstoneUraniumFuelCell = cfg.getBoolean("disableRedstoneUraniumFuelCell", CATEGORY_CANNING_MACHINE, disableRedstoneUraniumFuelCell, "");
        disableBlazeUraniumFuelCell = cfg.getBoolean("disableBlazeUraniumFuelCell", CATEGORY_CANNING_MACHINE, disableBlazeUraniumFuelCell, "");
        disableEnderpearlUraniumFuelCell = cfg.getBoolean("disableEnderpearlUraniumFuelCell", CATEGORY_CANNING_MACHINE, disableEnderpearlUraniumFuelCell, "");
        disableNetherStarUraniumFuelCell = cfg.getBoolean("disableNetherStarUraniumFuelCell", CATEGORY_CANNING_MACHINE, disableNetherStarUraniumFuelCell, "");
        disableCharcoalUraniumFuelCell = cfg.getBoolean("disableCharcoalUraniumFuelCell", CATEGORY_CANNING_MACHINE, disableCharcoalUraniumFuelCell, "");
        cfg.addCustomCategoryComment(CATEGORY_RARE_EARTH_EXTRACTOR, "Disable default rare earth inputs here.");
        disableAllDefaultRareEarthRecipes = cfg.getBoolean("disableAllDefaultRareEarthRecipes", CATEGORY_RARE_EARTH_EXTRACTOR, disableAllDefaultRareEarthRecipes, "Disables all the rare earth inputs. The other entries have no effect if this is true.");
    	disableCobblestone = cfg.getBoolean("disableCobblestone", CATEGORY_RARE_EARTH_EXTRACTOR, disableCobblestone, "");
    	disableGranite = cfg.getBoolean("disableGranite", CATEGORY_RARE_EARTH_EXTRACTOR, disableGranite, "");
    	disableDiorite = cfg.getBoolean("disableDiorite", CATEGORY_RARE_EARTH_EXTRACTOR, disableDiorite, "");
    	disableAndestie = cfg.getBoolean("disableAndestie", CATEGORY_RARE_EARTH_EXTRACTOR, disableAndestie, "");
    	disableNetherrack = cfg.getBoolean("disableNetherrack", CATEGORY_RARE_EARTH_EXTRACTOR, disableNetherrack, "");
    	disableMycelium = cfg.getBoolean("disableMycelium", CATEGORY_RARE_EARTH_EXTRACTOR, disableMycelium, "");
    	disableClay = cfg.getBoolean("disableClay", CATEGORY_RARE_EARTH_EXTRACTOR, disableClay, "");
    	disableObsidian = cfg.getBoolean("disableObsidian", CATEGORY_RARE_EARTH_EXTRACTOR, disableObsidian, "");
    	disableSoulSand = cfg.getBoolean("disableSoulSand", CATEGORY_RARE_EARTH_EXTRACTOR, disableSoulSand, "");
    }
}
