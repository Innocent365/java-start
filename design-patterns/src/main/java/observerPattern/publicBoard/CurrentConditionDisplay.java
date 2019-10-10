package observerPattern.publicBoard;

import observerPattern.interf.DisplayElement;
import observerPattern.interf.Observer;
import observerPattern.interf.Subject;

public class CurrentConditionDisplay implements Observer, DisplayElement {

    private float temperature;
    private float humidity;
    protected Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
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
        System.out.println("Current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
    }
}