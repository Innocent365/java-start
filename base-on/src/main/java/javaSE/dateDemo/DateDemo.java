package javaSE.dateDemo;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateDemo {
    public static void main(String[] args)  {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        try {
            String dateStr = "1997-11-09";
            System.out.println(sdf.parse(dateStr));

            sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
            System.out.println(sdf.parse("1991-12-14 03:28:59 991"));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        /** 内部维护一个long值。该long值是自1970年元旦到当前Date表示的时间之间经过的毫秒值。*/
        Date now = new Date();
        long longTime = now.getTime();
        longTime += 1000 * 60 * 60 * 24;

        System.out.println(longTime);


    }

    @Test
    public void testCalendar() {
        /**
         * Calendar本身是抽象类，不能实例化。
         *    其提供了一个静态方法getInstance()可以根据当前
         *      系统所在地区创建一个适当的实现类，大部分情况下
         *      创建的都是格里高利历法(公历)：
         */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = "1997-11-09";

        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(sdf.parse(dateStr));

            //设置年
            calendar.set(Calendar.YEAR, 2008);

            //设置月
            /*
             * 月份的值Calendar也有常量对应
             * 当然，也可以使用数字，需要注意0表示1月         !!!!!!!!!!!!!!!!!!
             * 11表示12月
             */
            calendar.set(Calendar.MONTH, Calendar.AUGUST);
            calendar.set(Calendar.MONTH, 7);
            System.out.println(calendar.getTime());

            /*
             * 设置日
             */
            calendar.set(Calendar.DAY_OF_MONTH, 8);
            System.out.println(calendar.getTime());

            /*
             * 设置小时
             */
            calendar.set(Calendar.HOUR_OF_DAY, 20);

            /*
             * 设置分钟
             */
            calendar.set(Calendar.MINUTE, 8);

            /*
             * 设置秒
             */
            calendar.set(Calendar.SECOND, 8);
            System.out.println(calendar.getTime());

            calendar.add(Calendar.DATE, 4);
            System.out.println(calendar.getTime());



            System.out.println("year:"+calendar.get(Calendar.YEAR));
            System.out.println("month:"+(calendar.get(Calendar.MONTH)+1));
            System.out.println("day:"+calendar.get(Calendar.DATE));
            //查看今天是今年的第多少天？
            System.out.println("days:"+calendar.get(Calendar.DAY_OF_YEAR));
            //查看今天是周几
            /*
             * 1:表示周日
             * 2:表示周一
             */
            int d = calendar.get(Calendar.DAY_OF_WEEK);
            System.out.println("周"+(d==1?7:d-1));


            /*
             * int getActualMaximum(int field)
             * 获取给定的时间分量所允许的最大值。
             */
            int days = calendar.getActualMaximum(Calendar.DAY_OF_YEAR);

            //设置为当周的周三
            // 将给定的时间分量累加给定的值, 需要注意，当计算后可能会影响其他时间分量的值，那么该进位的会自动进位。例如：日向月进位，月向年进位等
            calendar.set(Calendar.DAY_OF_WEEK, 4);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回昨天
     * @param today
     * @return
     */
    public Date yesterday(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - 1);
        return calendar.getTime();
    }

    /**
     * 返回明天
     * @param today
     * @return
     */
    public Date tomorrow(Date today) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1);
        return calendar.getTime();
    }

    @Test
    public void testEquals() throws ParseException {
        Calendar calendar =  Calendar.getInstance();
        calendar.set(2019, 3,24,10,15);
        Date date = calendar.getTime();

        Date now = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(date.equals(now));
        System.out.println(date.equals(sdf.parse(sdf.format(now))));
        System.out.println(sdf.parse(sdf.format(date)).equals(sdf.parse(sdf.format(now)))); //true
    }

}
