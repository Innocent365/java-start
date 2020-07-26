package nio._3.filechannel;

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 *
 * java7中新增了AsynchronousFileChannel作为nio的一部分
 * @author hw
 * @version on 2020/4/25
 */
public class AsynchronousFileChannelDemo {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data/test.xml");

        AsynchronousFileChannel fileChannel =
                AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        /**
         * 读取/写入数据（Reading/Writing Data）
         */
        //a.通过Future读取数据（Reading Data Via a Future）
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        Future<Integer> operation = fileChannel.read(buffer, 0);
        //read()方法会立刻返回，即使读操作没有完成。我们可以通过isDone()方法检查操作是否完成。

        while(!operation.isDone());

        buffer.flip();
        byte[] data = new byte[buffer.limit()];
        buffer.get(data);
        System.out.println(new String(data));
        buffer.clear();

        //b.通过CompletionHandler读取数据(Reading Data Via a CompletionHandler）
        fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override//一旦读取完成，将会触发CompletionHandler的completed()方法，并传入一个Integer和ByteBuffer。
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result = " + result);

                attachment.flip();
                byte[] data = new byte[attachment.limit()];
                attachment.get(data);
                System.out.println(new String(data));
                attachment.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });
    }


}
