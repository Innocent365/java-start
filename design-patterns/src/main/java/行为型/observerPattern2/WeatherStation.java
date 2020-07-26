package 行为型.observerPattern2;

import 行为型.observerPattern2.infomation.WeatherData;

/***
 * 使用java.util内置的 observer
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);

        weatherData.setMeasurements(18, 90, 29.4f);

    }
}
