package cn.com.dom4j.aop.hello;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月10日
 * @desc
 */
public class HelloWorldImplFirst implements HelloWorld {

    @Override
    public void printHelloWorld() {
        System.out.println("Hello World implement first --> printHelloWorld()");
    }

    @Override
    public void doPrint() {
        System.out.println("Hello World implement first --> doPrint()");
    }
}
