package cn.com.dom4j.base.service.db.impl;

import cn.com.dom4j.base.dao.impl.ReadTableDao;
import cn.com.dom4j.base.model.po.ReadTable;
import cn.com.dom4j.base.service.db.IReadTableService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Service
public class ReadTableService implements IReadTableService {

    @Resource
    private ReadTableDao readTableDao;

    @Override
    public ReadTable getReadTableById(int id) {
        return readTableDao.getReadTableById(id);
    }
}
