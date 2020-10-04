package _30_Annotation;

//import static_proxy_aop.HelloSpeaker;
//import _3_Annotation.HelloSpeaker;
//import static_proxy_aop.InterfaceHello;



public class ClientStart {
    public static void main(String[] args){
        ReflectAnnotation reflectAnnotation = new ReflectAnnotation();

        InterfaceHello helloSpeaker =
                (InterfaceHello) reflectAnnotation.bind(new HelloSpeaker());
        helloSpeaker.hello("Justin");

        helloSpeaker.hello2("Justin");

//        InterfaceHello helloProxy =
//                (InterfaceHello) reflectAnnotation.bind(new HelloSpeaker());
//        helloProxy.hello("Justin");
    }
}
