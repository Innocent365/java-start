package javaSE.ioStream._6.bufferChar;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 向文件末尾添加内容
 * @author hw
 * @version on 2019/4/26
 */
public class BufferedWriterDemo {
    public static void main(String[] args) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("filename", true));
            out.write("aString");
        } catch (IOException e) {
            // error processing code
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
