package niuke.testEnvironment;

import java.util.Scanner;

/**
 * @author hw
 * @version on 2020/6/23
 */
public class AC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String[] s = sc.nextLine().split(" ");
            int sum = 0;
            for (int i = 0; i < s.length; i++) {
                sum = sum + Integer.parseInt(s[i]);
            }
            System.out.println(sum);
        }

    }
}
