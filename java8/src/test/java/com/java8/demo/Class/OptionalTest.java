package com.java8.demo.Class;

import com.java8.demo.lambda.Children;
import org.junit.Test;

import java.util.Optional;


public class OptionalTest {

    @Test
   public void test(){

        Children children = new Children("Jason",24);
        Optional<Children> optionalChildren = Optional.of(children);

        Children children1=optionalChildren.get();

        assert children==children1;
            System.out.println(children1);

    }

    @Test
    /**
     *
     * optional 的方法:
     *      of()只能接收的一个不为null值
     *      ofNull()可以接收null值
     */
    public void test2(){

//        Children children = null;
        Children children = new Children("Jason",24);

        //of接受null报错:java.lang.NullPointerException
//        Optional<Children> optionalChildren = Optional.of(children);
        Optional<Children> optionalChildren2 = Optional.ofNullable(children);

        //Optional.isPresent():判断是否为空
        if(optionalChildren2.isPresent()){
            System.out.println(optionalChildren2.get());
        }

        //optional.ifPresent(Consumer<? super T> consumer):如果对象不为空,则执行重写方法
        optionalChildren2.ifPresent(System.out::println);
    }

    @Test
    /*
    * Optional.orElse:当optional为null时,则传递其他参数
    * Optional.orElseGet:当optional为null时,则传入Supplier函数接口
    * */
    public void test3(){

        Children children = null;
        Children children2 = new Children("Jason",24);

        Optional<Children> optionalChildren = Optional.ofNullable(children);

        Children children3 = optionalChildren.orElse(children);
        Children children4 = optionalChildren.orElse(children2);
        System.out.println(children3);
        System.out.println(children4);

        Children children5 = optionalChildren.orElseGet(Children::new);
        System.out.println(children5);
    }

    @Test
    /*
     *  对比orElse和orElseGet的区别:
     *   当optional为null时,它们之间没有区别,
     *   当optional不为null时,orElseGet不会执行Supplier的方法
     * */
    public void test4(){

        Children children = null;
        Children children2 = new Children("Jason",24);

        Optional<Children> optional_null = Optional.ofNullable(children);
        Optional<Children> optional_notNull  = Optional.ofNullable(children2);

        System.out.println("正在创建children3");
        Children children3 = optional_null.orElse(createChildren());
        System.out.println("正在创建children4");
        Children children4 = optional_null.orElseGet(()->createChildren());

        System.out.println("正在创建children5");
        Children children5 = optional_notNull.orElse(createChildren());
        System.out.println("正在创建children6");
        Children children6 = optional_notNull.orElseGet(()->createChildren());
    }

    public Children createChildren(){
        System.out.println("create new children!");
        return new Children();
    }

    @Test
    /*
     *  异常返回:
     * */
    public void test5(){

        Children children = null;
        Optional<Children> optionalChildren = Optional.ofNullable(children);

        Children children2 = optionalChildren.orElseThrow(MyException::new);
    }
}
