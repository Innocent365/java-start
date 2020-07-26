package socket._5.readlockproblem;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author hw
 * @version on 2020/4/16
 */
public class TCPEchoClient {
    public static void main(String[] args) throws IOException {

        args = new String[]{"localhost", "shit", "49"};
        //if ((args.length < 2) || (args.length > 3))  // Test for correct # of args
        //    throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");

        String server = args[0];       // Server name or IP address
        // Convert argument String to bytes using the default character encoding
        byte[] data = args[1].getBytes();

        int servPort = (args.length == 3) ? Integer.parseInt(args[2]) : 7;

        // Create socket that is connected to server on specified port
        Socket socket = new Socket(server, servPort);
        System.out.println("Connected to server...sending echo string");

        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();

        out.write(data);  // Send the encoded string to the server

        /**
         * 为防止对方读取时不知道何时结束，此处调用 shutdownOutput，
         *  在对方读到最后，可以读到-1
         * 若关闭任何一个stream，都会直接导致socket的关闭，也就无法进行后面回执的发送了。
         * 会同时终止两个方向（输入和输出）的数据流，所以这里要用socket.shutdownOutput()
         */
        socket.shutdownOutput();
        /** 之后不能再用shutdown的流*/
        //out.write("sd".getBytes());//Cannot send after socket shutdown: socket write error

        // Receive the same string back from the server
        int totalBytesRcvd = 0;  // Total bytes received so far
        int bytesRcvd;           // Bytes received in last read

        //这里的前提是已经知道了要从服务器端接收的数据的大小
        //while (totalBytesRcvd < data.length) {
        //    if ((bytesRcvd = in.read(data, totalBytesRcvd,data.length - totalBytesRcvd)) == -1)
        //        throw new SocketException("Connection closed prematurely");
        //    totalBytesRcvd += bytesRcvd;
        //}  // data array is full

        int i = in.read();
        while (i != -1) {
            data[totalBytesRcvd] = (byte) i;
            totalBytesRcvd++;
            i = in.read();
        }

        //while((bytesRcvd = in.read())!= -1){
        //    data[totalBytesRcvd] = (byte)bytesRcvd;
        //    totalBytesRcvd++;
        //}

        System.out.println("Received: " + new String(data));

        socket.close();  // Close the socket and its streams
    }
}
