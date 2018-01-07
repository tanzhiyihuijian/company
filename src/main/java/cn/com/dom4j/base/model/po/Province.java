package cn.com.dom4j.base.model.po;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月07日
 * @desc 省份
 */
public class Province {

    private int id;
    private String provinceId;
    private String province;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
