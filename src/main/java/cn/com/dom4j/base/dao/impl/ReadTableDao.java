package cn.com.dom4j.base.dao.impl;

import cn.com.dom4j.base.dao.mapper.ReadTableMapper;
import cn.com.dom4j.base.model.po.ReadTable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Repository
public class ReadTableDao {

    @Resource
    private ReadTableMapper readTableMapper;

    public ReadTable getReadTableById(int id) {
        return readTableMapper.getReadTableById(id);
    }


}
