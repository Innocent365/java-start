package observerPattern2;

import java.util.Observable;

public class WomanDate extends Observable {

    private int age;
    private String name;
    private float height;
    private float beauty;

    public void setSubscribe(int age, String name, float height, float beauty) {
        this.age = age;
        this.name = name;
        this.height = height;
        this.beauty = beauty;

        setWomanChanged();
    }

    private void setWomanChanged() {
        setChanged();
        notifyObservers("快看， -->   （.Y.）");
        //notifyAll();继承自Object
    }

    public int getAge() {
        return age;
    }

    public float getHeight() {
        return height;
    }

    public float getBeauty() {
        return beauty;
    }

    public String getName() {
        return name;
    }
}
