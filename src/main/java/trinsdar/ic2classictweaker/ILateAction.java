package trinsdar.ic2classictweaker;

import crafttweaker.IAction;

public interface ILateAction extends IAction {
    default boolean isLate(){
        return true;
    }
}
