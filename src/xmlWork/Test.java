package xmlWork;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        MyThread myThread1=new MyThread();
        MyThread myThread2=new MyThread();
        myThread1.run();
        myThread2.run();
    }
}
class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}
