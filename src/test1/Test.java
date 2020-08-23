package test1;

public class Test {
    public static void main(String[] args) {
        Teacher teacher = (Teacher) BeanUnity.getBean("Teacher");
        System.out.println(teacher);
    }
}
