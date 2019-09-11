package com.java8.demo.lambda;

import java.util.Arrays;

public class Student {

    private String name;
    private String[] hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    public void eat(String something){
        System.out.println("我正在吃:"+something);
    }

    public Student() {
        super();
    }

    public Student(String name, String[] hobby) {
        this.name = name;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", hobby=" + Arrays.toString(hobby) +
                '}';
    }
}
