package 行为型.statusPattern.original;

import java.util.Random;


public class GumballMachine {

    final static int SOLD_OUT = 0;
    final static int NO_QUARTER = 1;
    final static int HAS_QUARTER = 2;
    final static int SOLD = 3;

    private int state;

    private Random random = new Random();
    int count = 0;

    public GumballMachine(int count) {
        this.count = count;
        if (count > 0) {
            state = NO_QUARTER;
        }
    }

    //若有25分钟投进来，就会执行
    public void insertQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("你不能再投入25分钱！");
        } else if (state == SOLD_OUT) {
            System.out.println("你不能投入25分钱， 糖果已售罄 ");
        } else if (state == SOLD) {
            System.out.println("请稍等，给你一个糖果");
        } else if (state == NO_QUARTER) {
            state = HAS_QUARTER;
            System.out.println("你投入了一个25分钱！");
        }
    }

    //现在，如果顾客试着退回25分钱……
    public void ejectQuarter() {
        if (state == HAS_QUARTER) {
            System.out.println("给你个糖果！");
        } else if (state == NO_QUARTER) {
            System.out.println("您还没有投钱！");
        } else if (state == SOLD) {
            System.out.println("对不起，您已转动了曲柄拿到了糖果");
        } else if (state == SOLD_OUT) {    //如果糖果售罄，就不可能接手25分钱，当然也不可能退钱
            System.out.println("不能,您还没有投币");
        }
    }

    //顾客试着转动曲柄……
    public void turnCrank() {
        if (state == SOLD) {
            System.out.println("您已经拿过来，再转动也拿不到第二个!");
        } else if (state == NO_QUARTER) {
            System.out.println("我们需要先投入25分钱");
        } else if (state == SOLD_OUT) {
            System.out.println("糖果已售罄");
        } else if (state == HAS_QUARTER) {
            System.out.println("成功……");
            state = SOLD;
            dispense();
            //这是抽奖的糖果
            if (random.nextDouble() * 100 <= 10 && count > 0) {
                System.out.println("恭喜您，再奖励给你一个糖果");
                state = SOLD;
                dispense();
            }
        }
    }

    //调用此方法，发放糖果
    private void dispense() {
        if (state == SOLD) {
            System.out.println("正在准备糖果……");
            count--;
            if (count == 0) {
                System.out.println("刚好最后一颗 !");
                state = SOLD_OUT;
            } else {
                state = NO_QUARTER;
            }
        }
        //以下这两种情况不该其实不该发生
        else if (state == NO_QUARTER) {
            System.out.println("您需要先支付！");

        } else if (state == SOLD_OUT) {
            System.out.println("啊，没有糖果给您");
        } else if (state == HAS_QUARTER) {
            System.out.println("啊，没有糖果给您");
        }

    }

    public void refill() {

    }

    @Override
    public String toString() {
        return "GumballMachine{" +
                "state=" + state +
                ", count=" + count +
                '}';
    }
}
