package com.java8.demo.stream;

import com.java8.demo.lambda.Children;
import com.java8.demo.lambda.Student;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    @Test
    public void testStream() {
      //使用Stream的静态方法of
      Stream<Integer> stream = Stream.of(0,1,2);
      stream.forEach(System.out::println);

      Integer[] integers = new Integer[3];
      integers[0] = 0;
      integers[1] = 1;
      integers[2] = 2;

      Stream<Integer> stream2 = Stream.of(integers);
      stream2.forEach(System.out::println);

      //使用Stream的iterate创建流
      //limit指定个数数量
      Stream<Integer> stream3 = Stream.iterate(0,(x)->x+2).limit(3);
      stream3.forEach(System.out::println);

      List<Integer> integerList = Arrays.asList(
              new Integer(1),
              new Integer(2),
              new Integer(3)
      );
      Stream<Integer> stream4 = integerList.stream();
      stream4.forEach(System.out::println);
    }

 /*   @Test
    public void testqubie(){
        List<Integer> integers = new ArrayList<>();
        for (int i =0;i<1000;i++){
            integers.add(i);
        }

        long startTime = System.currentTimeMillis();
    *//*    for (int i :integers) {

        }*//*
        for (int i =0;i<integers.size();i++){
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        startTime = System.currentTimeMillis();
        integers.stream().forEach((x)->{
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

        startTime = System.currentTimeMillis();
        integers.parallelStream().forEach((x)->{
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }*/

    @Test//过滤
    public void filterTest(){

        List<Children> childrens = Arrays.asList(
          new Children("AA",10),
          new Children("BB",22),
          new Children("CC",33),
          new Children("DD",44)
        );

        Stream<Children> strean = childrens.stream().filter((i)->i.getAge()>30);
        strean.forEach(System.out::println);
//        strean.forEach((i)->System.out.println(i));
    }

    @Test
    /*
    * 使用Predicate函数接口新建过滤条件
    * */
    public void filterPredicateTest(){

        Predicate<Children> predicate_age = (x)->x.getAge()>20;
        Predicate<Children> predicate_name = (x)->x.getName().startsWith("J");

        List<Children> childrens = Arrays.asList(
                new Children("Jam",24),
                new Children("Tom",25),
                new Children("Toto",19),
                new Children("Jimi",16)
        );
        childrens.stream().filter(predicate_age.and(predicate_name)).forEach(System.out::println);
        System.out.println("------------------");
        childrens.stream().filter(predicate_age.or(predicate_name)).forEach(System.out::println);
        System.out.println("------------------");
        childrens.stream().filter(predicate_age.negate().and(predicate_name.negate())).forEach(System.out::println);
    }

    @Test//跳过
    public void skipTest(){

        List<Children> childrens = Arrays.asList(
                new Children("AA",10),
                new Children("BB",22),
                new Children("CC",33),
                new Children("DD",44)
        );

        Stream<Children> streanBefore = childrens.stream();
        Stream<Children> streanAfter = childrens.stream().skip(2);
        streanBefore.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        streanAfter.forEach(System.out::println);
    }

    @Test
    /**
     * 如果去重失败,则需要重写hascode和equals方法
     * */
    public void distinctTest(){

        List<Children> childrens = Arrays.asList(
                new Children("AA",10),
                new Children("AA",10),
                new Children("BB",22),
                new Children("CC",33),
                new Children("CC",33),
                new Children("CC",33),
                new Children("DD",44)
        );

        Stream<Children> streanBefore = childrens.stream();
        Stream<Children> streanAfter = childrens.stream().distinct();
        streanBefore.forEach(System.out::println);
        System.out.println("--------------------------------------------------");
        streanAfter.forEach(System.out::println);
    }

    @Test
    //映射
    public void MapTest(){

        List<Children> childrens = Arrays.asList(
                new Children("AA",10),
                new Children("BB",22),
                new Children("CC",33),
                new Children("DD",44)
        );

        Stream<String> streanMap = childrens.stream().map(Children::getName);
        streanMap.forEach(System.out::println);
    }

    @Test
    //排序
    public void sortedTest(){

        List<Children> childrens = Arrays.asList(
                new Children("BB",22),
                new Children("CC",33),
                new Children("AA",10),
                new Children("DD",44)
        );

//        Stream <Children> sortedStream = childrens.stream().sorted();
//        Stream <Children> sortedStream = childrens.stream().sorted((x,y)->x.getName().compareTo(y.getName()));
        Stream <Children> sortedStream = childrens.stream().sorted((x,y)->x.getAge()-y.getAge());
        sortedStream.forEach(System.out::println);
    }

    @Test
    //匹配和查找
    public void matchTest(){

        List<Children> childrens = Arrays.asList(
                new Children("AA",10),
                new Children("BB",22),
                new Children("CC",33),
                new Children("DD",44)
        );

         //一个Stream只能使用一次Exception:stream has already been operated upon or closed
        //使用Supplier作为stream的生产商,每次使用get()方法获取一个新的stream对象
        Supplier<Stream <Children>> streamSupplier = ()-> childrens.stream();

        Boolean a = streamSupplier.get().allMatch((e)->e.getAge()>30);
        System.out.println("匹配所有的Children年龄是否都大于30:"+a);

        Boolean b = streamSupplier.get().anyMatch((e)->e.getAge()>30);
        System.out.println("匹配是否存在一个Children年龄大于30:"+b);

        Boolean c = streamSupplier.get().noneMatch((e)->e.getAge()>30);
        //如果存在一个或多个年龄大于40的Children就会返回false,不存在则返回true
        System.out.println("匹配是否不存在一个Children年龄等于30:"+c);
    }

    @Test
    //返回值
    public void ValueTest(){

        List<Children> childrens = Arrays.asList(
                new Children("AA",10),
                new Children("BB",22),
                new Children("CC",33),
                new Children("DD",44)
        );

        //一个Stream只能使用一次Exception:stream has already been operated upon or closed
        //使用Supplier作为stream的生产商,每次使用get()方法获取一个新的stream对象
        Supplier<Stream <Children>> streamSupplier = ()-> childrens.stream();

        //获取stream中第一个元素
        Optional<Children> optional = streamSupplier.get().findFirst();
        System.out.println(optional);

        //获取stream中任何元素(串行并行返回不相同)
        Optional<Children> optional2 = streamSupplier.get().findAny();
        System.out.println(optional2);

        //返回长度
        Long size = streamSupplier.get().count();
        System.out.println("长度:"+size);

        //返回最大值
        Optional<Children> optional3 = streamSupplier.get().max((a,b)->Integer.compare(a.getAge(),b.getAge()));
        System.out.println("年龄最大者:"+optional3);

        //返回最小值
        Optional<Children> optional4 = streamSupplier.get().min((a,b)->Integer.compare(a.getAge(),b.getAge()));
        System.out.println("年龄最小者:"+optional4);

        //统计
        IntSummaryStatistics intSummaryStatistics = streamSupplier.get().mapToInt(x->x.getAge()).summaryStatistics();
        System.out.println("年龄最大值:"+intSummaryStatistics.getMax());
        System.out.println("年龄最小值:"+intSummaryStatistics.getMin());
    }

    @Test
    /*
    * collect 将流转换成其他形式
    * */
    public void Colecttest(){

        List<Children> childrens = Arrays.asList(
                new Children("AA",10),
                new Children("BB",22),
                new Children("CC",33),
                new Children("DD",44)
        );

        List<String> stringList =  childrens.stream().map(Children::getName).sorted((x,y)->x.compareTo(y)).collect(Collectors.toList());
        stringList.forEach(System.out::println);

    }

}
