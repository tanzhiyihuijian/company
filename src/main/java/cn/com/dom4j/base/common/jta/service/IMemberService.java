package cn.com.dom4j.base.common.jta.service;

import cn.com.dom4j.base.common.jta.entity.Member;
import cn.com.dom4j.base.common.jta.entity.MemberInfo;
import org.springframework.stereotype.Service;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月09日
 * @desc
 */
@Service
public interface IMemberService {

    boolean registerMember(Member member, MemberInfo memberInfo);

}
