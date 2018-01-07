package cn.com.dom4j.base.common.jta;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import org.springframework.stereotype.Repository;

import java.util.Properties;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Repository
public class MasterAtomDataSource extends AtomikosDataSourceBean {

    public MasterAtomDataSource() {
        Properties props = new Properties();
        props.put("user", "root");
        props.put("password", "root");
        props.put("URL", "jdbc:mysql://localhost:3306/writeDB?autoReconnect=true");
        setXaDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlXADataSource");
        setUniqueResourceName("mysql_writeDB");
        setPoolSize(5);
        setXaProperties(props);
    }

}
