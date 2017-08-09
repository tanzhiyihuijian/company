package cn.com.dom4j.base.dao.impl;

import cn.com.dom4j.base.dao.mapper.UserMapper;
import cn.com.dom4j.base.model.pojo.User;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月04日
 * @desc
 */
@Repository
public class UserDao {

    @Resource
    private UserMapper userMapper;

    public List<User> listUser() {
        return userMapper.listUser();
    }

}
