package leetCode;

import leetCode.assist.Point;

/**
 * 扩展： 求解数独，搜索算法。
 * 用循环代替递归
 * @author hw
 * @version on 2020/3/23
 */
@SuppressWarnings("ALL")
public class _37_SolveSudoku2 {
    public void solveSudoku(char[][] board) {
        //使用链表存储数据
        Point fake = new Point(-1, -1);
        Point point = fake;
        Point coord = new Point(0, 0);
        while (true){
            point = fill(board, coord, point);
            if (coord.x == coord.y && coord.x == 8) {
                break;
            }
            if (coord.y == 8) {
                coord.x ++;
                coord.y = 0;
                continue;
            }
            coord.y ++ ;
        }
        print(board);
    }

    public Point fill(char[][] matrix, Point coord, Point last) {
        if (matrix[coord.x][coord.y] == '.') {
            Point node = new Point(coord.x, coord.y, last);
            Character suppose = getMinVal(matrix, node, (char) 0);
            if (suppose != null) {
                matrix[coord.x][coord.y] = suppose;
                node.val = suppose;
                last.next = node;
                last = node;
            } else {
                do {
                    if (last.x == -1) {
                        throw new RuntimeException("出错");
                    }
                    last.next = null;
                    matrix[last.x][last.y] = '.';
                    suppose = getMinVal(matrix, last, last.val);
                    if (suppose == null) {
                        last = last.before;
                    } else {
                        coord.x = last.x;
                        coord.y = last.y;
                        matrix[coord.x][coord.y] = suppose;
                    }
                } while (suppose == null);
            }
        }
        return last;
    }

    public Character getMinVal(char[][] board, Point p, char not) {
        for (int n = 49; n < 58; n++) {
            p.val = (char) n;
            if (p.val <= not) continue;
            if (valid(board, p)) {
                return p.val;
            }
        }
        return null;
    }

    /**
     * 在某个位置插入一个数，判断数独是否满足条件
     *
     * @param board 数独
     * @param p     尝试置入p.val
     * @return
     */
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
                if (board[i][j] == p.val) {
                    return false;
                }
            }
        }

        return true;
    }

    public void print(char[][] board){
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            if(i!=0 && i%3 == 0)System.out.println();
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + "  ");
                if(j%3 == 2)System.out.print("  ");
            }
        }
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

        new _37_SolveSudoku2().solveSudoku(board);

        board = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };




    }
}
