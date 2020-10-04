package _50_cglib_annotation;

import _30_Annotation.HelloLogAnnotation;

public class HelloSpeaker {
    @HelloLogAnnotation
    public void hello(String name) {
        System.out.println("Hello, " + name);
    }
    @HelloLogAnnotation(beforeLog = true,afterLog = true)
    public void hello2(String name) {
        System.out.println("Hello2, " + name);
    }
}
