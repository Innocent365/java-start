package io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * 新型tryResource会自动关闭吗？
 *
 */
public class TryResourceDemo {
    public static void main(String[] args) {
        try(FileInputStream input = new FileInputStream("file.txt");
            BufferedInputStream bufferedInput = new BufferedInputStream(input)
        ) {
            int data = bufferedInput.read();
            while(data != -1){
                System.out.print((char) data);
                data = bufferedInput.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
