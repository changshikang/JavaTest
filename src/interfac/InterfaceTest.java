package interfac;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class InterfaceTest {
    @Test
    public void Str(){
        int a=10;
        int c=20;
        int i = Math.addExact(a, c);
        System.out.println(i);
        System.out.println("@Test 注解");
        //return "str";
    }
    @Before
    public void Str1(){
        System.out.println("@Before 一 注解");
        //return "str";
    }
    @Before
    public void Str3(){
        System.out.println("@Before 二 注解");
        //return "str";
    }
    @After
    public void Str2(){
        System.out.println("@After 一 注解");
        //return "str";
    }
    @After
    public void Str4(){
        System.out.println("@After 二 注解");
        //return "str";
    }
    @Anno1
    public void Test(){
        System.out.println("InterfaceTest test");
    }
    @Anno1
    public void Show(){
        System.out.println("InterfaceTest show");
    }
}
