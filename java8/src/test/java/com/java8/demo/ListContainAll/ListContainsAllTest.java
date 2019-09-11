package com.java8.demo.ListContainAll;

import com.java8.demo.lambda.Children;

import java.util.ArrayList;
import java.util.List;

public class ListContainsAllTest {

    public static void main(String[] args) {
        Children c1 = new Children("Jason",24);
        Children c2 = new Children("Chen",25);
        Children c3 = new Children("jjjj",26);
        Children c4 = new Children("jjjj",26);

        List<Children>cList1 = new ArrayList<>();
        cList1.add(c1);
        cList1.add(c2);
        cList1.add(c3);

        List<Children>cList2 = new ArrayList<>();
        cList2.add(c4);
        cList2.add(c2);
        cList2.add(c1);

        if(cList2.containsAll(cList1) && cList1.containsAll(cList2)){
            System.out.println("the same");
        }else{
            System.out.println("false");
        }
    }



}
