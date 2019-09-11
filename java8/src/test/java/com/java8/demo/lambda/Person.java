package com.java8.demo.lambda;

import java.util.function.Function;

/**
 * 函数接口:只有一个函数的接口称为函数接口,默认的方法和静态方法除外
 * */
@FunctionalInterface//显示表明该为函数接口
public interface Person {

    public void eat(String str);

    //默认方法
    default void defaultMethod(String string) {
        System.out.println("defaultMethod....."+string);
    }

    //静态方法
    static void staticMethod() {
        System.out.println("staticMethod.....");
    }

}
