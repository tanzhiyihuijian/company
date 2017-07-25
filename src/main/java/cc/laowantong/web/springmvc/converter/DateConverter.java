package cc.laowantong.web.springmvc.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 王波 on 2017/7/10 0010.
 */
public class DateConverter implements Converter<String, Date>{

    public Date convert(String source) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        // 指定日期/时间解析是否不严格
        sdf.setLenient(false);

        try {
            return sdf.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
