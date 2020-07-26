package 行为型.observerPattern2.infomation;


import java.util.Observable;

/***
 * 已经从超类继承了 registerObserver() --> addObserver(),
 *              removeObserver() -->  deleteObserver(),
 *
 *              notifyObservers()
 *
 */
public class WeatherData extends Observable {

    private float temperature;
    private float pressure;
    private float humidity;


    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    private void measurementsChanged() {
        setChanged();       //继承的这个变量用来标识 需要告知的更新，相反的，如果没有，则温度仅变化了0.1就通知就很烦

//        notifyObservers(this);
//        notify();
//        notifyAll();
        notifyObservers("Hi, 我们这一期有更新啊，要不要来看一下！");
    }


    /**
     * 让数据改用 观察者‘拉’ 的方式进行获取， 而不是之前放在update里 向观察者‘推’
     */
    public float getTemperature() {
        return this.temperature;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public float getPressure() {
        return this.pressure;
    }

}
