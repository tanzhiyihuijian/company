package cn.com.dom4j.base.test.json;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月20日
 * @desc
 */
public class Test1 {


    /**

     1. xxx -> json
        new JSONObject()
        map
        javabean
        string | file



     2. json -> java-obj
            org.json不支持


     */


    public static void main(String[] args) {

        f1();

    }


    @Test
    public void readJson() throws IOException {

        File file = new File(Test1.class.getResource("/wang.json").getFile());
        String content = FileUtils.readFileToString(file, "utf-8");

        JSONObject jsonObject = new JSONObject(content);

        if (!jsonObject.isNull("name"))
            System.out.println("name : " + jsonObject.getString("name"));


        System.out.println("age : " + jsonObject.getDouble("age"));
        System.out.println("has_girlfriend : " + jsonObject.getBoolean("has_girlfriend"));
        JSONArray major = jsonObject.getJSONArray("major");

        for (int i = 0; i < major.length(); i++) {
            System.out.println("major-" + (i + 1) + " : " + major.get(i));
        }

    }


    private  <K, V> void print(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }


    private void writeJson() {


    }

    /*
     {
        "name" : "王小二",
        "age" : 25.2,
        "birthday" : "1990-01-01",
        "school" : "蓝翔",
        "major" : ["理发", "挖掘机"],
        "has_girlfriend" : false,
        "car" : null,
        "house" : null
    }
     */

    // 通过 JSONObject构建 json
    private static void f1() {

        Object nullObj = null;

        JSONObject wang = new JSONObject();
        wang.put("name", "王小二");
        wang.put("age", 25.2);
        wang.put("birthday", "1990-01-01");
        wang.put("school", new String[]{"理发", "挖掘机"});
        wang.put("has_girlfriend", false);
        wang.put("car", nullObj);
        wang.put("house", nullObj);
        wang.put("comment", "这是一个注释");

        System.out.println(wang.toString());
    }

    // 通过 HashMap构建 json
    private JSONObject createJsonByMap(HashMap map) {
        return new JSONObject(map);
    }

    // 通过 java bean构建 json
    private static  JSONObject createJsonByBean(Object obj) {
        return new JSONObject(obj);
    }




}
