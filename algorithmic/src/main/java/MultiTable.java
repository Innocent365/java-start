
//九九乘法表


import org.junit.Test;

public class MultiTable {

	public static void main(String[] args) {

		for(int num=1;num<=9;num++){ //外层控制行
			for(int i=1;i<=num;i++){ //内层控制列
				System.out.print(i+"*"+num+"="+i*num+"\t");
			}
			System.out.println(); //换行
		}

		/*
		 * num=3
		 *  i=1 1*3=3
		 *  i=2 2*3=6
		 *  i=3 3*3=9
		 *  i=4 换行
		 * num=2
		 *  i=1 1*2=2
		 *  i=2 2*2=4
		 *  i=3 换行
		 * num=1
		 *  i=1 1*1=1
		 *  i=2 换行
		 */
	}

	@Test//获取100以内的质数
	public void getPrime() {
		int count = 0; //质数的个数

		for(int num=2;num<=100;num++){
			boolean flag = true;
			//for(int i=2;i<num;i++){ //2/3/.../98/99
			//for(int i=2;i<=num/2;i++){//2/3/.../49/50

			for(int i=2;i<=Math.sqrt(num);i++){//2/3/.../9/10
				if(num%i==0){
					flag = false;
					break;
				}
			}

			if(flag){
				count++; //质数个数增1
				System.out.print(num+"\t");

				if(count%10==0){ //够10个则换行
					System.out.println();
				}
			}
		}
	}
}













