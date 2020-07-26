package 行为型.observerPattern2.show;

import 行为型.observerPattern2.infomation.SalaryData;
import 行为型.observerPattern2.infomation.WeatherData;
import 行为型.observerPattern2.infomation.WomanDate;
import 行为型.observerPattern2.interf.DoSomething;

import java.util.Observable;
import java.util.Observer;


public abstract class AbstractHuman implements Observer, DoSomething {
    public enum observerType {
        weather, salary, woman
    }

    protected observerType type;

    protected SalaryData salaryData;
    protected WomanDate womanDate;
    protected WeatherData weatherData;


    public AbstractHuman(SalaryData salaryData, WomanDate womanDate, WeatherData weatherData) {
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
            type = observerType.salary;
            salaryData = (SalaryData) o;
        } else if (o instanceof WomanDate) {
            type = observerType.woman;
            womanDate = (WomanDate) o;
        } else {
            type = observerType.weather;
            weatherData = (WeatherData) o;
        }
        display();
    }

}
