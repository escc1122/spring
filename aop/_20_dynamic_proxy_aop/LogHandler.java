package _20_dynamic_proxy_aop;

import java.lang.reflect.*;

/**
 * java 內建動態代理 該物件需要繼承介面
 */
public class LogHandler implements InvocationHandler {

    private Object delegate;

    public Object bind(Object delegate) {
        this.delegate = delegate;
        return Proxy.newProxyInstance(
                delegate.getClass().getClassLoader(),
                delegate.getClass().getInterfaces(),
                this);
    }

    public Object invoke(Object proxy, Method method,
                         Object[] args) throws Throwable {
        Object result = null;

        try {
            log("method starts..." + method);

            result = method.invoke(delegate, args);

            log("method ends..." + method);
        } catch (Exception e){
            log(e.toString());
        }

        return result;
    }

    private void log(String msg) {
        System.out.println("system log : " + msg);
    }
}
