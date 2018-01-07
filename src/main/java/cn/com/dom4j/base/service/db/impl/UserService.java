package cn.com.dom4j.base.service.db.impl;

import cn.com.dom4j.base.dao.impl.UserDao;
import cn.com.dom4j.base.model.pojo.User;
import cn.com.dom4j.base.service.db.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
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
