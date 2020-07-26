package leetCode;

/**
 * @author hw
 * @version on 2020/3/8
 */
public class _6_Convert2 {
    public String convert(String s, int numRows) {

        //一个类L型包含的个数
        //numRows + (numRows - 2) = 2 * numRows - 2 = 2(numRows - 1);
        //2(numRows - 1)
        if(s.length() <= numRows || numRows < 2){
            return s;
        }

        char[] arr = s.toCharArray();

        int matrix_rows = 2*(numRows - 1);
        int matrix_cols = s.length()/matrix_rows + ((s.length()%matrix_rows==0)?0:1);

        char[][] matrix = new char[matrix_rows][matrix_cols];
        for (int r = 0; r < matrix_rows; r++) {
            for (int c = 0; c < matrix_cols; c++) {
                if(c*matrix_rows + r > arr.length - 1){
                    break;
                }
                matrix[r][c] = arr[c*matrix_rows + r];
            }
        }

        char[][] newMatrix = new char[numRows][matrix_cols*(numRows - 1)];
        for (int c = 0; c < matrix_cols; c++) {
            for (int r = 0; r < numRows; r++) {
                newMatrix[r][(numRows - 1) * c] = matrix[r][c];
            }
            for (int r = numRows; r < matrix_rows; r++) {
                newMatrix[2*numRows - r - 2][(numRows - 1) * c + (r-numRows+1)] = matrix[r][c];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < numRows; r++) {
            for (int c = 0; c < newMatrix[0].length; c++) {
                if('\u0000' != newMatrix[r][c]){
                    sb.append(newMatrix[r][c]);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s1 = "LEETCODEISHIRING";
        int numRows = 3;

        System.out.println(new _6_Convert2().convert(s1, numRows));
        //输出: "LCIRETOESIIGEDHN"

        numRows = 4;

        System.out.println(new _6_Convert2().convert(s1, numRows));
        //输出: "LDREOEIIECIHNTSG"

        String space = "ABCD";
        numRows = 2;
        System.out.println(new _6_Convert2().convert(space, numRows));

    }
}
