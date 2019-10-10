package observerPattern2;

import observerPattern2.show.Human;

import java.util.Date;

/***
 * 注意：
 *      1.不要依赖于观察者被通知的次序
 *      2.Observable是一个类，而不是接口。java不支持多重继承，限制了 Observable 的复用潜力
 *          违反了OO设计原则：针对接口编程，而非实现编程
 *          违反了“多用组合，少用继承”
 *      3.为交互对象之间的松耦合而努力
 *
 *      观察者模式的代表人物： MVC
 */
public class HumanStation {
    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();
        WomanDate womanDate = new WomanDate();
        SalaryData salaryData = new SalaryData();

        Human A = new Child(womanDate, weatherData);
        Human B = new Man(salaryData, womanDate, weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);

        womanDate.setSubscribe(25, "钟楚红", 165.2f, 0.8f);
        salaryData.setSubscribe(new Date(), 200000, "ACBC");
    }
}
