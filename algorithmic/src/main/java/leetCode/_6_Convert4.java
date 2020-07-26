package leetCode;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author hw
 * @version on 2020/3/8
 */
@SuppressWarnings("ALL")
public class _6_Convert4 {
    public String convert(String s, int numRows) {
        if(s.length() <= numRows || numRows < 2){
            return s;
        }

        //一个类L型包含的个数
        //numRows + (numRows - 2)= 2(numRows - 1)
        int group = 2*(numRows - 1);
        int cols = (s.length()/group + ((s.length()%group==0)?0:1))*(numRows - 1);

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

        char[][] matrix = new char[numRows][cols];
        for (int i = 0; i < s.length(); i++) {
            int x = row[i%group];
            int y = col[i%group] + (numRows - 1) * (i/group);
            matrix[x][y] = s.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < cols; c++) {
                if('\u0000' != matrix[r][c]){
                    sb.append(matrix[r][c]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "LEETCODEISHIRING";
        int numRows = 3;

        System.out.println(new _6_Convert4().convert(s1, numRows));
        //输出: "LCIRETOESIIGEDHN"

        numRows = 4;

        System.out.println(new _6_Convert4().convert(s1, numRows));
        //输出: "LDREOEIIECIHNTSG"

        String space = "ABCD";
        numRows = 2;
        System.out.println(new _6_Convert4().convert(space, numRows));

    }
}
