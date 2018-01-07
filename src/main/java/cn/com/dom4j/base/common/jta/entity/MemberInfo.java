package cn.com.dom4j.base.common.jta.entity;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月09日
 * @desc
 */
public class MemberInfo {

    private int id;
    private String nickname;
    private String realname;
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "MemberInfo{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", realname='" + realname + '\'' +
                ", age=" + age +
                '}';
    }
}
