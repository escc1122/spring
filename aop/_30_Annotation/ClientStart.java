package _30_Annotation;
public class ClientStart {
    public static void main(String[] args){
        ReflectAnnotation reflectAnnotation = new ReflectAnnotation();

        InterfaceHello helloSpeaker =
                (InterfaceHello) reflectAnnotation.bind(new HelloSpeaker());
        helloSpeaker.hello("Justin");

        helloSpeaker.hello2("Justin");
    }
}
