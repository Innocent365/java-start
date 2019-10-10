package other;

import java.text.ParseException;
import java.util.Date;

/**
 * @author hw
 * @version on 2019/4/26
 */
public class ToolsDemo {

    public static void main(String[] args) throws ParseException {
        //得到 当前执行的方法名
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        System.out.println(methodName);


        //转字符串到日期
        Date date = java.text.DateFormat.getDateInstance().parse("2018-01-02");
        System.out.println(date);
    }

}
