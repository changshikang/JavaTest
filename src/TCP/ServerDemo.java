package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServerDemo {
    /**- 案例需求
     客户端：数据来自于本地文件，接收服务器反馈
     服务器：接收到的数据写入本地文件，给出反馈
     - 案例分析
     - 创建客户端对象，创建输入流对象指向文件，每读一次数据就给服务器输出一次数据，输出结束后使用shutdownOutput()方法告知服务端传输结束
     - 创建服务器对象，创建输出流对象指向文件，每接受一次数据就使用输出流输出到文件中，传输结束后。使用输出流给客户端反馈信息
     - 客户端接受服务端的回馈信息*/
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);

        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(
                3,//核心线程数量
                10,//线程池总数
                 60,//临时线程空闲时间
                TimeUnit.SECONDS,//临时线程空闲时间单位
                new ArrayBlockingQueue<>(5),
        Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );

        while (true){
            Socket accept = serverSocket.accept();
            ThreadSocket threadSocket = new ThreadSocket(accept);
            poolExecutor.submit(threadSocket);
        }
       // ThreadSocket threadSocket=new ThreadSocket(serverSocket);

       // threadSocket.run();

       /* while (true){
            Socket accept = serverSocket.accept();
            String fileName= UUID.randomUUID().toString();
            BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream("src/TCP/file/"+fileName+".jpg"));
            BufferedInputStream bufferedInputStream=new BufferedInputStream(accept.getInputStream());
            int read ;
            while ((read=bufferedInputStream.read())!=-1){
                bufferedOutputStream.write(read);
            }

            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            writer.write("success");
            writer.newLine();
            writer.flush();
            bufferedOutputStream.close();
            accept.close();
        }*/



    }
}
