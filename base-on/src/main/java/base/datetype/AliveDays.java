package base.datetype;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 要求：
 * 让用户输入自己的生日(yyyy-MM-dd):
 * 然后输出到今天为止活了多少天。
 * 输出的格式:
 *  恭喜您！已经成功活了XXXXX天，继续保持!
 * @author Administrator
 *
 */
public class AliveDays {
	public static void main(String[] args) throws ParseException {
		/*
		 * 步骤:
		 * 1:创建Scanner用于获取用户输入
		 * 2:创建SimpleDateFormat将用户输入的
		 *   字符串转换为对应的Date
		 * 3:创建一个Date用来表示当前系统时间
		 * 4:使用Date的getTime分别获取两个日期的
		 *   毫秒值
		 * 5:用系统时间的毫秒值减去生日的毫秒值
		 * 6:将两个时间差的毫秒转换为天  
		 * 7:将结果输出即可  
		 */
		Scanner scanner  = new Scanner(System.in);
		System.out.println("请输入您的生日:");
		String birthStr = scanner.nextLine();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Date birthday = sdf.parse(birthStr);
		Date now = new Date();
		
		long time = now.getTime()-birthday.getTime();
		
		long days = time/1000/60/60/24;
		
		System.out.println("恭喜您！已经成功活了"+days+"天，继续保持!");
	}
}











