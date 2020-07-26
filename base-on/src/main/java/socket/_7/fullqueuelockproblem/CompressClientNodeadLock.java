package socket._7.fullqueuelockproblem;

import java.io.*;
import java.net.Socket;

/**
 * @author hw
 * @version on 2020/4/17
 */
public class CompressClientNodeadLock {

    public static final int BUFSIZE = 256;

    public static void main(String[] args) throws IOException {
        String server = "localhost";
        int port = 55522;

        String fileName = "";

        final FileInputStream fileIn = new FileInputStream(fileName);
        FileOutputStream fileOut = new FileOutputStream(fileName + ".gz");

        final Socket socket = new Socket(server, port);

        Thread thread = new Thread(){
            @Override
            public void run() {
                try{
                    SendBytes(socket, fileIn);
                }catch (Exception ignored){}
            }
        };
        thread.start();


        InputStream sockIn = socket.getInputStream();
        int bytesRead;
        byte[] buffer = new byte[BUFSIZE];
        while ((bytesRead = sockIn.read()) != -1){
            fileOut.write(buffer, 0, bytesRead);
            System.out.print("R");
        }
        System.out.println();

        socket.close();
        fileIn.close();
        fileOut.close();
    }

    public static void SendBytes(Socket socket, InputStream fileIn) throws IOException {
        OutputStream sockOut = socket.getOutputStream();
        int bytesRead;

        byte[] buffer = new byte[BUFSIZE];
        while ((bytesRead = fileIn.read(buffer)) != -1) {
            sockOut.write(buffer, 0, bytesRead);
            System.out.print("W");
        }
        socket.shutdownOutput();
    }
}
