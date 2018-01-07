package cn.com.dom4j.base.common.jta;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Service
public interface IAtomTransactionService {

    void insertTest(ApplicationContext ctx) throws Exception;

}
