package 结构型.decoratePattern.redefineIO;




import org.junit.Test;

import java.io.*;

public class FileInputStreamTest {
    public static void main(String[] args) {
        String fileName = "testLowerCharFile.txt";

        try {
            FileInputStream lowerCaseInputStream = new LowerCaseInputStream(fileName);

            int i;
            while ((i = lowerCaseInputStream.read()) > 0) {
                System.out.println((char) i);
            }

            FilterInputStream lineNumberInputStream = new LineNumberInputStream(lowerCaseInputStream);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        try {
            FileOutputStream fos = new FileOutputStream("");
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            PrintWriter pw = new PrintWriter(bos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
