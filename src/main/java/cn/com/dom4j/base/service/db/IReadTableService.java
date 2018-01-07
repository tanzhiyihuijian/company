package cn.com.dom4j.base.service.db;

import cn.com.dom4j.base.model.po.ReadTable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月08日
 * @desc
 */
@Service
public interface IReadTableService {

    @Transactional
    ReadTable getReadTableById(int id);
}
