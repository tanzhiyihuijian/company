package cn.com.dom4j.base.dao.mapper;

import cn.com.dom4j.base.common.dynamic.DataSource;
import cn.com.dom4j.base.model.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月04日
 * @desc
 */
@Repository
public interface UserMapper {

    @DataSource("dataSource")
    List<User> listUser();


}
