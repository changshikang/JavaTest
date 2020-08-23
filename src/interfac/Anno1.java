package interfac;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface Anno1 {
    int a() default 20;
    String str() default "string";
    int[] nums() default {1,2,3,4,5};

    public Season season() default Season.SUMMER;

    Class aClass() default Season.class;

}
