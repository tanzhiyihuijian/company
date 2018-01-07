package cn.com.dom4j.base.test.testng;

import org.junit.AfterClass;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年09月28日
 * @desc
 */
public class TestHelloWorld {

    private int index = 1;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("--------- beforeSuite  index = " + index++ + " --------");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("--------- afterSuite   index = " + index++ + " --------");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("--------- beforeClass  index = " + index++ + " --------");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("--------- afterClass  index = " + index++ + " --------");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("--------- beforeTest  index = " + index++ + " --------");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("--------- afterTest  index = " + index++ + " --------");
    }

    @BeforeGroups
    public void beforeGroups() {
        System.out.println("--------- beforeGroups  index = " + index++ + " --------");
    }

    @AfterGroups
    public void afterGroups() {
        System.out.println("--------- afterGroups  index = " + index++ + " --------");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("--------- beforeMethod  index = " + index++ + " --------");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("--------- afterMethod  index = " + index++ + " --------");
    }






    @Test
    public void testEmailGenerator() {

        RandomEmailGenerator generator = new RandomEmailGenerator();

        String email = generator.generate();

        Assert.assertNotNull(email);
        Assert.assertEquals(email, "bo.wang@laowantong.cc");

        System.out.println("--------- first test method  index = " + index++ + " --------");

    }


}
