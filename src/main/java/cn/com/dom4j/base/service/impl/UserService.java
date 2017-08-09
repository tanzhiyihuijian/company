package cn.com.dom4j.base.service.impl;

import cn.com.dom4j.base.model.pojo.User;
import cn.com.dom4j.base.dao.impl.UserDao;
import cn.com.dom4j.base.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by 王波 on 2017/7/11
 */
@Service
public class UserService implements IUserService {

    @Resource
    private UserDao userDao;

    @Override
    public List<User> listUser() {
        return userDao.listUser();
    }
}
