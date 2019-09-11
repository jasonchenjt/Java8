package com.java8.demo.lambda;

public class Children implements Person {

    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Children(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Children() {
        super();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Children children = (Children) o;

        if (age != children.age) return false;
        return name != null ? name.equals(children.name) : children.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }

    @Override
    public String toString() {
        return "Children{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void eat(String string) {
        System.out.println("外部类Children Eating..."+string);
    }

    @Override
    public void defaultMethod(String string) {
        System.out.println("重写接口的默认方法!");
    }
}
