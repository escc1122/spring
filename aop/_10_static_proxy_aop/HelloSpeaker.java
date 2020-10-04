package _10_static_proxy_aop;

public class HelloSpeaker  implements InterfaceHello{
    public void hello(String name) {
        System.out.println("Hello, " + name);
    }
}
