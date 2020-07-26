package leetCode;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author hw
 * @version on 2020/3/8
 */
public class _6_Convert3 {
    public String convert(String s, int numRows) {

        if(s.length() <= numRows || numRows < 2){
            return s;
        }

        char[] arr = s.toCharArray();
        int group = 2*(numRows - 1);

        int[] row = new int[group];
        for (int r = 0; r < row.length; r++) {
            if(r < numRows){
                row[r] = r;
            }
            if(r >= numRows){
                row[r] = 2 * numRows - r -2;
            }
        }

        int[] col = new int[group];
        for (int c = 0, i =1; c < col.length; c++) {
            if(c < numRows){
                col[c] = (c/group) * (group - 1);
            }
            if(c >= numRows){
                col[c] = (c/group) * (group - 1) + (i++);
            }
        }

        int[][] point = new int[arr.length][2];
        Set<Point> set = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            point[i][0] = row[i%group];
            point[i][1] = col[i%group] + (numRows - 1) * (i/group);
            set.add(new Point(point[i][0], point[i][1], arr[i]));
        }

        StringBuilder sb = new StringBuilder();
        for (Point value : set) {
            sb.append(value.ch);
        }

        return sb.toString();
    }
    class Point implements Comparable{
        int x;
        int y;
        char ch;

        public Point(int x, int y, char ch) {
            this.x = x;
            this.y = y;
            this.ch = ch;
        }

        @Override
        public int compareTo(Object o) {
            if(o == null ||! (o instanceof Point)) {
                throw new RuntimeException();
            }
            Point p1 = (Point)o;
            if(this.x < p1.x){
                return -1;
            }
            if(this.x > p1.x){
                return 1;
            }
            if(this.y < p1.y){
                return -1;
            }
            return 1;
        }
    }

    public static void main(String[] args) {
        String s1 = "LEETCODEISHIRING";
        int numRows = 3;

        System.out.println(new _6_Convert3().convert(s1, numRows));
        //输出: "LCIRETOESIIGEDHN"

        numRows = 4;

        System.out.println(new _6_Convert3().convert(s1, numRows));
        //输出: "LDREOEIIECIHNTSG"

        String space = "ABCD";
        numRows = 2;
        System.out.println(new _6_Convert3().convert(space, numRows));

    }
}
