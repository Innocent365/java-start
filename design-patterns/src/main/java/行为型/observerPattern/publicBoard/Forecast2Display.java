package 行为型.observerPattern.publicBoard;

import 行为型.observerPattern.WeatherData;
import 行为型.observerPattern.interf._2_DisplayElement;
import 行为型.observerPattern.interf.Observer;

/**
 * 预测温度面板
 */
public class Forecast2Display implements Observer, _2_DisplayElement {

    protected WeatherData weatherData;
    private float temp;
    private float pressure;

    public Forecast2Display(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        //显示预测观测值
        System.out.println("观测温度: " + temp + "F 度 and " + pressure + "% 湿度");
    }


    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.pressure = pressure;
        display();
    }
}
