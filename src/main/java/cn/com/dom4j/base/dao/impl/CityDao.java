package cn.com.dom4j.base.dao.impl;

import cn.com.dom4j.base.common.dynamic.DataSource;
import cn.com.dom4j.base.dao.mapper.CityMapper;
import cn.com.dom4j.base.model.po.City;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Repository
public class CityDao {

    @Resource
    private CityMapper cityMapper;

    public City getCityById(int id) {
        return cityMapper.getCityById(id);
    }

    public int updateCity(City city) {
        return cityMapper.updateCity(city);
    }
}
