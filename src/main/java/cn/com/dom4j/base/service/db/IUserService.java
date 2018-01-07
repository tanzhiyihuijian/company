package cn.com.dom4j.base.service.db;

import cn.com.dom4j.base.common.dynamic.DataSource;
import cn.com.dom4j.base.model.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Service
public interface IUserService {

    List<User> listUser();
}
