package leetCode;

import leetCode.assist.Point;

import java.util.*;

/**
 * @author hw
 * @version on 2020/3/23
 */
@SuppressWarnings("All")
public class _36_IsValidSudoku2 {

    //创建一个静态内部类
    static class Point {
        int row;
        int column;
        char s;

        private Point(int row, int column, char s) {
            this.row = row;
            this.s = s;
            this.column = column;
        }


        @Override
        public boolean equals(Object o) {
            if (getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row || column == point.column || (point.row / 3 == row / 3 && point.column / 3 == column / 3);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s);
        }
    }
    public boolean isValidSudoku(char[][] board) {
        Set<Point> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                Point point = new Point(i, j, board[i][j]);
                if (!set.contains(point)) set.add(point);
                else return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        //System.out.println(new _36_IsValidSudoku().valid(board, new Point(6, 3,  '9')));

        board = new char[][]{
                {'8', '1', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '1', '.', '.', '.', '.', '6', '.'},
                {'1', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };//false
        System.out.println(new _36_IsValidSudoku2().isValidSudoku(board));

        board = new char[][]{
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        };//true

        //System.out.println(new _36_IsValidSudoku().isValidSudoku4(board));


        //char(3) != '3'

    }
}
