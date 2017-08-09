package cn.com.dom4j.base.service.impl;

import cn.com.dom4j.base.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月08日
 * @desc
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springmvc.xml", "classpath:spring/applicationContext-*.xml"})
public class UserServiceTest {

    @Resource
    private IUserService userService;

    @Test
    public void listUser() throws Exception {

        userService.listUser();


    }

}