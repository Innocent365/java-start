
public class Recursion {

    public static void main(String[] args) {
        //System.out.println(factorial(5));


        //要求返回 1! + 2! + 3! + 4!
        int result =0 ;
        for (int i = 1; i < 6; i++) {
            result += factorial(i);
        }
        System.out.println(result);
    }

    //计算阶乘，例如5!， 返回5x4x3x2x1
    public static int factorial(int i){
        if(i==1) return 1;
        return factorial(i-1)*i;
    }

}
