package cn.com.dom4j.base.common;

import org.apache.commons.lang3.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月07日
 * @desc
 */
public class LinkageRoutingDataSource extends AbstractRoutingDataSource {

    // 目标数据源
    private static final ThreadLocal<String> TARGET_DATA_SOURCE = new ThreadLocal<>();

    // 默认数据源 - 指标监控的
    private static final String DEFAULT_DATA_SOURCE = "writeDataSource";

    // 根据 PrvncUtil类设置进去的当前线程数据源进行数据源切换
    @Override
    protected Object determineCurrentLookupKey() {

        String targetDataSource = TARGET_DATA_SOURCE.get();
        if (StringUtils.isEmpty(targetDataSource)) {
            targetDataSource = DEFAULT_DATA_SOURCE; // 数据源默认为指标监控数据源
            TARGET_DATA_SOURCE.set(targetDataSource);
        }
        System.out.println("当前线程数据源----------------:" + targetDataSource);
        return targetDataSource;
    }

    // 设置数据源名
    public static void setTargetDataSource(String target) {
        TARGET_DATA_SOURCE.set(target);
    }

    // 取出数据源
    public static String getTargetDataSource() {
        return TARGET_DATA_SOURCE.get();
    }
}
