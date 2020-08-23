package testanno;

import java.io.File;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;

public class ContainerScanner {

    private static Map<Object,Object> beans = new HashMap<>();
    public static void main(String[] args) throws Exception {
        File srcfile = new File("src/testanno");
        File[] files = srcfile.listFiles();
        for (File file : files) {
            String filepath  = file.getName().split("\\.")[0];
            filepath = "testanno."+filepath;
            System.out.println(filepath);
            Class<?> aClass = Class.forName(filepath);
            if(aClass.isAnnotationPresent(Container.class)){
                //拿到注解的属性
                Container annotation = aClass.getAnnotation(Container.class);//获取指定注解对象
                String key = annotation.value();
                Object o = aClass.getConstructor().newInstance();
                beans.put(key,o );
            }
        }

        System.out.println(beans);
    }


}
