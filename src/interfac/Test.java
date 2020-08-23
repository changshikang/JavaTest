package interfac;

import logfj.Log4JUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    private static final Logger LOGGER=LoggerFactory.getLogger(Test.class);
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        Class aClass = Class.forName("interfac.InterfaceTest");
        Method[] methods = aClass.getMethods();
        InterfaceTest interfaceTest=new InterfaceTest();

        for (Method method : methods) {
            if (method.isAnnotationPresent(Anno1.class)){
                method.invoke(interfaceTest);

            }
        }
        LOGGER.info("INFO info");


    }
}
