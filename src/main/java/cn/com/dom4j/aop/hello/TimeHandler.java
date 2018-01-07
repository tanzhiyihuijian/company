package cn.com.dom4j.aop.hello;

import java.util.Date;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月10日
 * @desc 横切关注点: 这里是打印时间
 */
public class TimeHandler {

    public void printTime() {
        System.out.println("currentTime is : " + new Date(System.currentTimeMillis()));
    }

}
