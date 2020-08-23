package test1;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class BeanUnity {
    static HashMap<Object,Object> map=new HashMap<>();
    static {
        try {
            InputStream is = ClassLoader.getSystemResourceAsStream("bean.properties");
            Properties properties=new Properties();
            properties.load(is);
            Set<Map.Entry<Object, Object>> entries = properties.entrySet();
            entries.forEach(s->{
                Object value = s.getValue();
                Class<?> aClass = null;
                try {
                    aClass = Class.forName((String) value);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                Object o=null;
                try {
                    o= aClass.getConstructor().newInstance();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                map.put(s.getKey(),o);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    static HashMap<Object,Object> map=new HashMap<>();
//
//    static {
//        try {
//            InputStream is = ClassLoader.getSystemResourceAsStream("bean.properties");
//            Properties properties = new Properties();
//            properties.load(is);
//            Set<Map.Entry<Object, Object>> entries = properties.entrySet();
//            for (Map.Entry<Object, Object> entry : entries) {
//                Class<?> aClass = Class.forName((String) entry.getValue());
//                Object o = aClass.getConstructor().newInstance();
//                map.put(entry.getKey(), o);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//    }

    public static Object getBean(String name){
        return map.get(name);
    }

}
