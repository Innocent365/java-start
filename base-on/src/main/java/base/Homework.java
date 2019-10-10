package _1.base;

import org.junit.Test;

/**
 * 常见面试：
 * 1.计算闰年
 * 2.计算个人所得税
 */
public class Homework {

	//根据年和月算天
	@Test
	public void calcDays() {
		int year = 2001; //年
		int month = 4;   //月
		int days = 0;    //天数
		switch (month) {
			case 1:case 3: case 5:
			case 7: case 8: case 10:
			case 12: //相当于或者的关系
				days = 31;
				break;
			case 4: case 6: case 9:
			case 11:
				days = 30;
				break;
			case 2:
				if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
					days = 29;
				} else {
					days = 28;
				}
				break;
		}
		System.out.println("days=" + days);
	}

	//个人所得税
	@Test
	public void calcTax() {
		double salary = 10000; //工资
		double taxSalary = salary - 3500; //计税工资
		double tax = 0; //税
		if(taxSalary<=0){
			tax = 0;
		}else if(taxSalary<=1500){
			tax = taxSalary*0.03-0;
		}else if(taxSalary<=4500){
			tax = taxSalary*0.1-105;
		}else if(taxSalary<=9000){
			tax = taxSalary*0.2-555;
		}else if(taxSalary<=35000){
			tax = taxSalary*0.25-1005;
		}
		System.out.println("tax="+tax);
	}


	@Test
	public void isLeapYear() {
		//4.闰年的判断
		int year = 2001;
		if((year%4==0 && year%100!=0) || year%400==0){
			System.out.println(year+"是闰年");
		}else{
			System.out.println(year+"不是闰年");
		}
	}


	@Test
	public void swap() {
		//3.交换三个数
		int a=8,b=5,c=2;
		if(a>b){  //保证a<b
			int t=a;
			a=b;
			b=t;  //a=5,b=8,c=2
		}
		if(a>c){  //保证a<c
			int t=a;
			a=c;
			c=t;  //a=2,b=8,c=5
		}
		if(b>c){  //保证b<c
			int t=b;
			b=c;
			c=t;  //a=2,b=5,c=8
		}
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);

		/*
		//2.交换两个数
		int a=8,b=15;
		if(a>b){
			int t=a;
			a=b;
			b=t;
		} //若a>b则交换，保证a<b
		System.out.println("a="+a);
		System.out.println("b="+b);
		*/


	}

	public void test() {
		//1.求两个数中的最大值
		int a=15,b=10;
		int max = a>b ? a:b;
		int min = Math.min(a, b);
		System.out.println("max="+max);
	}

}
