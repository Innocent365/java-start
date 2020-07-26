package model;

import java.util.List;

/**
 * @author hw
 * @version on 2019/4/22
 */
public class Person implements Cloneable{
    private Integer age;
    private String name;
    private String gender;
    private List<String> otherInfo;

    public Person() {
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "model.Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<String> getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(List<String> otherInfo) {
        this.otherInfo = otherInfo;
    }

    @Override
    public Object clone(){
        return new Person(this.age, name);//浅拷贝
        //return new Person(this.age, new String(name));//深拷贝
    }

}
