package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hw
 * @version on 2020/3/8
 */
public class _6_Convert_copy {
    public String convert(String s, int numRows) {
        if(numRows < 2) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) {
                flag = - flag;
            }
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s1 = "LEETCODEISHIRING";
        int numRows = 3;

        System.out.println(new _6_Convert_copy().convert(s1, numRows));
        //输出: "LCIRETOESIIGEDHN"

        numRows = 4;

        System.out.println(new _6_Convert_copy().convert(s1, numRows));
        //输出: "LDREOEIIECIHNTSG"

        String space = "ABCD";
        numRows = 2;
        System.out.println(new _6_Convert_copy().convert(space, numRows));

    }
}
