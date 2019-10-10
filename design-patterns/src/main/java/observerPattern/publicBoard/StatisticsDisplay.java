package observerPattern.publicBoard;

import observerPattern.WeatherData;
import observerPattern.interf.DisplayElement;
import observerPattern.interf.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {

    private WeatherData weatherData;
    private float humidity;
    private float pressure;


    public StatisticsDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    public void display() {
        //显示最小，平均和最大的观测值
        //显示当前观测值
        System.out.println("Statistics conditions: " + humidity + "% humidity and pressure: " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }
}
