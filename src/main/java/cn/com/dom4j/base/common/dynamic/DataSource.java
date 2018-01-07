package cn.com.dom4j.base.common.dynamic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    String value() default "writeDataSource";

}
