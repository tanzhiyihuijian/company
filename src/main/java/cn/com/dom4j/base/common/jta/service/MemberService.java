package cn.com.dom4j.base.common.jta.service;

import cn.com.dom4j.base.common.jta.entity.Member;
import cn.com.dom4j.base.common.jta.entity.MemberInfo;
import cn.com.dom4j.base.common.jta.mapper.MemberInfoMapper;
import cn.com.dom4j.base.common.jta.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月09日
 * @desc
 */
public class MemberService implements IMemberService {

    // LOg
    private static final Logger LOG = LoggerFactory.getLogger(MemberService.class);

    @Resource
    private MemberMapper memberMapper;

    @Resource
    private MemberInfoMapper memberInfoMapper;

    @Override
    public boolean registerMember(Member member, MemberInfo memberInfo) {

        boolean resRegister = false;
        try {
            if (memberMapper.insert(member) != 1) {
                throw new RuntimeException("注册用户: Member表数据插入不一致 !");
            }
            if (memberInfoMapper.insert(memberInfo) != 1) {
                throw new RuntimeException("注册用户: MemberInfo表数据插入不一致 !");
            }
            resRegister = true;
        } catch (Exception e) {
            LOG.info("注册用户: 数据库保存异常, ", e.getMessage());
            throw new RuntimeException("注册用户: 数据库保存异常 !");
        }
        return resRegister;
    }
}
