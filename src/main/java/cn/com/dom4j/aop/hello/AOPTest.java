package cn.com.dom4j.aop.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月10日
 * @desc
 */
public class AOPTest {

    public static void main(String[] args) {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/aop.xml");

//        HelloWorldImplFirst hw1 = ctx.getBean(HelloWorldImplFirst.class);
//        HelloWorldImplSecond hw2 = ctx.getBean(HelloWorldImplSecond.class);

        HelloWorld hw1 = (HelloWorld) ctx.getBean("helloWorldImplFirst");
        HelloWorld hw2 = (HelloWorld) ctx.getBean("helloWorldImplSecond");

        hw1.printHelloWorld();
        System.out.println("----------");
        hw1.doPrint();
        System.out.println("----------");

        System.out.println();

        hw2.printHelloWorld();
        System.out.println("----------");
        hw2.doPrint();
        System.out.println("----------");


    }

}
