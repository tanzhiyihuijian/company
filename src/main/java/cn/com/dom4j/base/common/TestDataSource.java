package cn.com.dom4j.base.common;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月07日
 * @desc
 */
public class TestDataSource {

    public static void main(String[] args) {

        PrvncUtil.setDataSourceName("readDataSource");
        JDBCTemplateUtil jdbcTemplateUtil = new JDBCTemplateUtil();

        JdbcTemplate jdbcTemplate = jdbcTemplateUtil.getJdbcTemplate();

        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from readTable");

        System.out.println(maps);

    }


}
