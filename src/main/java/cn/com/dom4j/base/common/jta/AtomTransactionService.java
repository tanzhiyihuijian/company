package cn.com.dom4j.base.common.jta;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Service
public class AtomTransactionService implements IAtomTransactionService {



    @Override
    public void insertTest(ApplicationContext ctx) throws Exception {

        AtomBaseDao baseDao = ctx.getBean(AtomBaseDao.class);

        String str = "xxx";

        String masterSql = "insert into writetable (name) values (" + str + ")";
        String slaveSql = "insert into readtable (name) values (" + str + ")";

        baseDao.getMasterTemplate().execute(masterSql);
        baseDao.getSlaveTemplate().execute(slaveSql);

        throw new Exception();
    }
}
