package cn.com.dom4j.base.common.dynamic;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
public class TransactionAspect {

    private static final String DEFAULT_DATA_SOURCE = "writeDataSource";

    public void before(JoinPoint point) throws NoSuchMethodException {

        // 拦截的实体类
        Object target = point.getTarget();

        Signature signature = point.getSignature();
        // 拦截的方法名
        String methodName = signature.getName();
        // 拦截的方法的参数类型
        Class<?>[] parameterTypes = ((MethodSignature) signature).getMethod().getParameterTypes();

        Class<?> clazz = target.getClass();

        if (clazz == null) {
            return;
        }

        Method method = clazz.getMethod(methodName, parameterTypes);
        if (method != null && method.isAnnotationPresent(Transactional.class)) {
            TransactionDataSourceHolder.setDataSourceName(DEFAULT_DATA_SOURCE);
        }
    }

    public void after() {
        TransactionDataSourceHolder.clearDataSourceName();
    }


}
