package cn.com.dom4j.base.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年09月24日
 * @desc
 */
public class Demo1 {

    public static void main(String[] args) {

        Demo1 demo = new Demo1();

        demo.f1();


    }

    private List<Apple> initAppleList() {

        return Arrays.asList(new Apple("green", 120),
                new Apple("green", 160),
                new Apple("yellow", 150),
                new Apple("red", 100));
    }


    private void f1() {

        List<Apple> apples = initAppleList();

//        List<Apple> list = getApple(apples, "green");

//        List<Apple> list = findApple(apples, new GreenFilter());

        /*List<Apple> list = findApple(apples, new AppleFilter() {
            @Override
            public boolean filter(Apple apple) {
                return "yellow".equals(apple.getColor());
            }
        });*/

        List<Apple> list = findApple(apples, apple -> "red".equals(apple.getColor()));


        System.out.println(list);

        // Function<T, R>  --- R apply(T t)
        Function<String, Integer> functionLambda = String::length;
        Function<StringBuilder, String> cl = StringBuilder::toString;

        // Predicate<T>   --- boolean test(T t)
        Predicate<Apple> predicateLambda = s -> s.getColor().equals("green");

        // Consumer<T>  ---  void accept(T t)
        Consumer<String> consumerLambda = System.out::println;


        // Supplier<T>  ---  T get()
        Supplier<Apple> supplierLambda = () -> new Apple("red", 130);


        //
        MyFunction myFunction = (x, y) -> System.out.println("x = " + x + "; y = " + y);


    }

    @FunctionalInterface
    private interface MyFunction {
        void apply(int x, int y);
    }


    private List<Apple> getApple(List<Apple> apples, String color) {

        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if (color.equals(apple.getColor())) {
                list.add(apple);
            }
        }
        return list;
    }

    private List<Apple> findApple(List<Apple> apples, AppleFilter appleFilter) {

        List<Apple> list = new ArrayList<>();

        for (Apple apple : apples) {
            if (appleFilter.filter(apple)) {
                list.add(apple);
            }
        }
        return list;
    }

    private class GreenFilter implements AppleFilter {

        @Override
        public boolean filter(Apple apple) {
            return "green".equals(apple.getColor());
        }
    }


    // 策略模式
    @FunctionalInterface
    private interface AppleFilter {
        boolean filter(Apple apple);
    }


}
