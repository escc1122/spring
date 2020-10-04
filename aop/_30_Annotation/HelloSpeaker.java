package _30_Annotation;

public class HelloSpeaker implements InterfaceHello {
    @HelloLogAnnotation
    public void hello(String name) {
        System.out.println("Hello, " + name);
    }
    @HelloLogAnnotation(beforeLog = true,afterLog = true)
    public void hello2(String name) {
        System.out.println("Hello2, " + name);
    }
}
