package cn.com.dom4j.base.service.db.impl;

import cn.com.dom4j.base.dao.impl.CityDao;
import cn.com.dom4j.base.model.po.City;
import cn.com.dom4j.base.service.db.ICityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Service
public class CityService implements ICityService {

    @Resource
    private CityDao cityDao;

    @Override
    public City getCityById(int id) {
        return cityDao.getCityById(id);
    }

    @Override
    public int updateCity(City city) {
        int i = cityDao.updateCity(city);

        Integer integer = null;

        boolean b = integer != 1;

        int x = 1 / 0;

        return i;
    }
}
