package cn.com.dom4j.base.common.jta.mapper;

import cn.com.dom4j.base.common.jta.entity.MemberInfo;
import org.springframework.stereotype.Repository;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月09日
 * @desc
 */
@Repository
public interface MemberInfoMapper {

    int insert(MemberInfo memberInfo);

}
