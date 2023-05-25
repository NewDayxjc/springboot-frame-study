package com.xjc.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> strings =new ArrayList<>(10);
        System.out.println("size合并前"+strings.size());
        strings.add("1");
        strings.add("2");
        strings.add("3");

        int size = strings.size();


        strings.trimToSize();
        System.out.println("size合并后"+strings.size());
    }
}
