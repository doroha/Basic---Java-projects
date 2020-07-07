public class Driver {
    public static ProjectsBridgeInterface getBridge(){
        ProxyBridge bridge = new ProxyBridge();
        //RealBridge bridge = new RealBridge();
        return bridge;
    }
}
