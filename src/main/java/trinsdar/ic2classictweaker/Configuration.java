package trinsdar.ic2classictweaker;

import net.minecraftforge.common.config.Config;

@Config(modid = IC2ClassicTweaker.MODID, name = "ic2/ic2_classic_tweaker")
public class Configuration {
    @Config.Comment({
            "If true logs recipe describers in some added recipes not already logged in ct log."
    })
    @Config.RequiresMcRestart
    public static boolean debug = false;
}
