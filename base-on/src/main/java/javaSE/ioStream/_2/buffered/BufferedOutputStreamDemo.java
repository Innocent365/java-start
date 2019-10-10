package javaSE.ioStream._2.buffered;



import org.junit.Test;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 缓冲字节输出流
 */
public class BufferedOutputStreamDemo {

    @Test
    public void testStr2File(){
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fos = new FileOutputStream("bos.txt");
            bos = new BufferedOutputStream(fos);
            String str = "随便写点什么吧";
            byte[] data = str.getBytes();
            bos.write(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //将缓冲区中的数据强制性写出
            try {
                bos.flush();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeToFileZipFileContents(String zipFileName, String outputFileName)
            throws java.io.IOException {

        java.nio.charset.Charset charset = java.nio.charset.StandardCharsets.US_ASCII;
        java.nio.file.Path outputFilePath = java.nio.file.Paths.get(outputFileName);
        // Open zip file and create output file with
        // try-with-resources statement
        try (
                java.util.zip.ZipFile zf = new java.util.zip.ZipFile(zipFileName);
                java.io.BufferedWriter writer = java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
        ) {
            // Enumerate each entry
            for (java.util.Enumeration entries = zf.entries(); entries.hasMoreElements();) {
                // Get the entry name and write it to the output file
                String newLine = System.getProperty("line.separator");
                String zipEntryName =
                        ((java.util.zip.ZipEntry)entries.nextElement()).getName() +  newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        }
    }
}

/**
 *  try(资源)
 *
 * try资源 （try with resources） 句式是一个 try 句式，可以 try 一个或多个资源。
 * 资源必须在用完后 close 掉。使用try资源句式可以自动 close 资源。
 *
 * 任何实现了 java.lang.AutoCloseable 接口的类，
 * 都可以使用 try资源句式，自动 close。
 * Java代码  收藏代码
 * public interface java.io.Closeable extends java.lang.AutoCloseable
 *
 * 一句话：
 * 使用 try资源句式 用来自动 close 资源。而不用担心资源一直占用内存无法释放。
 */
