package cn.com.dom4j.base.service.business.impl;

import cn.com.dom4j.base.model.pojo.User;
import cn.com.dom4j.base.service.db.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


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

        List<User> users = userService.listUser();

        System.out.println(users);


    }

}