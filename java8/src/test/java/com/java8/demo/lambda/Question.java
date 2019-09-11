package com.java8.demo.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Question {

    @Test
    /*
     * Stream 中 Map 和 flatMap 的区别
     * */
    public void Maptest2(){
        List<Student> students = Arrays.asList(
                new Student("AA",new String[]{"篮球","1"}),
                new Student("BB",new String[]{"跳舞","2"}),
                new Student("CC",new String[]{"唱歌","3"})
        );
        Stream<String[]> stringStream = students.stream().map(x->x.getHobby());
        stringStream.forEach(System.out::println);
//        Stream<String[]> stringStream2 = students.stream().flatMap(x->x.getHobby());
//        System.out.println(stringStream);
    }
}
