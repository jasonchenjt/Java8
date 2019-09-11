package com.java8.demo.inter;

public interface Domain {

    int sum(int a, int b);

    default int sum2 (int a, int b){
        return a+b;
    }

    static  int sum3(int a, int b){
        return a+b;
    }
}
