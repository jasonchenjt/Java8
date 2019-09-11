package com.java8.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Java8ApplicationTests {

    @Test
    /*
    * ==:基本类型就直接比较数值,引用类型就比较引用地址
    * equals:比较对象是否相等:
    *       当没有重写对象的equals方法时,直接比较两个对象是否为同一个对象,即比较对象的地址是否相等,
    *       当重写对象的equals方法,则比较对象地址,属性各方面是否相等
    * */
    public void test(){
        //String类型a b变量存储在栈,"123"存储在常量池
        //由于常量池数据共享,a 和 b指向同一个常量池地址
        //c 不是显示赋值,是新建一个String对象,所以new String("123")存储在堆中,所以地址不相同
        String a = "123";
        String b = "123";
        String c = new String("123");

        System.out.println(a==b);//true
        System.out.println(a==c);//false
        System.out.println("-----------------------");
        System.out.println(a.equals(b));//true
        System.out.println(a.equals(c));//true
    }

}
