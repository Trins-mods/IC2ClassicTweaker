package trinsdar.ic2classictweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;

public class CraftTweakerActions {
    private static final boolean DEBUG = Boolean.getBoolean("ic2_classic_tweaker.debug");

    static void apply(IAction action) {
        if (DEBUG) {
            CraftTweakerAPI.apply(action);
        } else {
            action.apply();
        }
    }
}
