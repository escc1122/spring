package _20_dynamic_proxy_aop;

import _10_static_proxy_aop.HelloSpeaker;
import _10_static_proxy_aop.InterfaceHello;

public class ClientStart {
    public static void main(String[] args){
        LogHandler logHandler  = new LogHandler();

        InterfaceHello helloProxy =
                (InterfaceHello) logHandler.bind(new HelloSpeaker());
        helloProxy.hello("Justin");
    }
}
