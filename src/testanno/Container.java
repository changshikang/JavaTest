package testanno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 注解作用: 使用者会被自动创建对象到容器中.
 * 存到容器的时候.需要一个唯一的键.(注解属性)
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Container {
    String value();
}
