package observerPattern2.show;

import observerPattern2.*;
import observerPattern2.inface.Enum;
import observerPattern2.inface.DoSomething;

import java.util.Observable;
import java.util.Observer;


public abstract class Human implements Observer, DoSomething {

    protected Enum.observerType type;

    protected SalaryData salaryData;
    protected WomanDate womanDate;
    protected WeatherData weatherData;

    public Human() {
        salaryData.addObserver(this);
        weatherData.addObserver(this);
        womanDate.addObserver(this);
    }

    public Human(SalaryData salaryData, WomanDate womanDate, WeatherData weatherData) {
        if (salaryData != null) {
            this.salaryData = salaryData;
            salaryData.addObserver(this);
        }
        if (womanDate != null) {
            this.womanDate = womanDate;
            womanDate.addObserver(this);
        }

        if (weatherData != null) {
            this.weatherData = weatherData;
            weatherData.addObserver(this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("=====" + arg + "===========");
        if (o instanceof SalaryData) {
            type = Enum.observerType.salary;
            salaryData = (SalaryData) o;
        } else if (o instanceof WomanDate) {
            type = Enum.observerType.woman;
            womanDate = (WomanDate) o;
        } else {
            type = Enum.observerType.weather;
            weatherData = (WeatherData) o;
        }
        display();
    }

}
