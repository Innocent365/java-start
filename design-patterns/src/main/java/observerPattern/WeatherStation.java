package observerPattern;

import observerPattern.publicBoard.CurrentConditionDisplay;
import observerPattern.publicBoard.HeatIndexDisplay;

/***
 * JDK中使用最多的模式，观察者模式，保证消息灵通：
 *  观察者模式，定义了对象之间的一对多依赖，他的所有依赖者都会收到通知并自动更新；
 *
 *      实现观察者模式的方法不止一种，但是以包含 Subject和 Observer接口的类设计的做法最为常见
 *    设计原则：
 *      为了交互对象之间的松耦合设计而努力
 *
 */
public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentDisplay = new CurrentConditionDisplay(weatherData);
//        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
//        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(18, 90, 29.4f);
    }
}
