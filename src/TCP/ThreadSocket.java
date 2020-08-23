package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

public class ThreadSocket implements Runnable{
    private ServerSocket serverSocket;
    private Socket socket;

    public ThreadSocket(ServerSocket serverSocket) {
        this.serverSocket=serverSocket;
    }

    public ThreadSocket(Socket accept) {
        this.socket=accept;
    }

    @Override
    public void run() {
        while (true) {
            Socket accept = socket;
            BufferedOutputStream bufferedOutputStream = null;
            try {
                String fileName = UUID.randomUUID().toString();
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("src/TCP/file/" + fileName + ".jpg"));
                BufferedInputStream bufferedInputStream = new BufferedInputStream(accept.getInputStream());
                int read;
                while ((read = bufferedInputStream.read()) != -1) {
                    bufferedOutputStream.write(read);
                }

                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                writer.write("success");
                writer.newLine();
                writer.flush();
                //bufferedOutputStream.close();
                //accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (accept!=null){
                    try {
                        accept.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }
}
