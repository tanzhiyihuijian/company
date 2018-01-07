package cn.com.dom4j.base.service.db;

import cn.com.dom4j.base.model.po.City;
import cn.com.dom4j.base.service.BaseJunit4Test;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.annotation.Resource;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
//public class ICityServiceTest extends BaseJunit4Test {
public class ICityServiceTest {

    /*@Resource
    private ICityService cityService;

    @Test
    public void getCityById() throws Exception {

        City city = cityService.getCityById(1);

        System.out.println(city);

    }*/


    @Test
    public void f1() {

        ApplicationContext ctx = new FileSystemXmlApplicationContext("classpath:spring/applicationContext.xml");

        System.out.println(ctx);



    }




}