package leetCode.assist;

/**
 * @author hw
 * @version on 2020/3/23
 */
public class Point {
    public int x;
    public int y;
    public char val;

    public Point before;
    public Point next;

    public Point(int row, int col) {
        this.x = row;
        this.y = col;
    }

    public Point(int x, int y, Point before) {
        this.x = x;
        this.y = y;
        this.before = before;
    }

    public Point(int x, int y, char val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
