package nio;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @author hw
 * @version on 2020/4/22
 */
public class BufferDemo {

    /**
     * little 4-step process:
     * Write data into the Buffer
     * Call buffer.flip()
     * Read data out of the Buffer
     * Call buffer.clear() or buffer.compact()
     */
    @Test
    public void testUsage() throws IOException {
        RandomAccessFile file = new RandomAccessFile("./src/main/java/nio/usage0.txt", "rw");
        FileChannel inChannel = file.getChannel();

        //create buffer with capacity of 48 bytes
        ByteBuffer buffer = ByteBuffer.allocate(1024);//1k
        int bufRead = inChannel.read(buffer);//read into buffer.

        while (bufRead != -1) {
            buffer.flip();

            while (buffer.hasRemaining()) {
                //消费
                System.out.println((char) buffer.get());
            }

            buffer.clear();
            bufRead = inChannel.read(buffer);
        }
        file.close();

    }

    @Test
    public void testUsage2() throws IOException {

        RandomAccessFile file = new RandomAccessFile("./src/main/java/nio/usage.txt", "rw");
        FileChannel inChannel = file.getChannel();

        ByteBuffer buffer = ByteBuffer.allocate(1024);//1k
        //int bufRead ;//read into buffer.
        ArrayList<Byte> bytes = new ArrayList<>();



        while (inChannel.read(buffer) != -1) {
            buffer.flip();

            Charset cs1 = Charset.forName("UTF-8");
            CharsetDecoder cd = cs1.newDecoder();
            CharBuffer charBuffer = cd.decode(buffer);

            charBuffer.flip();

            while (buffer.hasRemaining()) {
                byte by =  buffer.get();
                bytes.add(by);
                System.out.print((char) by);
            }

            buffer.clear();
        }

        System.out.println("--------");



        //System.out.println(new String(charBuffer.array()));


        file.close();

    }

    /**
     * ByteBuffer、  MappedByteBuffer
     * CharBuffer、  * ShortBuffer
     * IntBuffer
     * DoubleBuffer、FloatBuffer
     * LongBuffer
     */
    @Test
    public void testBufferTypes() throws IOException {
        //1.必须给定初始化容量capacity
        ByteBuffer buf = ByteBuffer.allocate(48);

        //2.Writing Data to a Buffer
        //a.from a Channel into a Buffer

        RandomAccessFile file = new RandomAccessFile("pw.txt", "rw");
        FileChannel inChannel = file.getChannel();
        int bytesRead = inChannel.read(buf); //read into buffer.
        //The number of bytes read,
        // possibly zero,or <tt>-1</tt> if the channel has reached end-of-stream

        //b.Write data into the Buffer yourself
        buf.put("章".getBytes());

        //3.flip()切换buffer从写模式到读模式
        //sets the position back to 0, and sets the limit to where position just was.
        buf.flip();

        //4.Reading Data from a Buffer
        int bytesWritten = inChannel.write(buf);//read from buffer into channel.
        byte aByte = buf.get();
    }

    @Test
    public void testBufferApi() {

        CharBuffer buffer = CharBuffer.allocate(49);

        //sets the position back to 0, so you can reread all the data in the buffer.
        buffer.rewind();


        //Once you are done reading data out of the Buffer you have to make the Buffer ready for writing again.
        //position is set back to 0 and the limit to capacity.
        //the Buffer is cleared. The data in the Buffer is not cleared.
        buffer.clear();
        //If there is still unread data in the Buffer, and you want to read it later,
        // but you need to do some writing first, call compact() instead of clear().
        //compact() copies all unread data to the beginning of the Buffer.
        // Then it sets position to right after the last unread element.
        buffer.compact();


        //You can mark a given position in a Buffer.
        buffer.mark();
        //You can then later reset the position back to the marked position.
        buffer.reset();


        //It is possible to compare two buffers using equals() and compareTo().
        //equals():
        //1.They are of the same type (byte, char, int etc.)
        //2.They have the same amount of remaining bytes, chars etc. in the buffer.
        //3.All remaining bytes, chars etc. are equal.
        //compareTo():
        //1.The first element which is equal to the corresponding element in the other buffer, is smaller than that in the other buffer.
        //2.All elements are equal, but the first buffer runs out of elements before the second buffer does (it has fewer elements).
    }

    //合并读取（Scatter）与分开写入（Gather）
    @Test
    public void testScatter() throws IOException {

        FileChannel channel = FileChannel.open(Paths.get("./src/main/java/nio/pw.txt"));

        ByteBuffer head = ByteBuffer.allocate(20);
        ByteBuffer body = ByteBuffer.allocate(1024);

        ByteBuffer[] bufs = {head, body};
        channel.read(bufs);//读取
        //channel.write(bufs);//写入

        for (ByteBuffer byteBuffer : bufs) {
            byteBuffer.flip();
        }

        System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
        System.out.println("--------------");
        System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

    }

    @Test
    public void testCharset() throws IOException {
        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();
        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("全世界都在说中国话，孔夫子的话越来越国际化");
        cBuf.flip();

        ByteBuffer bBuf = ce.encode(cBuf);

        for (int i = 0; i < 12; i++) {
            System.out.println(bBuf.get());
        }

        //解码
        bBuf.flip();
    }

    @Test//直接字节缓冲区
    public void testMappedByteBuffer() throws Exception {
        int length = 0x800_0000; // 134217728 = 134 * 10^6 = 134M
        // 为了以可读可写的方式打开文件，这里使用RandomAccessFile来创建文件。
        FileChannel fc = new RandomAccessFile("./src/main/java/nio/write.txt", "rw").getChannel();
        //注意，文件通道的可读可写要建立在文件流本身可读写的基础之上

        //直接字节缓冲区
        MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, length);
        //写128MB的内容 'x'
        for (int i = 0; i < length; i++) {
            out.put((byte) 'x');
        }
        System.out.println("Finished writing");
        //读取文件中间6个字节内容
        for (int i = length / 2; i < length / 2 + 6; i++) {
            System.out.print((char) out.get(i));
        }
        fc.close();
    }
}
