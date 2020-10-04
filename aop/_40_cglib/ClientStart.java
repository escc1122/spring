package _40_cglib;


import net.sf.cglib.proxy.Enhancer;

public class ClientStart {
    public static void main(String[] args){
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(HelloSpeaker.class);
        enhancer.setCallback(new TargetInterceptor());
        HelloSpeaker targetObject2=(HelloSpeaker)enhancer.create();
//        System.out.println(targetObject2);
        targetObject2.hello("Justin");
    }
}
