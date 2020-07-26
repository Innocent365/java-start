package base;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://zhuanlan.zhihu.com/p/37909700
 * <p>
 * 位运算符实用篇：
 * and操作:
 *      交换律，a&b = b&a
 *      结合律，(a&b)&c = a&(b&c)
 * <p>
 * or操作:
 *      交换律，a|b = b|a
 *      结合律，(a|b)|c = a|(b|c)
 * <p>
 * xor操作:
 *      交换律，a^b = b^a
 *      结合律，(a^b)^c = a^(b^c)
 * not操作:
 *      结合律，a = ~(~a)
 */
public class OperatorHome {

    /**
     * and 操作（截取）：
     */
    @Test
    public void testAnd() {
        int x = 0b0100_1100;    //76

        //判断奇偶数(末位为1还是0):
        //  奇数 x&1 = 1
        //  偶数 x&1 = 0
        System.out.println((x & 1) == 0);

        //判断某个二进制位是否为1:
        //  要判断第N个二进制位是否为1，可以把1左移N-1位，再进行and操作
        //      如果大于0则代表该二进制位就为1
        System.out.println(((123 << 4) & 1) == 1);//123的二进制位数第五位是否为1

        //减去低位的最后一个1:
        System.out.println(Integer.toBinaryString(x & (x - 1)));//76-2=74

        //字节读取
        //在JAVA JDK中，BufferedInputStream类在读取字节码时，使用了byte & 0xff的操作来读取
        //因为0xff默认为int类型，即高位24个位全部为0，低位8个位全部为1
        //用byte & 0xff能确保即使byte为 [1111 1111] ，也不会被返回成-1，因为-1是流结束的特殊代码；

        //指定二进制位数截取
        //在对字节码进行加密时，我们往往不按原来的字节读取方式每次8-bit地读取，而是有选择地读取其中某一段的bit，
        // 例如在JAVA JDK中，BASE64Encoder类
    }

    /**
     * or组合编码(状态压缩)
     */
    @Test
    public void testOr() {


        //在对字节码进行加密时，加密后的两段bit需要重新合并成一个字节，这时就需要使用or操作
        //BASE64Encoder
    }

    /**
     * xor操作
     */
    @Test
    public void testXor() {
        //1.两个整数交换值
        //一般而言，两个变量要交换彼此的值都需要借助第三个变量作用临时变量。
        //而如果使用了xor操作，能在不用第三个临时变量的情况下实现值交换。
        // 这是xor操作的最经典的使用场景。例如：
        int a = 10, b = 15;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a=" + a + ", b=" + b);

        //可简写为：
        a ^= b;
        b ^= a;// b = b ^ a 即 b^=a;
        a ^= b;
        //System.out.println("a=" + a + ", b=" + b);


        //2.数据加密
        int psd = 147258;
        int key = 791205;
        int plaintext = psd ^ key;
        System.out.println(plaintext);
        //x^y^y = x 假如我们的银行密码是135790，如果以明文的方式记录会容易被别人发现,
        // 设置密码怕忘记。于是，我们可以再想一段破译码，比如2468，然后我们就可以以明文的方式记下这两个数的xor操作结果。
        // 这就是最简单的数据加密原理。

        //3.数字判重
        //  当同一个数累计进行两次xor操作，相当于自行抵销了。
        //x^y^y = x

    }

    /**
     * not操作
     */
    @Test
    public void testNot() {
        //Python数组中的倒序下标
        //我们知道二进制数有性质：～a = -a -1, 即 a的反码为-a-1
        //在Python的数组访问时，我们可以用负数下标来倒序访问数组中的元素。
        //使用not操作来进行倒序访问可以使代码更加优雅。
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[arr.length - 1 - i] + ",");
            //System.out.println(arr[~i]);//python中可以
        }
    }

    /**
     * 左移
     */
    public void testShL() {
        //求2的N次方
        System.out.println(3 << 4 == 3 * Math.pow(2, 4));

        //加解密算法中对字节重组时的移位操作
    }

    /**
     * 右移
     */
    public void testShR() {
        //求2的N次方的模
        System.out.println(3 << 4 == 3 * Math.pow(2, 4));

        //加解密算法中对字节重组时的移位操作 BASE64Encoder类
    }

    /**
     * 当作集合使用
     */
    public static void main(String[] args) {
        //Linux里的权限控制：权限分为
        final byte READ = 1 << 2;//r 读
        final byte WRITE = 1 << 1;//w写
        final byte EXECUTE = 1;//x执行
        //      w 写 = 1 << 1,
        //      x 执行 = 1;
        //      代表它们的权值分别为4,2,1，
        //所以 如果用户要想拥有这三个权限 就必须  chomd 7  , 即 7=4+2+1 表明 这个用户具有rwx权限，
        //如果只想这个用户具有r,x权限 那么就 chomd 5即可

        byte val = 0;
        //添加写权限 or
        val |= WRITE;//val = 2
        //读取权限：and 根据val值判断是否有读权限，低
        boolean readPermission = ((val & READ) > 0);//false
        Assert.assertFalse(readPermission);
        boolean writePermission = ((val & WRITE) > 0);//true
        Assert.assertTrue(writePermission);
        boolean exePermission = (val & EXECUTE) > 0;
        Assert.assertFalse(exePermission);

        val |= READ;//val = 6
        readPermission = ((val & READ) > 0);
        Assert.assertTrue(readPermission);

        //删除权限：使用and 目标的取反操作来实现删除。
        val &= ~READ;//val = 2
        readPermission = (val & READ) > 0;
        Assert.assertFalse(readPermission);
        exePermission = (val & EXECUTE) > 0;
        Assert.assertFalse(exePermission);

        //反选元素：使用not操作
        val = (byte) ~val;//-3
        Assert.assertTrue((val & READ) > 0);
        Assert.assertFalse((val & WRITE) > 0);
        Assert.assertTrue((val & EXECUTE) > 0);

        //求集合大小
        int size = 0;
        int copy_option = val & 0x07;//由于上面已经反选变成了负数，这里7是所有的权限,全部为1的情形.
        while (copy_option > 0) {
            size++;
            copy_option &= (copy_option - 1);
        }
        System.out.println(size);//2个权限

        //删除最小元素(把末尾的最小的1干掉)
        int x = 0b0011_1010;
        x &= x - 1;//56即 0b0011_1000
        System.out.println(Integer.toBinaryString(x));

        System.out.println("--------------");
        //两个集合的运算
        byte option1 = 1 | 1 << 3 | 1 << 5;//101001
        byte option2 = (1 << 1) | (1 << 2);//110
        byte option3 = (1 << 5) | (1 << 6);//1100000

        //交集
        byte option = (byte) (option1 & option3);//1 << 5
        System.out.println(option);

        //并集
        option = (byte) (option1 | option2);
        System.out.println(option);//101111, 即 32+15 = 47

        //差集
        option = (byte) (option2 & ~option3);
        System.out.println(option);//6

        //非重叠集
        option = (byte) (option1 ^ option3);
        System.out.println(option);//100 1001 即 64+9 = 73
    }

    /**
     * 当作二维表结构(集合可以看作一维的)
     */
    @Test
    public void test() {
        int item1 = 0x01;
        int item2 = 0x02;
        int item3 = 0x04;
        int item4 = 0x08;
        int item5 = 0x10;
        int item6 = 0x20;
        int item7 = 0x40;
        int item8 = 0x80;

        int[] users = new int[5];//假设有5个用户
        users[0] = item1 | item2 | item4 | item5;
        users[1] = item2 | item3 | item6 | item8;
        users[2] = item1 | item4 | item6 | item7 | item8;
        users[3] = item1 | item3 | item4 | item6;
        users[4] = item1 | item2 | item3 | item5 | item7 | item8;

        //统计列计数
        //比如我们想知道有多少人选择了item2
        int count = 0;
        for (int user : users) {
            if ((user & item2) > 0) {
                count++;
            }
        }
        System.out.println(count);

        //选中了item2的用户 筛选选中项/非选中项
        List<Integer> selected = new ArrayList<>();
        List<Integer> un_selected = new ArrayList<>();
        for (int user : users) {
            if((user & item2) > 0){
                selected.add(user);
            }else {
                un_selected.add(user);
            }
        }
        //selected = [0,1,4];
        //un_selected = [2, 3];

    }
}
/**
 * 用位运算的可逆性，来达到隐藏数据的一些效果，并且效率也是非常的高:
 * 1.在JDK的原码中。有很多初始值都是通过位运算计算的，位运算有很多特性，能够在线性增长的数据中起到作用。
 * 且对于一些运算，位运算是最直接、最简便的方法。
 * 2.Linux里的权限控制：权限分为  r 读, w 写, x 执行,其中 它们的权值分别为4,2,1，
 * 所以 如果用户要想拥有这三个权限 就必须  chomd 7  , 即 7=4+2+1 表明 这个用户具有rwx权限，
 * 如果只想这个用户具有r,x权限 那么就 chomd 5即可
 * 3.联合表示多个bool值（状态压缩），
 * 用在数据库上: 通常 我们的数据表中 可能会包含各种状态属性，
 * 例如 blog表中 ， 我们需要有字段表示其是否公开，是否有设置密码，是否被管理员封锁，是否被置顶等等。
 * 也会遇到在后期运维中，策划要求增加新的功能而造成你需要增加新的字段。
 * <p>
 * 公开blog  给status进行或运算
 * UPDATE blog SET status = status | 1;
 * 加密blog 给status进行或运算
 * UPDATE blog SET status = status | 2;
 * 封锁blog
 * UPDATE blog SET status = status | 4;
 * 解锁blog
 * UPDATE blog SET status = status ^ 4;
 * 查询所有被置顶的blog
 * SELECT * FROM blog WHERE status & 8;
 * <p>
 * 在移位的时候，一定要注意数据类型。一般我建议显示的表示出来，否则容易出错!!
 * System.out.println(Long.toBinaryString(10 << 61)); //1000000000000000000000000000000
 * System.out.println(Long.toBinaryString(10L << 61)); //100000000000000000000000000000000000000000000000000000000000000
 * 建议：
 * Long val = 10L << 61;
 * String bin = Long.toBinaryString(val);
 */
