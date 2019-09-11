package com.java8.demo.Class;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionTest {

    @Test
    public void test(){

        Function<String,Integer> changeToInt = Integer::parseInt;
        List<String> strings = Arrays.asList("1","2","3");
        strings.stream().map(changeToInt::apply).forEach((x)->{
            System.out.println(x);
            System.out.println(x instanceof Integer);
        });
    }
}
