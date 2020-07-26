package java8Feature.localtime;

import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * JAVA 8 引入新时间API原因是原来的Date类无法支持多线程操作，新时间API支持多线程操作
 * @version on 2019/12/10
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        // 结果： 2019-12-10T09:29:01.939

        LocalDate localDate = localDateTime.toLocalDate();
        //2019-12-10

        LocalTime localTime = localDateTime.toLocalTime();
        //09:29:01.939

        Timestamp timestamp = Timestamp.valueOf(localDateTime);
        //2019-12-10 09:32:12.249


    }

    @Test
    public void testLocalDateTime(){
        String date1 = "2018-03-28 10:40";
        //Timestamp format must be yyyy-mm-dd hh:mm:ss[.fffffffff]
        try {
            LocalDateTime localDateTime = Timestamp.valueOf(date1).toLocalDateTime();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            System.out.println(localDateTime.format(dtf));
        } catch (Exception e){
            e.printStackTrace();
        }
    }


}
