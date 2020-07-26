package 行为型.observerPattern.publicBoard;

import 行为型.observerPattern.WeatherData;
import 行为型.observerPattern.interf._2_DisplayElement;
import 行为型.observerPattern.interf.Observer;

/**
 * 统计指数
 */
public class Statistics2Display implements Observer, _2_DisplayElement {

    private WeatherData weatherData;
    private float humidity;
    private float pressure;


    public Statistics2Display(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        //显示最小，平均和最大的观测值
        //显示当前观测值
        System.out.println("统计: " + humidity + "% 湿度 and 气压: " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
