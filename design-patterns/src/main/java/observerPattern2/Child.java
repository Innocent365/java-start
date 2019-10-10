package observerPattern2;

import observerPattern2.show.Human;

public class Child extends Human {

    //父类没有的构造方法，子类不能有？ NO, IDEA不能生成
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
                if (weatherData.getTemperature() < 0)
                    System.out.println("哪也不能去！");
                else
                    System.out.println("去和你小伙伴玩吧！");
        }

    }
}
