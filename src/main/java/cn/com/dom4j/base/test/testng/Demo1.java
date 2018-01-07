package cn.com.dom4j.base.test.testng;

import freemarker.template.SimpleDate;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;

import javax.print.CancelablePrintJob;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年10月27日
 * @desc
 */
public class Demo1 {

    public static void main(String[] args) throws ParseException {

        // 获取 年月日 时分秒
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = sdf.parse("2017-10-28 00:00:00");
        Date date = new Date();

        calendar.setTime(date);

        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        Date d1 = new Date();

        DateTime dateTime = new DateTime(d1);


        year = dateTime.getYear();
        int monthOfYear = dateTime.getMonthOfYear();
        int dayOfYear = dateTime.getDayOfYear();
        dayOfMonth = dateTime.getDayOfMonth();
        dayOfWeek = dateTime.getDayOfWeek();
        int hourOfDay = dateTime.getHourOfDay();
        int minuteOfHour = dateTime.getMinuteOfHour();
        int minuteOfDay = dateTime.getMinuteOfDay();
        int secondOfDay = dateTime.getSecondOfDay();
        int secondOfMinute = dateTime.getSecondOfMinute();


        System.out.println(year);

    }


    /**
     * 获取指定日期 前几天(负数) 或 后几天的日期 (正数)
     * @param date 指定日期
     * @param day 相差的天数, 负数表示指定日期的前几天, 正数表示后几天
     * @return calendar obj
     */
    public static Date getDateApartDay(Date date, int day) {
        Calendar c1 = Calendar.getInstance();
        c1.setTimeInMillis(getMillis(date) + ((long) day) * 24 * 3600 * 1000);
        return c1.getTime();
    }

    /**
     * 返回指定日期的毫秒数
     *
     * @param date 指定日期
     * @return 毫秒数
     */
    public static long getMillis(Date date) {
        if (date == null) {
            date = new Date();
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.getTimeInMillis();
    }


}
