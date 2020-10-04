package _10_static_proxy_aop;

public class ClientStart {
    public static void main(String[] args){
        InterfaceHello proxy =
                new HelloProxy(new HelloSpeaker());
        proxy.hello("Justin");
    }
}
