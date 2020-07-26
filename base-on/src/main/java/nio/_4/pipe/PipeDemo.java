package nio._4.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 *  2 个线程之间的单向数据连接：管道pipe
 * Java NIO Pipe is a one-way data connection between two threads.
 *
 * You write data to the sink channel.
 * This data can then be read from the source channel.
 *
 */
public class PipeDemo {
    public static void main(String[] args) throws IOException {
        /**
         * create
         */
        Pipe pipe = Pipe.open();

        /**
         * write
         */
        Pipe.SinkChannel sinkChannel = pipe.sink();

        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer buf = ByteBuffer.allocate(48);
        buf.clear();
        buf.put(newData.getBytes());

        buf.flip();

        while(buf.hasRemaining()) {
            sinkChannel.write(buf);
        }

        /**
         * Reading from a Pipe
         */
        Pipe.SourceChannel sourceChannel = pipe.source();
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int bytesRead = sourceChannel.read(buf);//返回的int值会告诉我们多少字节被读进了缓冲区。
    }
}
