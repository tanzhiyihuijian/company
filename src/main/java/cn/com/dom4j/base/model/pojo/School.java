package cn.com.dom4j.base.model.pojo;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月20日
 * @desc
 */
public class School {

    private String name;
    private String location;

    public School() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
