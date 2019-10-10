package observerPattern.interf;

public interface Observer {
    //这里定死了数据类型，即以后要修改在改接口的同时要相应更改实现子类
    public void update(float temp, float humidity, float pressure);
}
