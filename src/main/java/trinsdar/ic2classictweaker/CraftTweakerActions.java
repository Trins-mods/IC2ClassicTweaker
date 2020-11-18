package trinsdar.ic2classictweaker;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.IAction;
import crafttweaker.mc1120.CraftTweaker;

public class CraftTweakerActions {

    static void apply(IAction action) {
        if ((action instanceof ILateAction && ((ILateAction)action).isLate())){
            CraftTweaker.LATE_ACTIONS.add(action);
            return;
        }
        CraftTweakerAPI.apply(action);
    }

    static void printError(String message) {
        CraftTweakerAPI.logError(CraftTweakerAPI.getScriptFileAndLine() + " > "+ message);
    }
}
