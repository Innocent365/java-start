package _1.base;


import org.junit.Test;

public class TestHex {
    final char[] BASE62 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();


    public static void main(String[] args) {


    }

    @Test
    public void $test(){
        byte[] input = "hello".getBytes();
        char[] chars = new char[input.length];
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + "   |||  ");
            chars[i] = BASE62[((input[i] & 0xFF) % BASE62.length)];
            System.out.println(chars[i]);
        }
    }
}
