package _50_cglib_annotation;



import net.sf.cglib.proxy.Enhancer;
import _50_cglib_annotation.HelloSpeaker;

public class ClientStart {
    public static void main(String[] args){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(HelloSpeaker.class);
        enhancer.setCallback(new TargetInterceptor());
        HelloSpeaker targetObject2=(HelloSpeaker)enhancer.create();
        targetObject2.hello("Justin");
        targetObject2.hello2("Justin");
    }
}
