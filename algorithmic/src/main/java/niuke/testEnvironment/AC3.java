package niuke.testEnvironment;

import java.util.Scanner;

/**
 * @author hw
 * @version on 2020/6/23
 */
public class AC3 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int lineNumber = s.nextInt();
        for (int i = 0; i < lineNumber; i++) {
            int a = s.nextInt();
            int b = s.nextInt();
            System.out.println(a + b);
        }
    }
}
