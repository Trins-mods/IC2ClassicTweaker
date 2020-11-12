package trinsdar.ic2classictweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.mc1120.CraftTweaker;

public class CraftTweakerActions {
    private static final boolean DEBUG = Boolean.getBoolean("ic2_classic_tweaker.debug");

    static void apply(IAction action) {
        if (action instanceof BasicRecipeRemoveManager || action instanceof BasicRecipeAddManager){
            CraftTweaker.LATE_ACTIONS.add(action);
            return;
        }
        if (DEBUG) {
            CraftTweakerAPI.apply(action);
        } else {
            action.apply();
        }
    }

    static void printError(String message) {
        CraftTweakerAPI.logError(CraftTweakerAPI.getScriptFileAndLine() + " > "+ message);
    }
}
