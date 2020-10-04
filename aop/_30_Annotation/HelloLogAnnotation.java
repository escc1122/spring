package _30_Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
//動態代理必須要在runtime
@Retention(RetentionPolicy.RUNTIME)
public @interface HelloLogAnnotation {
    boolean beforeLog() default false;
    boolean afterLog() default false;
}
