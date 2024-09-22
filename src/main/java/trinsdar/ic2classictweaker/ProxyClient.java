package trinsdar.ic2classictweaker;

public class ProxyClient extends Proxy {
    @Override
    public void error(){
        throw new IncompatibleModException();
    }
}
