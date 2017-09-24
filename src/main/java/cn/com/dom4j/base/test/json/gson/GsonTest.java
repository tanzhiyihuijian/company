package cn.com.dom4j.base.test.json.gson;

import cn.com.dom4j.base.model.pojo.JavaBeanTemplate;
import cn.com.dom4j.base.model.pojo.User;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年08月20日
 * @desc
 */
public class GsonTest {

    private JavaBeanTemplate getBean() {
        return JavaBeanTemplate.getBeanTemplate();

    }

    @Test
    public void test1() {

        JavaBeanTemplate bean = getBean();

//        Gson gson = new Gson();

        GsonBuilder gsonBuilder = new GsonBuilder();
//        gsonBuilder.setPrettyPrinting();


        /*gsonBuilder.setFieldNamingStrategy(new FieldNamingStrategy() {
            @Override
            public String translateName(Field f) {

                return null;
            }
        });
*/


        /*gsonBuilder.setFieldNamingStrategy(f ->
                f.getType().equals(Date.class) ?
                        new SimpleDateFormat("yyyy-MM-dd").format(f) : f.getName());
        */

        Gson gson = gsonBuilder.create();

        String s = gson.toJson(bean);

        System.out.println(s);

    }

    @Test
    public void parseJson() throws IOException {

        File file = new File(GsonTest.class.getResource("/pretty.json").getFile());

        String content = FileUtils.readFileToString(file, "utf-8");

        Gson gson = new Gson();

        gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();


        JavaBeanTemplate bean = gson.fromJson(content, JavaBeanTemplate.class);


        System.out.println(bean);


    }


}
