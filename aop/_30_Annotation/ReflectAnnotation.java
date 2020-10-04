package _30_Annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;

public class ReflectAnnotation implements InvocationHandler{
    private Object delegate;
    private HashMap<String,HashMap<String,Boolean>> annotationValue = new HashMap<String, HashMap<String, Boolean>>();
    public Object bind(Object delegate) {
        this.delegate = delegate;
        initAnnotation(delegate);
        return Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                this);
    }

    public void initAnnotation(Object o){

        String className = o.getClass().getName();
        Method[] methods = o.getClass().getDeclaredMethods();
        for(Method method : methods){
            //判斷屬性是否標註了@ProductAnnotation註解
            boolean methodHasAnno = method.isAnnotationPresent(HelloLogAnnotation.class);
            if(methodHasAnno){
                //獲取@ProductAnnotation註解
                HelloLogAnnotation helloLog = method.getAnnotation(HelloLogAnnotation.class);
                //獲取@ProductAnnotation註解 引數值
                boolean beforeLog = helloLog.beforeLog();
                boolean afterLog = helloLog.afterLog();
                HashMap<String,Boolean> ann = new HashMap<String, Boolean>();
                ann.put("beforeLog",beforeLog);
                ann.put("afterLog",afterLog);
                annotationValue.put(method.getName(),ann);
            }
        }
    }

    public Object invoke(Object proxy, Method method,
                         Object[] args) throws Throwable {
        Object result = null;
        boolean beforeLog = false;
        boolean afterLog = false;

        boolean hasAno = annotationValue.containsKey(method.getName());

        if (hasAno){
            beforeLog = annotationValue.get(method.getName()).get("beforeLog");
            afterLog = annotationValue.get(method.getName()).get("afterLog");
        }
        try {
            if (beforeLog){
                log("method starts..." + method);
            }

            result = method.invoke(delegate, args);

            if (afterLog){
                log("method ends..." + method);
            }

        } catch (Exception e){
            log(e.toString());
        }

        return result;
    }

    private void log(String msg) {
        System.out.println("system log : " + msg);
    }

}
