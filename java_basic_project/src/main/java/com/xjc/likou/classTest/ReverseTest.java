package com.xjc.likou.classTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ReverseTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        /*无参构造*/
//        Class<User> aClass = User.class;
//        User user = (User) aClass.newInstance();
//        user.setAge(39);
//        System.out.println(user.toString());
        /*带参构造*/
//        Class<User> userClass = User.class;

//        Constructor<User> constructor = null;
//        try {
//            constructor = userClass.getDeclaredConstructor(String.class);
//            constructor.setAccessible(true);
//            User test = constructor.newInstance("Test");
//            System.out.println(test);
//        } catch (NoSuchMethodException | InvocationTargetException e) {
//            e.printStackTrace();
//        }

//        Stream<Object> empty = Stream.empty();
//        Stream<String> generate = Stream.generate(() -> "echo");
//        System.out.println(generate);
//        System.out.println(empty);
//
//        List<String> stringList=new ArrayList<>();
//        Stream<String> stream = stringList.stream().map(String::toLowerCase);
//        System.out.println(stream);

        Stream<Double> doubleStream = Stream.generate(Math::random).limit(100).skip(1);
        doubleStream.forEach(e-> {
            System.out.println(e);

        });


    }

}



