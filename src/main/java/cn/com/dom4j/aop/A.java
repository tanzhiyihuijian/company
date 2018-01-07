package cn.com.dom4j.aop;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年11月10日
 * @desc
 */
public class A {

    public static void main(String[] args) {

        f2();



    }

    private static void f2() {

        String str = "";

        boolean b = haveEmoji(str);

        System.out.println(b);

    }


    public static boolean haveEmoji(String content) {
        try {
            int num = 0;
            for (int i = 0; i < content.length(); i++) {
                String one = content.substring(i, i + 1);
                num += one.getBytes("utf-8").length;
            }

            if (num != content.getBytes("utf-8").length) {
                return true;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return true;
        }

        return false;
    }


    private static void f1() {
        String[] shopIds = {"2", "4", "8", "1", null, "9", "11"};

        String shopId;

        List<Integer> list = new ArrayList<>();

        int i = 0;
        while ((shopId = shopIds[i++]) != null) {
            if (!NumberUtils.isNumber(StringUtils.trim(shopId))) {
                throw new RuntimeException("店铺：" + shopId + " 不是合法的编号");
            }

            System.out.println("====== shopId " + shopId);
            int sid = Integer.valueOf(StringUtils.trim(shopId));
            list.add(sid);
        }

        System.out.println(list);

        System.out.println(shopId);
    }






}
