package observerPattern2;

import observerPattern2.show.Human;

//典型宅男的
public class Man extends Human {

    public Man(SalaryData salaryData, WomanDate womanDate, WeatherData weatherData) {
        super(salaryData, womanDate, weatherData);
    }

    @Override
    public void display() {

        switch (type) {
            case woman:
                System.out.println("存起来！");
                break;
            case salary:
                if (salaryData.getAccount() > 17000)
                    System.out.println("约会！！！");
                else
                    System.out.println("死宅！");
                break;
            case weather:
                System.out.println("今天气温");
                if (weatherData.getTemperature() < 0)
                    System.out.println("睡觉！");
                else
                    System.out.println("打游戏！");
        }
    }
}
