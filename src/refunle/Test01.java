package refunle;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test01 {
    /*2.反射绕过ArrayList集合泛型检查去存储数据.*/
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Map<Object, Object> map=new HashMap<>();
        map.put("name","tom");
        map.put("age",20);
        map.put("gender","男");
        Student student=new Student();
        Object obj=new Object();
        fill(map,student);
    }
    public static void fill(Map<Object, Object> map, Object obj) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        /// 方法体由大家完成( 使用反射)
        Student student= (Student) obj;
        Class<? extends Map> mapClass = map.getClass();
        Method get = mapClass.getMethod("get", Object.class);
        student.setName((String) get.invoke(map, "name"));
        student.setAge((Integer) get.invoke(map,"age"));
        student.setGender((String) get.invoke(map,"gender"));
        System.out.println(student);

       /* Class<?> classObj = obj.getClass();
        Class<? extends Map> mapClass = map.getClass();
        Method put = mapClass.getDeclaredMethod("put", Object.class, Object.class);
        put.setAccessible(true);
        put.invoke(map,"name","tom");
        put.invoke(map,"age",20);
        put.invoke(map,"gender","男");
        System.out.println(map);*/
    }
}
