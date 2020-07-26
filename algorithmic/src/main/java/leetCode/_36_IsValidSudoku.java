package leetCode;

import leetCode.assist.Point;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author hw
 * @version on 2020/3/23
 */
@SuppressWarnings("All")
public class _36_IsValidSudoku {

    /**
     *  优化 * 2
     * @param board
     */
    public boolean isValidSudoku4(char[][] board) {
        List<Character>[] rows = new ArrayList[9];
        List<Character>[] cols  = new ArrayList[9];

        List<Character>[] boxes = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new ArrayList<>();
            cols[i] = new ArrayList<>();
            boxes[i] = new ArrayList();
        }

        for (int i=0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rows[i].contains(board[i][j])) {
                        return false;
                    }
                    rows[i].add(board[i][j]);

                    if (cols[i].contains(board[i][j])) {
                        return false;
                    }
                    cols[i].add(board[i][j]);

                    //九个独立小方块归类
                    int index = (i/3) * 3 + j/3;
                    if(boxes[index].contains(board[i][j])){
                        return false;
                    }
                    boxes[index].add(board[i][j]);
                }
            }
        }
        return true;
    }

    /**
     * copy 优化
     * @param board
     */
    public boolean isValidSudoku3(char[][] board) {
        List<Character> rows;
        List<Character> cols;

        List<Character>[] boxes = new ArrayList[9];
        for (int i = 0; i < 9; i++) {
            boxes[i] = new ArrayList();
        }

        for (int i=0; i < 9; i++) {
            rows = new ArrayList<>();
            cols = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) {
                        return false;
                    }
                    rows.add(board[i][j]);

                    if (cols.contains(board[j][i])) {
                        return false;
                    }
                    cols.add(board[j][i]);

                    //九个独立小方块归类
                    int index = (i/3) * 3 + j/3;
                    if(boxes[index].contains(board[i][j])){
                        return false;
                    }
                    boxes[index].add(board[i][j]);
                }
            }
        }
        return true;
    }

    /**
     * 终极优化
     * @param board
     * @return
     */
    public boolean isValidSudoku2(char[][] board) {
        List<Character> rows;
        List<Character> cols;

        for (int i=0; i < 9; i++) {
            rows = new ArrayList<>();
            cols = new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (rows.contains(board[i][j])) {
                        return false;
                    }
                    rows.add(board[i][j]);
                }
                if(board[j][i] != '.'){
                    if (cols.contains(board[j][i])) {
                        return false;
                    }
                    cols.add(board[j][i]);
                }

            }
        }

        List<Character> cells;
        for (int j = 0; j < 9; j+=3) {
            for (int k = 0; k < 9; k+=3) {
                cells = new ArrayList<>();
                for (int row = j; row < j + 3; row++) {
                    for (int col = k; col < k + 3; col++) {
                        if (board[row][col] != '.') {
                            if (cells.contains(board[row][col])) {
                                return false;
                            }
                            cells.add(board[row][col]);
                        }
                    }
                }
            }
        }
        return true;
    }

    /**
     * 原始递归办法，重复检查
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {
        return check(board, 0, 0);
    }

    public boolean check(char[][] matrix, int startX, int startY) {
        if (startX == startY && startX == 8) {
            return true;
        }

        if (matrix[startX][startY] != '.') {
            Point point = new Point(startX, startY, matrix[startX][startY]);
            if(!valid(matrix, point)){
                return false;
            }
        }

        if (startY == 8) {
            return check(matrix, startX + 1, 0);
        }
        return check(matrix, startX, startY + 1);
    }

    public boolean valid(char[][] board, Point p) {
        for (int i = 0; i < 9; i++) {
            if (i == p.x) continue;
            if (board[i][p.y] == p.val) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (j == p.y) continue;
            if (board[p.x][j] == p.val) {
                return false;
            }
        }
        int minX = p.x - p.x % 3;
        int minY = p.y - p.y % 3;

        for (int i = minX; i < minX + 3; i++) {
            for (int j = minY; j < minY + 3; j++) {
                if(i == p.x && j == p.y) continue;
                if (board[i][j] == p.val) {
                    return false;
                }
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
        System.out.println(new _36_IsValidSudoku().isValidSudoku4(board));

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
