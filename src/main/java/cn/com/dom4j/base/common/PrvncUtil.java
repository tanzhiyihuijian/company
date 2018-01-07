package cn.com.dom4j.base.common;

import org.apache.commons.lang3.StringUtils;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月07日
 * @desc 设置获取当前线程名称
 */
public class PrvncUtil {

    // 默认数据源
    private static final String DEFAULT_DATA_SOURCE = "writeDataSource";

    // 设置需要用的数据源名称
    public static void setDataSourceName(String dataSourceName) {
        LinkageRoutingDataSource.setTargetDataSource(getDataSourceName(dataSourceName));
    }

    // 获取数据源名称
    public static String getDataSourceName(String dataSourceName) {
        String dataSource = dataSourceName;
        if (StringUtils.isEmpty(dataSource)) {
            dataSource = DEFAULT_DATA_SOURCE;
        }
        System.out.println("最终获取到的当前数据源的名称: " + dataSource);
        return dataSource;
    }


}
