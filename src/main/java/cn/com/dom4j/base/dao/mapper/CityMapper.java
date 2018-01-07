package cn.com.dom4j.base.dao.mapper;

import cn.com.dom4j.base.common.dynamic.DataSource;
import cn.com.dom4j.base.model.po.City;
import org.springframework.stereotype.Repository;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Repository
public interface CityMapper {

    @DataSource("dataSource")
    City getCityById(int id);

    @DataSource("dataSource")
    int updateCity(City city);
}
