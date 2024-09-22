package trinsdar.ic2classictweaker;

public class Proxy {
    public void error(){
        throw new RuntimeException("Mod ic2_classic_tweaker (IC2 Classic Tweaker) is incompatible with mod ic2_tweaker (IC2 Tweaker). Please remove IC2 Tweaker");
    }
}
