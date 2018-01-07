package cn.com.dom4j.base.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月07日
 * @desc 数据路由切换工具类, 实现切换数据源后 JDBCTemplate数据源重设
 */
@Component
public class JDBCTemplateUtil implements ApplicationContextAware {

    private JdbcTemplate jdbcTemplate;

    private ApplicationContext ctx;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = applicationContext;
    }

    public JdbcTemplate getJdbcTemplate() {

        String ds = LinkageRoutingDataSource.getTargetDataSource();
        if (StringUtils.isEmpty(ds)) {
            jdbcTemplate.setDataSource((DataSource) ctx.getBean(ds));
        }
        return jdbcTemplate;
    }

    @Resource
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
