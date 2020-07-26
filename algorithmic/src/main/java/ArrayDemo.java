import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Arrays.sort(arr) 排序方法需要arr对象实现compare方法，否则运行时出错（编译不会出错）
 */
public class ArrayDemo {
    public static void main(String[] args) {
        List list1 =new ArrayList();
        list1.add("1111");
        list1.add("2222");
        list1.add("3333");

        List list2 =new ArrayList();
        list2.add("3333");
        list2.add("4444");
        list2.add("5555");

        //并集
        list1.addAll(list2);
        //交集
        list1.retainAll(list2);
        //差集
        list1.removeAll(list2);
        //无重复并集
        list2.removeAll(list1);
        list1.addAll(list2);
    }

    @Test
    public void InsertSort(int data[]){  //插入排序（升序）
        int temp;
        int i,j;
        for(i=1;i<data.length;i++){
            temp=data[i];
            for(j=i;j > 0 && temp<data[j-1];j--)
                data[j]=data[j-1];
            data[j]=temp;
        }
    }

    @Test
    public void TestOrderByInsert_2(){   //希尔排序
        int[]a={49,38,65,97,76,13,27,49,78,34,12,64,1};
        System.out.println("排序之前：");
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }

        int d=a.length;
        while(true)
        {
            d=d/2;
            for(int x=0;x<d;x++)
            {
                for(int i=x+d;i<a.length;i=i+d)
                {
                    int temp=a[i];
                    int j;
                    for(j=i-d;j>=0&&a[j]>temp;j=j-d)
                    {
                        a[j+d]=a[j];
                    }
                    a[j+d]=temp;
                }
            }
            if(d==1)
            {
                break;
            }
        }
        System.out.println();
        System.out.println("排序之后：");
        for(int i=0;i<a.length;i++)
        {
            System.out.print(a[i]+" ");
        }
    }
}
