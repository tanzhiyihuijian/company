package cn.com.dom4j.base.enumType;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月20日
 * @desc
 */
public enum GenderType {

    MAN(1, "男性"),
    FEMALE(2, "女性"),
    UNKONWN(3, "未知");

    private int type;
    private String value;


    GenderType(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }






}
