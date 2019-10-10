package space.tulin.nio;



import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIOFileChannelDemo {
    
    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("data/nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);

        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();     // make bufferChar ready for read，让缓冲区反向，开始读取之前写入的

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();    // make bufferChar ready for writing，读完之后清空缓冲区，接着去写入
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }

    @Test
    public void test() throws IOException {
        RandomAccessFile fromFile = new RandomAccessFile("data.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();

        RandomAccessFile targetFile = new RandomAccessFile("targrt.txt", "rw");
        FileChannel targetChannel = targetFile.getChannel();

        long position = 0;
        long count = fromChannel.size();
        //transferFrom()方法可以将数据从源通道传输到FileChannel中
        targetChannel.transferFrom(fromChannel,position, count);
        //方法的输入参数position表示从position处开始向目标文件写入数据，count表示最多传输的字节数。如果源通道的剩余空间小于 count 个字节，则所传输的字节数要小于请求的字节数。
        //此外要注意，在SocketChannel的实现中，SocketChannel只会传输此刻准备好的数据（可能不足count字节）。因此，SocketChannel可能不会将请求的所有数据(count个字节)全部传输到FileChannel中。

        //transferTo()方法将数据从FileChannel传输到其他的channel中。
        fromChannel.transferTo(position, count, targetChannel);
    }


    //使用NIO进行快速的文件拷贝
    @Test
    public void fileCopy(File in, File out )
            throws IOException
    {
        FileChannel inChannel = new FileInputStream( in ).getChannel();
        FileChannel outChannel = new FileOutputStream( out ).getChannel();
        try
        {
//          inChannel.transferTo(0, inChannel.size(), outChannel);      // original -- apparently has trouble copying large files on Windows

            // magic number for Windows, 64Mb - 32Kb)
            int maxCount = (64 * 1024 * 1024) - (32 * 1024);
            long size = inChannel.size();
            long position = 0;
            while ( position < size )
            {
                position += inChannel.transferTo( position, maxCount, outChannel );
            }
        }
        finally
        {
            if ( inChannel != null )
            {
                inChannel.close();
            }
            if ( outChannel != null )
            {
                outChannel.close();
            }
        }
    }
}

