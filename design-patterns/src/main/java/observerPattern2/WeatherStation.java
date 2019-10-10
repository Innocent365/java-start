package observerPattern2;

import observerPattern2.show.FirstDisplay;
import observerPattern2.show.SecondDisplay;

/***
 * 使用java.util内置的 observer
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        FirstDisplay firstDisplay = new FirstDisplay(weatherData);
        SecondDisplay secondDisplay = new SecondDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);

        weatherData.deleteObserver(firstDisplay);
        weatherData.setMeasurements(18, 90, 29.4f);

    }
}
