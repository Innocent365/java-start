package observerPattern2.show;

import observerPattern.interf.DisplayElement;
import observerPattern2.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class FirstDisplay implements DisplayElement, Observer {


    private WeatherData weatherData;

    public FirstDisplay(WeatherData weatherData) {
        this.weatherData = weatherData;
        weatherData.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("FirstDisplay, temperature:" + weatherData.getTemperature() +
                "; humidity:" + weatherData.getHumidity() + "; pressure:" + weatherData.getPressure());
    }

    @Override
    public void update(Observable o, Object arg) {  //主题本身当作第一个变量，让观察者知道是哪个主题通知它的
        System.out.println(arg);

        if (o instanceof WeatherData) {
            this.weatherData = (WeatherData) o;
            display();
        }


    }


}
