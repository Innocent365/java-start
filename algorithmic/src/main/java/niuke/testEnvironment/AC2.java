package niuke.testEnvironment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AC2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine().trim();

        String[] items = sc.nextLine().split(" ");
        Arrays.sort(items, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int length = Math.min(o1.length(), o2.length());
                for (int i = 0; i < length; i++) {
                    if(o1.charAt(i) == o2.charAt(i)){
                        continue;
                    }else if(o1.charAt(i) > o2.charAt(i)){
                        return 1;
                    }else {
                        return -1;
                    }
                }

                return 0;
            }
        });

        for (int i = 0; i < items.length; i++) {
            System.out.print(items[i] + (i < items.length -1 ? " " : ""));
        }

    }
}
