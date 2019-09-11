package com.java8.demo.lambda;

public class LembdaTest {

    static class Children_inner implements Person{

        @Override
        public void eat(String string) {
            System.out.println("内部类的Children Eating..."+string);
        }
    }

    @org.junit.Test
    public void LambdaTest() {
        //外部类
        Person p1 = new Children();

        //内部类
        Person p2 = new Children_inner();

        //匿名内部类
        Person p3 = new Person() {
            @Override
            public void eat(String string) {
                System.out.println("匿名内部类Person Eating..."+string);
            }
        };

        //java8 lambda 简写匿名内部类
        Person p4 = (string)->{
            System.out.println("Lambda匿名内部类Person Eating..."+string);
        };

        //普通接口函数的调用
        p1.eat("早餐");
        p2.eat("午餐");
        p3.eat("下午茶");
        p4.eat("晚饭");

        //接口默认的方法调用
        p1.defaultMethod("吃饭1");
        p2.defaultMethod("吃饭2");

        //接口静态方法调用
        Person.staticMethod();
    }

    //方法引用
    @org.junit.Test
    public void yinyong(){

        Children children = new Children();
        //person的eat方法引用实例对象children的eat方法
        Person person = children::eat;
        person.eat("宵夜");
        Person person1 = System.out::println;
    }

    //方法引用
    @org.junit.Test
    public void yinyong2(){

        Student study = new Student();
        //person的eat方法引用实例对象children的eat方法
        Person person = study::eat;
        person.eat("宵夜");
        Person person1 = System.out::println;
    }
}
