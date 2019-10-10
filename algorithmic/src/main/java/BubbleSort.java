
/**
 * Created by ss on 2016/12/19.
 */
public class BubbleSort {
    public static void main(String[] args){
        int[] array = {2,6,1,8,10,45,-3,7};

//        for (int i = 0; i < array.length;i++){
//            for (int j = array.length -1; j > i; j--){
//                if(array[j]<array[j-1]){
//                    int temp = array[j];
//                    array[j] = array[j-1];
//                    array[j-1] = temp;
//                }
//            }
//        }

        for (int i = 0; i < array.length;i++){
            for (int j = i+1; j < array.length; j++){
                if(array[j]<array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }

        for (int i: array){
            System.out.println(i);
        }
    }
}
