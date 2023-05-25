package com.example;

import java.util.PriorityQueue;
import java.util.UUID;

public class GeospatialTest {
    public static void main(String[] args) {
//        PriorityQueue<String> strings = new PriorityQueue<>();
//        strings.add("a");
//        strings.add("b");
//        strings.add("c");
//        strings.add("d");
//        strings.add("e");
//        for (String string : strings) {
//            System.out.println(string);
//        }

        String str= UUID.randomUUID().toString();
        System.out.println(str.substring(0,15));
        System.out.println(str);
    }
}
