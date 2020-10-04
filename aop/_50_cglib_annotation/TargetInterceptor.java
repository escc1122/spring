package _50_cglib_annotation;

import _30_Annotation.HelloLogAnnotation;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TargetInterceptor implements MethodInterceptor {
    /**
     * 重写方法拦截在方法前和方法后加入业务
     * Object obj为目标对象
     * Method method为目标方法
     * Object[] params 为参数，
     * MethodProxy proxy CGlib方法代理对象
     */
    public Object intercept(Object obj, Method method, Object[] params,
                            MethodProxy proxy) throws Throwable {
        boolean methodHasAnno = method.isAnnotationPresent(HelloLogAnnotation.class);
        boolean beforeLog = false;
        boolean afterLog = false;

        if (methodHasAnno){
            HelloLogAnnotation helloLog = method.getAnnotation(HelloLogAnnotation.class);
            beforeLog = helloLog.beforeLog();
            afterLog = helloLog.afterLog();
        }
        if (beforeLog){
            log("method starts..." + method);
        }
//        method.getAnnotation(HelloLogAnnotation.class);
        Object result = proxy.invokeSuper(obj, params);
        if (afterLog){
            log("method ends..." + method);
        }
        return result;
    }
    private void log(String msg) {
        System.out.println("system log : " + msg);
    }
}
