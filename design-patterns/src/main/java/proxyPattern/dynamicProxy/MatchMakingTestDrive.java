package proxyPattern.dynamicProxy;

import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {
    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.driver();
    }

    PersonBean joe;

    public MatchMakingTestDrive() {
        //initializeDatabase();//构造器初始化配对服务人员数据库
        PersonBean person = new PersonBeanImpl();
        person.setName("Joe Tomas");
        person.setInterests("wat ever");
        joe = person;
    }

    private void driver() {
        //PersonBean joe = //getPersonFromDatabase("Joe javabean");

        PersonBean ownerProxy = getOwnerProxy(joe);
        System.out.println("Name is " + ownerProxy.getName());
        ownerProxy.setInterests("bowling, Go");
        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("Name is " + nonOwnerProxy.getName());

        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
        try {
            nonOwnerProxy.setGender("woman");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }
    }

    PersonBean getNonOwnerProxy(PersonBean person) {
        return (PersonBean) Proxy.newProxyInstance(
                person.getClass().getClassLoader(),
                person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person)
        );
    }


    PersonBean getOwnerProxy(PersonBean person) {
        Object obj = Proxy.newProxyInstance(
                person.getClass().getClassLoader(),

                //传入的接口类型：接口数组，只能有接口，不能有类。
                person.getClass().getInterfaces(),//如果接口不是public，就必须属于同一个package
                //不同的接口内，不可以有名称和参数完全一样的方法。

                new OwnerInvocationHandler(person));
        return (PersonBean) obj;
    }


}
