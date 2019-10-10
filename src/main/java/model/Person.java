package model;

import java.util.List;

/**
 * @author hw
 * @version on 2019/4/22
 */
public class Person {
    private Integer age;
    private String name;
    private String gender;
    private List<String> otherInfo;

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
}
