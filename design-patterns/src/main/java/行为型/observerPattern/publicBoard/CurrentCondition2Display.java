package 行为型.observerPattern.publicBoard;

import 行为型.observerPattern.interf._2_DisplayElement;
import 行为型.observerPattern.interf.Observer;
import 行为型.observerPattern.interf._1_Subject;

/**
 * 温度展示面板
 */
public class CurrentCondition2Display implements Observer, _2_DisplayElement {

    private float temperature;
    private float humidity;
    protected _1_Subject weatherData;

    public CurrentCondition2Display(_1_Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    public void display() {
        //显示当前观测值
        System.out.println("当前温度: " + temperature + "F 度 and " + humidity + "% 湿度");
    }
}
