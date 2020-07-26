package 行为型.observerPattern2.show;

import 行为型.observerPattern2.infomation.WeatherData;
import 行为型.observerPattern2.infomation.WomanDate;

public class Child extends AbstractHuman {

    public Child(WomanDate womanDate, WeatherData weatherData) {
        super(null, womanDate, weatherData);
    }


    @Override
    public void display() {
        switch (type) {
            case woman:
                System.out.println("叫阿姨！");
                break;
            case weather:
                if (weatherData.getTemperature() < 10)
                    System.out.println("哪也不能去！");
                else
                    System.out.println("去和你小伙伴玩吧！");
        }

    }
}
