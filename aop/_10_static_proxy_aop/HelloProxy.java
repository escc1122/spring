package _10_static_proxy_aop;



public class HelloProxy implements InterfaceHello{
    private InterfaceHello helloObject;

    public HelloProxy(InterfaceHello helloObject) {
        this.helloObject = helloObject;
    }

    public void hello(String name) {
        // 日誌服務
        log("hello method starts....");

        // 執行商務邏輯
        helloObject.hello(name);

        // 日誌服務
        log("hello method ends....");
    }

    private void log(String msg) {
        System.out.println("system log : " + msg);
    }
}
