package 行为型.observerPattern2.show;

import 行为型.observerPattern2.infomation.SalaryData;
import 行为型.observerPattern2.infomation.WeatherData;
import 行为型.observerPattern2.infomation.WomanDate;

//典型宅男的
public class Man extends AbstractHuman {

    public Man(SalaryData salaryData, WomanDate womanDate, WeatherData weatherData) {
        super(salaryData, womanDate, weatherData);
    }

    @Override
    public void display() {

        switch (type) {
            case salary:
                System.out.println("存起来！");
                break;
            case woman:
                if (salaryData.getAccount() > 20000)
                    System.out.println("约会！！！");
                else
                    System.out.println("死宅！");
                break;
            case weather:
                System.out.println("今天气温");
                if (weatherData.getTemperature() < 10)
                    System.out.println("睡觉！");
                else
                    System.out.println("打游戏！");
        }
    }
}
