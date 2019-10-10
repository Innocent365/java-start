package observerPattern2.show;

import observerPattern.interf.DisplayElement;
import observerPattern2.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class SecondDisplay implements DisplayElement, Observer {

    private WeatherData weatherData;

    public SecondDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("SecondDisplay, temperature:" + weatherData.getTemperature() +
                "; humidity:" + weatherData.getHumidity() + "; pressure:" + weatherData.getPressure());
    }

    @Override
    public void update(Observable o, Object arg) {
        this.weatherData = (WeatherData) o;
        display();
    }

}
