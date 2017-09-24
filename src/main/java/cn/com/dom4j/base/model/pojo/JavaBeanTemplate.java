package cn.com.dom4j.base.model.pojo;

import cn.com.dom4j.base.enumType.GenderType;
import com.google.gson.annotations.SerializedName;

import java.util.*;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月20日
 * @desc
 */
public class JavaBeanTemplate {

    private char grade;
    private int age;
    private double salary;
    private boolean isAdult;

    private String name;
    private String[] phones;

    @SerializedName("性别")
    private GenderType genderType;
    private Date birthday;
    private School school;

    private List<String> skills;
    private Set<String> hobby;
    private Map<String, Map<Integer, String>> todoList;


    private transient String ignore;


    public JavaBeanTemplate() {
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isAdult() {
        return isAdult;
    }

    public void setAdult(boolean adult) {
        isAdult = adult;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getPhones() {
        return phones;
    }

    public void setPhones(String[] phones) {
        this.phones = phones;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public Set<String> getHobby() {
        return hobby;
    }

    public void setHobby(Set<String> hobby) {
        this.hobby = hobby;
    }

    public Map<String, Map<Integer, String>> getTodoList() {
        return todoList;
    }

    public void setTodoList(Map<String, Map<Integer, String>> todoList) {
        this.todoList = todoList;
    }

    public String getIgnore() {
        return ignore;
    }

    public void setIgnore(String ignore) {
        this.ignore = ignore;
    }



    public static JavaBeanTemplate getBeanTemplate() {

        JavaBeanTemplate bean = new JavaBeanTemplate();

        School school = new School();
        school.setName("----- ヾ(◍°∇°◍)ﾉﾞ ------");
        school.setLocation("安徽省淮南市田家庵区");

        List<String> skill = new ArrayList<>();
        skill.add("Java");
        skill.add("Python");
        skill.add("Kotlin");
        skill.add("Groovy");

        Set<String> hobby = new HashSet<>();
        hobby.add("音乐");
        hobby.add("旅游");
        hobby.add("技术");

        Map<String, Map<Integer, String>> todoList = new HashMap<>();
        Map<Integer, String> item = new HashMap<>();
        item.put(1, "Java与 Json交互");
        item.put(2, "MongoDB与 JDBC");
        item.put(3, "Handlebars模板引擎");

        todoList.put("周一", item);


        bean.setName("----测试专用 bean模板------");
        bean.setPhones(new String[]{"13135541602", "13261201018", "15635606382"});
        bean.setAge(19);
        bean.setAdult(true);
        bean.setBirthday(new Date());
        bean.setGenderType(GenderType.MAN);
        bean.setSalary(3500.88d);
        bean.setSchool(school);
        bean.setGrade('A');
        bean.setSkills(skill);
        bean.setIgnore("ha");
        bean.setHobby(hobby);
        bean.setTodoList(todoList);

        return bean;

    }

    @Override
    public String toString() {
        return "JavaBeanTemplate{" +
                "grade=" + grade +
                ", age=" + age +
                ", salary=" + salary +
                ", isAdult=" + isAdult +
                ", name='" + name + '\'' +
                ", phones=" + Arrays.toString(phones) +
                ", genderType=" + genderType +
                ", birthday=" + birthday +
                ", school=" + school +
                ", skills=" + skills +
                ", hobby=" + hobby +
                ", todoList=" + todoList +
                ", ignore='" + ignore + '\'' +
                '}';
    }
}
