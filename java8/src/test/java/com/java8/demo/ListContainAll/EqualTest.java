package com.java8.demo.ListContainAll;

import org.junit.Test;

import java.util.*;

public class EqualTest {

    /**
     * == 和 equals的比较:
     * 当==比较基本数据类型时,比较的是数值,当==比较的是对象时,比较的是地址
     *
     */
    @Test
    public void test(){
        String  s1 = "123";
        String  s2 = "123";
        System.out.println(s1==s2);
        String  s3 = new String("123");
        System.out.println(s1==s3);
    }

    //查看String的equals的源码可以发现,它首先比较String引用使用指向同一个对象,然后再判断字符串的长度,最后判断每一个字符是否相等
    @Test
    public void testEquals(){
        String  s1 = "123";
        String  s2 = new String("123");
        System.out.println(s1.equals(s2));
    }

}
