package model;

public class Student {
    private boolean gender;
    private Integer age;
    private String Name;
    private Double score;

    public Student(){}

    public Student(boolean gender, Integer age, String name, Double score) {
        this.gender = gender;
        this.age = age;
        Name = name;
        this.score = score;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "model.Student{" +
                "gender=" + gender +
                ", age=" + age +
                ", Name='" + Name + '\'' +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return Name != null ? Name.equals(student.Name) : student.Name == null;

    }

    @Override
    public int hashCode() {
        return Name != null ? Name.hashCode() : 0;
    }
}
