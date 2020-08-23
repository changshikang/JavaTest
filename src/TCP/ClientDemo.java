package TCP;

import java.io.*;
import java.net.Socket;

public class ClientDemo {
    public static void main(String[] args) throws IOException {
        File file=new File("src/TCP/1578209871757.jpg");
        Socket socket=new Socket("127.0.0.1",8888);
        BufferedInputStream bufferedInputStream=new BufferedInputStream(new FileInputStream(file));

        BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(socket.getOutputStream());
        int r;
        while ((r=bufferedInputStream.read())!=-1){
            bufferedOutputStream.write(r);
        }
        bufferedOutputStream.flush();
        socket.shutdownOutput();

        BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String s;
        if ((s = reader.readLine())!=null){
            System.out.println(s);
        }

        socket.close();
        bufferedInputStream.close();

    }
}
