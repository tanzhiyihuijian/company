package cn.com.dom4j.base.common.jta.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月09日
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
        locations = {"classpath:atomikos/spring-context.xml",
                "classpath:properties/database.properties",
                "classpath:atomikos/mybatis-context.xml",
                "classpath:atomikos/mapper-context.xml",
                "classpath:atomikos/transaction-context.xml"})
public class JTATest {

}
