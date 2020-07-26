package 结构型.proxyPattern.dynamicProxy;

public interface PersonBean {
    String getName();

    String getGender();

    String getInterests();

    int getHotOrNotRating();

    void setName(String name);

    void setGender(String gender);

    void setInterests(String interests);

    //需要一个整数作为参数，并将它假如此人的运行平均值中
    void setHotOrNotRating(int rating);
}
