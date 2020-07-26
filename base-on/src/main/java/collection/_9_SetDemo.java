package collection;

import javafx.util.Pair;
import model.Student;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author hw
 * @version on 2019/7/10
 */
public class _9_SetDemo {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setGender(true);
        s1.setName("张三");
        s1.setAge(25);

        Student s2 = new Student();
        s2.setGender(false);
        s2.setName("李四");
        s2.setAge(27);

        Student s3 = new Student();
        s3.setGender(false);
        s3.setName("张三");
        s3.setAge(28);

        Set<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);

        set.stream().forEach(System.out::println);
    }

    @Test
    public void TestTreeSet(int[] arr){
        Set<Integer> set = new TreeSet<>();
        for (Integer i:arr) {
            set.add(i);
        }

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        String str = "[104001=小哒信用, 106024=小飞鹿, 106016=合禾旅游, 101003=代销, 106034=鼎铛财富, 106029=易贷宝, 106004=车主钱包, 106047=迷你摄氏度, 106037=找点钱, 106001=找花花, 106036=花薪, 106011=有鱼粮, 106035=指尖财富, 201001=帮你还_容易付, 103004=盒商贷, 106010=知心借2, 106013=大手钱包, 106031=易借易还, 106038=需要钱, 103001=分润贷, 201002=帮你还_还吧, 104002=好哒白条, 108001=委贷, 106033=月饼借, 106007=知心借, 106009=委贷测试产品, 106015=表妹有钱, 103002=资产管理, 106026=钱到到, 106008=消费宝, 106021=民易借, 106028=米袋宝, 106040=急着花, 106014=找花花2, 105001=信贷风控, 106003=花点呗, 106032=奇异果, 103006=现金贷, 106005=衍生付, 106006=河马钱袋, 101002=好哒白条, 107001=汇赚钱, 106030=万象钱包, 201007=帮你还_C端导流机构, 301001=借你用, 106039=用钱快, 106002=零钱花, 201004=帮你还_乐信付还呗, 106020=去花花_保险, 103003=提货贷, 106027=金树管家, 106025=快借宝, 106017=内部测试-互金, 106023=精灵花, 106018=去花花, 109001=微享铺子, 101001=帮你还, 201003=帮你还_微信, 106022=多多钱包, 106041=印钞鸡, 106012=融E分, 106019=去花花_消费]";


        Set<Pair> set = new HashSet<>();
        set.add(new Pair("104001", "小哒信用"));
        set.add(new Pair("106024", "小飞鹿"));
        set.add(new Pair("106016", "合禾旅游"));
        set.add(new Pair("101003", "代销"));
        set.add(new Pair("106034", "鼎铛财富"));
        set.add(new Pair("106029", "易贷宝"));

        try {
            set.stream().forEach(p->System.out.println(p));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
