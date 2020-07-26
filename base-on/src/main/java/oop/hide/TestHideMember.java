package oop.hide;

/**
 * @author hw
 * @version on 2020/7/18
 */
public class TestHideMember {
    public static void main(String[] args) {
        CheapGoods cheapGoods = new CheapGoods();
        //cheapGoods.weight = 198.555是非法的，因为子类对象的weight变量已经变成int类型
        cheapGoods.newSetWeight(198);
        System.out.println("对象cheapGood的weight值是：" + cheapGoods.weight);
        System.out.println("cheapGoods用子类新增的优惠方法计算价格：" + cheapGoods.newGetPrice());

        cheapGoods.oldSetWeight(198.555);
        //子类对象调用继承的方法操作隐藏的double型变量weight
        System.out.println("cheapGoods使用继承的方法（无优惠）计算价格："
                + cheapGoods.oldGetPrice());
    }
}
