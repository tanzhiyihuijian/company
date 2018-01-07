package cn.com.dom4j.base.common.jta;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
public class AtomTest {

    public AtomTest() {

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext-transaction.xml");

        AtomTransactionService service = ctx.getBean(AtomTransactionService.class);

        try {
            service.insertTest(ctx);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new AtomTest();
        System.out.println("done ....");
    }


}
