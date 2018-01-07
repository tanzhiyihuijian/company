package cn.com.dom4j.base.common.jta;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Repository
public class AtomBaseDao {

    private JdbcTemplate masterTemplate;
    private JdbcTemplate slaveTemplate;

    public JdbcTemplate getMasterTemplate() {
        return masterTemplate;
    }

    @Resource(name = "masterAtomDataSource")
    public void setMasterTemplate(DataSource dataSource) {
        this.masterTemplate = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getSlaveTemplate() {
        return slaveTemplate;
    }

    @Resource(name = "slaveAtomDataSource")
    public void setSlaveTemplate(DataSource dataSource) {
        this.slaveTemplate = new JdbcTemplate(dataSource);
    }
}
