package nio._3.filechannel;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * 文件中的nio通道
 * @author hw
 * @version on 2020/4/21
 */
public class FileChannelDemo {

    @Test
    public void main() throws IOException {

        //read
        RandomAccessFile aFile  = new RandomAccessFile("./src/main/java/nio/pw.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = inChannel.read(buf);//返回实际读取到的字节数
        System.out.println(new String(buf.array(),"UTF-8"));
        inChannel.close();

        //write
        RandomAccessFile bFile  = new RandomAccessFile("./src/main/java/nio/nio-empty.txt", "rw");
        FileChannel outChannel = bFile.getChannel();
        String newData = "New String to write to file..." + System.currentTimeMillis();

        ByteBuffer bufWrite = ByteBuffer.allocate(48);
        bufWrite.clear();

        bufWrite.put(newData.getBytes());

        bufWrite.flip();
        while(bufWrite.hasRemaining()) {
            outChannel.write(bufWrite);
        }

        //outChannel.close();

        //other
        long pos  = inChannel.position();//get position
        inChannel.position(pos +123);//set position
        long fileSize = inChannel.size();//size
        inChannel.truncate(1024);//截断
        inChannel.force(true);//flushes all unwritten data from the channel to the disk.
    }

    public static void main(String[] args) throws IOException {

        //1.通过本地IO的方式来获取通道
        FileInputStream fileInputStream = new FileInputStream("1.jpg");
        FileChannel inChannel = fileInputStream.getChannel();

        //2.jdk1.7后通过静态方法.open()获取通道
        FileChannel outChannel = FileChannel.open(Paths.get("2.png"));

        try{
            //分配指定大小的缓存区
            ByteBuffer buf = ByteBuffer.allocate(1024);

            while (inChannel.read(buf) != -1){
                buf.flip();

                outChannel.write(buf);
                buf.clear();
            }
        }catch (IOException ignore){}
    }

    /**
     * 内存映射文件的方式实现文件复制的功能(直接操作缓冲区)
     */
    @Test
    public void testTransfer() throws IOException{

        FileChannel fromChannel = FileChannel.open(Paths.get("1.png"), StandardOpenOption.READ);
        FileChannel toChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE,
                StandardOpenOption.READ);//注意这里还有个read模式

        //以下二选一：
        //transfer from a FileChannel into some other channel
        fromChannel.transferTo(0, fromChannel.size(), toChannel);
        //transfers data from a source channel into the FileChannel
        toChannel.transferFrom(fromChannel, 0, fromChannel.size());

        fromChannel.close();
        toChannel.close();
    }

}
