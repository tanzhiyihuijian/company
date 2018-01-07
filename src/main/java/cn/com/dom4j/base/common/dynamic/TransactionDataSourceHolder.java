package cn.com.dom4j.base.common.dynamic;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
public class TransactionDataSourceHolder {

    private static final ThreadLocal<String> THREAD_DATA_SOURCE = new ThreadLocal<>();

    public static void setDataSourceName(String dataSource) {
        THREAD_DATA_SOURCE.set(dataSource);
    }

    public static String getDataSourceName() {
        return THREAD_DATA_SOURCE.get();
    }

    public static void clearDataSourceName() {
        THREAD_DATA_SOURCE.remove();
    }



}
