package cn.com.dom4j.base.test.json;

import cn.com.dom4j.base.common.util.MD5Object;
import cn.com.dom4j.base.common.util.RandomUtils;
import cn.com.dom4j.base.model.pojo.User;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import net.sf.cglib.beans.BeanMap;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    private static final byte[] DES_KEY = { 22, 99, -109, 77, -33, 27, -127, 47 };

    public static void main(String[] args) {

//        f1();
//        f2();

//        String name = "顺德丝奇最新原创：'窗外\"姐妹篇《乡间的小路》原创编舞附教学（纯净版）";

//        f3();
//        f4();
//        f5();
//        f6();
//        f7();
//        f8();

//        List<Date> dateTravelDays = getDateTravelDays(Date.class);
//
//        System.out.println(dateTravelDays.getClass());



//        f9();
//        f10();
//        f11();

//        f12();
//       f13();

//        f14();
//            f15();
//        f16();

     /*   List<String> rowData = new ArrayList<>();
        rowData.add("张三");
        rowData.add("13261201018");
        rowData.add("北京市昌平区");
        List<List<String>> body = new ArrayList<>();
        body.add(rowData);


        Map<String, Object> columnParams = createColumnParams(new int[]{20, 30, 40}, new String[]{"name", "phone", "address"}, body);

        System.out.println(columnParams);*/


//        f18();

//        f19();

//        f20();


//        f17("name, activityId, clubId, createTime, valid");

//        f21();

//        f22();


        f23();



    }

    private static void f23() {

        System.out.println(1 % 0);

    }

    private static void f22() {

        String password = RandomUtils.random(6, RandomUtils.RANDOM_SEED_REMOVE_CONFUSING_STRING);

        System.out.println(password);

        password = new MD5Object().MD5Sum(password).toUpperCase();

        System.out.println(password);


    }

    private static void f21() {

        String str = "1, 2222,   3,     36, 5,6,          7";

        String regex = "(,\\s*)|(\\s+)";

        Pattern pattern = Pattern.compile(regex);

        str = str.replaceAll(regex, "-");

        System.out.println(str);




    }


    private static void f20() {

        Map<String, Object> map = new HashMap<>();
        map.put("success", false);

        boolean result = isTrue(map, "success", "ssss");

        System.out.println(result);

    }

    /**
     * 判断某个 map中的 key = success时, value = true ?
     * @param map map
     * @return boolean result
     */
    public static boolean isTrue(Map<String, Object> map) {
        return isTrue(map, "success", true);
    }

    /**
     * 判断 map中某个 key对应的 value是否为 指定值 (是返回 true, 否则返回 false)
     * @param map map
     * @param key key
     * @return boolean result
     * @desc 暂只支持 Boolean, Integer, String 类型
     */
    public static boolean isTrue(Map<String, Object> map, String key, Object trueValue) {
        Object value = map.get(key);
        if (value == null || trueValue == null)
            return false;

        if (value instanceof Boolean) {
            return value.equals(trueValue);
        }
        if (value instanceof String) {
            return value.equals(trueValue);
        }
        if (value instanceof Integer) {
            return value.equals(trueValue);
        }
        return false;
    }

    /**
     * 判断 map中某个 key对应的 value是否为 指定值 (是返回 false, 否则返回 true)
     * @param map map
     * @param key key
     * @return boolean result
     * @desc 暂只支持 Boolean, Integer, String 类型
     */
    public static boolean isFalse(Map<String, Object> map, String key, Object trueValue) {
        return !isTrue(map, key, trueValue);
    }

    private static void f19() {

        Map<String, Object> map = new HashMap<>();

        boolean success = (Boolean) map.get("success");

        System.out.println(success);

    }

    private static void f18() {

        List<User> list = new ArrayList<>();

        list.add(null);

        System.out.println(list.size());

        for (User user : list) {
            String password = user.getPassword();
            System.out.println("password: " + password);
        }


        boolean empty = CollectionUtils.isEmpty(list);

        System.out.println(empty);

    }

    public static Map<String, Object> createColumnParams(int[] columnWidth, String[] title, List<List<String>> body) {

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("success", false);

        if (columnWidth == null || columnWidth.length == 0) {
            result.put("message", "列宽设置为空");
            return result;
        }
        if (title.length == 0) {
            result.put("message", "表头不得为空");
            return result;
        }
        if (CollectionUtils.isEmpty(body)) {
            result.put("message", "表格数据不得为空");
            return result;
        }

        List<String> rowData = body.get(0);
        if (CollectionUtils.isEmpty(rowData)) {
            result.put("message", "表格行数据不得为空");
            return result;
        }

        if (columnWidth.length != title.length || columnWidth.length != rowData.size()) {
            result.put("message", "列宽,表格头,表格体长度不一致!");
            return result;
        }

        Object[][] columnParams = new Object[title.length][3];
        for (int i = 0; i < title.length; i++) {
            columnParams[i][0] = columnWidth[i];
            columnParams[i][1] = title[i];
            columnParams[i][2] = rowData.get(i);
        }

        result.put("columnParams", columnParams);
        result.put("success", true);
        return result;
    }

    public static void f17(String str) {

        str = StringUtils.trimToEmpty(str);

        str = str.replaceAll(" ", "");
        str = str.replaceAll("\n", "");

        String[] split = str.split(",");

        StringBuilder result = new StringBuilder();
        for (String s : split) {
            result.append("#{").append(s).append("}, ");
        }

        System.out.println(result.substring(0, result.length() - 2));
    }

    private static void f16() {

        int i = NumberUtils.toInt("55.0", -1);

        System.out.println(i);

    }

    private static void f15() {

        Date d1 = new DateTime(2017, 12, 12, 0, 0, 0).toDate();

        boolean canChoose = DateUtils.truncatedCompareTo(d1, new Date(), Calendar.DATE) < 0;

        System.out.println(canChoose);



    }

    private static void f14() {

        List<String> list = new ArrayList<>();
        for (String str : list) {
            System.out.println(str);
        }


    }

    private static void f13() {

        List<User> users = new ArrayList<>();

        int index = 1;
        for (int i = 0; i < 10; i++) {

            User u = new User();
            u.setName("user - " + index++);
            u.setPassword("pass");

            users.add(u);
        }


        List<BeanMap> list = new ArrayList<>();
        for (User user : users) {

            BeanMap beanMap = BeanMap.create(users.get(0));
            beanMap.put("666", 666);

            list.add(beanMap);
        }

        Gson gson = new GsonBuilder().create();

        String s = gson.toJson(list);

        System.out.println(s);


        System.out.println("------------------------------");

        Map<String, Object> map = new HashMap<>();
        map.put("id", 666);
        map.put("name", "张三");
        map.put("password", "666");


        User user = mapToBean(map, new User());
        System.out.println(user);

        user = mapToBean(map, User.class);
        System.out.println(user);

    }

    public static <T> T mapToBean(Map<String, Object> map,T bean) {
        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    public static <T> T mapToBean(Map<String, Object> map, Class<T> clazz) {

        T bean = null;
        try {
            bean = clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        BeanMap beanMap = BeanMap.create(bean);
        beanMap.putAll(map);
        return bean;
    }

    private static void f12() {

        // username = bobo
        // password = l3l3ww41602

        String password = decryptBasedDes("F6DB8E219E3C017D67CC9B0F86B9B57F");
        System.out.println(password);
    }


    /**
     * 数据加密，算法（DES）
     *
     * @param data
     *            要进行加密的数据
     * @return 加密后的数据
     */
    public static String encryptBasedDes(String data) {
        String encryptedData = null;

        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(DES_KEY);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 加密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, key, sr);
            // 加密，并把字节数组编码成字符串
            encryptedData = new sun.misc.BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        } catch (Exception e) {
            throw new RuntimeException("加密错误，错误信息：", e);
        }
        return encryptedData;
    }

    /**
     * 数据解密，算法（DES）
     *
     * @param cryptData
     *            加密数据
     * @return 解密后的数据
     */
    public static String decryptBasedDes(String cryptData) {
        String decryptedData = null;
        try {
            // DES算法要求有一个可信任的随机数源
            SecureRandom sr = new SecureRandom();
            DESKeySpec deskey = new DESKeySpec(DES_KEY);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey key = keyFactory.generateSecret(deskey);
            // 解密对象
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, key, sr);
            // 把字符串解码为字节数组，并解密
            decryptedData = new String(cipher.doFinal(new sun.misc.BASE64Decoder().decodeBuffer(cryptData)));
        } catch (Exception e) {
//            log.error("解密错误，错误信息：", e);
            throw new RuntimeException("解密错误，错误信息：", e);
        }
        return decryptedData;
    }

    private static void f11() {

        DateTime startTime = new DateTime(DateTime.now().getYear(), DateTime.now().getMonthOfYear(), 1, 0, 0);
        DateTime endTime = startTime.plusMonths(1);

        System.out.println("startTime: " + startTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println("endTime: " + endTime.toString("yyyy-MM-dd HH:mm:ss"));

    }

    private static void f10() {
        DateTime startTime = new DateTime(DateTime.now().getYear(), DateTime.now().getMonthOfYear(), 1, 0, 0);
        DateTime endTime2 = startTime.plusMonths(1);
        System.out.println(startTime.toString("yyyy-MM-dd HH:mm:ss"));
        System.out.println(endTime2.toString("yyyy-MM-dd HH:mm:ss"));
    }

    private static void f9() {

        List<Map<String, Object>> refundRecords = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();

        map.put("name1", "\"张三");
        map.put("name2", "\'张三");
        map.put("name3", "?张三");

        refundRecords.add(map);


        for (Map<String, Object> stringObjectMap : refundRecords) {
            for (Map.Entry<String, Object> entry : stringObjectMap.entrySet()) {
                entry.setValue(filterQuotationMark(String.valueOf(entry.getValue())));
            }
        }

        System.out.println(refundRecords);
    }

    public static String filterQuotationMark(String str) {
        return StringUtils.replaceChars(StringUtils.replaceChars(str, "\'", ""), "\"", "");
    }




    private static void f8() {

        User user = new User();
        user.setName("哈哈哈");
        user.setPassword("23456789");

        Class<? extends User> clazz = user.getClass();




    }

    public static <T> List<T> getDateTravelDays(Class<T> clazz) {

        return new ArrayList<T>();
    }




    public static void f7() {

        try {
            Class<?> clazz = Class.forName("cn.com.dom4j.base.model.pojo.User");

            Object obj = clazz.newInstance();

            Field[] declaredFields = clazz.getDeclaredFields();

            for (Field field : declaredFields) {

                String fieldName = field.getName();

                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);

                Method writeMethod = propertyDescriptor.getWriteMethod();
                Method readMethod = propertyDescriptor.getReadMethod();

                if (StringUtils.equals(fieldName, "name")) {
                    writeMethod.invoke(obj, "哇哈哈");
                }

                if (StringUtils.equals(fieldName, "id")) {
                    writeMethod.invoke(obj, 666);
                }



                /*
                if (StringUtils.equals(fieldName, "name")) {

                    field

                }

                System.out.println(fieldName);*/




            }

            if (obj instanceof User) {

                User user = (User) obj;

                System.out.println("username : " + user.getName() + ", id : " + user.getId());

            }

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | IntrospectionException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }





    public static <T> T invoke(String methodName,  T t, Class<T> clazz) {

        Class<? extends Class> aClass = clazz.getClass();




        return null;
    }






    private static void f6() {
        DateTime d1 = new DateTime(DateUtils.truncate(new Date(), Calendar.DATE));
        DateTime d2 = new DateTime(2018,11,11,0,0,0);
        int x = d1.compareTo(d2);

        System.out.println(x);

    }

    private static void f5() {



        Date date = new DateTime().dayOfMonth().withMinimumValue().millisOfDay().withMinimumValue().toDate();


        System.out.println(date);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);
        System.out.println(format);

        date = new DateTime().dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue().toDate();
        format = sdf.format(date);


        System.out.println(format);

    }

    private static void f4() {

        Date date = DateUtils.truncate(new Date(), Calendar.DATE);



        System.out.println(date);


    }


    private static void f3() {
        String specInfo = "[{\"specId\":\"3\",\"specName\":\"克重\",\"children\":[{\"label\":\"200g\",\"value\":\"41\"},{\"label\":\"450g\",\"value\":\"233\"}],\"multiple\":2},{\"specId\":\"11\",\"specName\":\"出行时间\",\"children\":[{\"label\":\"2018-01-12\",\"value\":\"643\"},{\"label\":\"2018-01-20\",\"value\":\"644\"}],\"multiple\":1}]";

        List<String> travelTimeList = new ArrayList<>();

        Gson gson = new GsonBuilder().create();

        List<Map<String, Object>> specList = gson.fromJson(specInfo, new TypeToken<List<Map>>() {}.getType());

        for (Map<String, Object> map : specList) {

            boolean hasTravelTimeSpec = false;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();

                if (StringUtils.equals(key, "specId") && StringUtils.equals((String)value, "11")) {
                    hasTravelTimeSpec = true;
                }
            }

            if (hasTravelTimeSpec) {
                List<Map<String, String>> timeItemList = (List<Map<String, String>>) map.get("children");
                for (Map<String, String> timeItem : timeItemList) {

                    if (timeItem.containsKey("label")) {
                        travelTimeList.add(timeItem.get("label"));
                    }
                }
            }
        }


        System.out.println(travelTimeList);
    }

    private static void f2() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");

        String format = sdf.format(new Date());

        System.out.println(format);
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
