package observerPattern.publicBoard;

import observerPattern.WeatherData;
import observerPattern.interf.DisplayElement;
import observerPattern.interf.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

    protected WeatherData weatherData;
    private float temp;
    private float pressure;

    public ForecastDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        //显示预测观测值
        System.out.println("Forecast conditions: " + temp + "F degrees and " + pressure + "% humidity");
    }


    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.pressure = pressure;
        display();
    }
}
