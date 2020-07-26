package oop.hide;

/**
 * @author hw
 * @version on 2020/7/18
 */
public class CheapGoods extends Goods {
    public int weight;
    public void newSetWeight(int w){
        weight = w;//这个weight是子类的int类型的weight
        System.out.println("int型的weight =" + weight);
    }
    public double newGetPrice(){
        double price = weight*10;
        return price;
    }
}