package cc.laowantong.util;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * @ClassName: DateUtil
 * @author bangqi.zheng
 * @Description: 日期时间相关 Util
 * @date 2012-6-27 下午3:44:05
 */
public class DateUtil {
	
	private static final Log LOG = LogFactory.getLog(DateUtil.class.getName());
	public static final String FORMAT_DATE ="yyyy-MM-dd";
	public static final String FORMAT_TIME ="yyyy-MM-dd HH:mm:ss";
	public static final String FORMAT_TIME_MILL ="yyyy-MM-dd HH:mm:ss.S";
	public static final String FORMAT_DATE_HOUR_MINUTE ="yyyy-MM-dd HH:mm";
	public static final String FORMAT_TIME_SHORT ="yyyyMMddHHmmss";
	public static final String FORMAT_DATE_SHORT ="yyyyMMdd";

	public static final long ONE_SECOND_MILL = 1000;
	public static final long ONE_MINUTE_MILL = 1000 * 60;
	public static final long ONE_HOUR_MILL = 1000 * 60 * 60;
	public static final long ONE_DAY_MILL = 1000 * 60 * 60 *24;
	public static final long ONE_MONTH_MILL = 1000l * 60 * 60 *24*30;
	public static final long ONE_HALF_MONTH_MILL = 1000l * 60 * 60 *24*15;
	public static final long ONE_WEEK_MILL = 1000l * 60 * 60 *24*7;
	public static final long EIGHT_MILL = 1000 * 60 * 60 *8;

	java.text.DecimalFormat  DF_ONE =new java.text.DecimalFormat("#.0");

	public static String dateFormat(Date date,String pattern){
		DateFormat df = null;
		if(date==null){
			return null;
		}
		if(StringUtils.isNotBlank(pattern)){
			df = new SimpleDateFormat(pattern);
		}else{
			df = new SimpleDateFormat(FORMAT_TIME);
		}
		return df.format(date);
	}
		
	public static Date dateFormat(String date,String pattern){
		DateFormat df = null;
		try {
			if(StringUtils.isNotBlank(date)){
				if(StringUtils.isNotBlank(pattern)){
					df = new SimpleDateFormat(pattern);
				}else{
					df = new SimpleDateFormat(FORMAT_TIME);
				}
				return df.parse(date);
			}			
		} catch (ParseException e) {				
			LOG.error("Convert dateString to date error!", e);				
		}
		return null;
	}

	/**
	 * Date 转 String
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToStr(Date date, String format) throws Exception{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}
	/**
	 * 
	 * @param date
	 * @param numDay
	 * @return
	 */
	public static Date computeDay(Date date, int numDay) {
		Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.DATE, numDay); //日期增加或减少时间
       return c.getTime(); //结果
	}
	
	/**
	 * 
	 * @param date
	 * @param numHour
	 * @return
	 */
	public static Date computeHour(Date date, int numHour) {
		Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.HOUR, numHour); //日期增加或减少时间
       return c.getTime(); //结果
	}
	
	/**
	 * 
	 * @param date
	 * @param numMinute
	 * @return
	 */
	public static Date computeMinute(Date date, int numMinute) {
		Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.MINUTE, numMinute); //日期增加或减少时间
       return c.getTime(); //结果
	}
	/**
	 * String 转 Date
	 * @param dateStr
	 * @param format
	 * @return
	 * @throws Exception
	 */
		public static Date strToDate(String dateStr, String format) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	
	/**
	 * 订单时间是否失效
	 * @param orderCreatTime   订单创建时间
	 * @param payExpireTime    时间失效  分钟
	 * @return  失效返回 true   没失效返回false
	 */
	public static boolean ifOrderOvertime(Date orderCreatTime,String payExpireTime){
		
		boolean flag = true;
		try{
			Date nowTime = new Date();
			
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			
			String createTimeStr = df.format(orderCreatTime);
			String nowTimeStr = df.format(nowTime);
			
			long createTimeD1 = df.parse(createTimeStr).getTime();
			long nowTimeD2 = df.parse(nowTimeStr).getTime();
			
			
			//d3 = Math.abs((d1-d2)/1000/60/60/24);//时间间隔
			long betweenD3 = Math.abs((createTimeD1-nowTimeD2)/1000/60);//时间间隔  按秒
			
			betweenD3 = betweenD3*60; //换为秒
			long payExpireTimeInt = (long)Integer.parseInt(payExpireTime); //分钟
			payExpireTimeInt = payExpireTimeInt*60;  //换为秒
			if(betweenD3 >= (payExpireTimeInt)){
				//表示已经为失效订单
				flag = true;
			}else{
				//表示没有失效
				flag = false;
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			flag = true;
		}
		
		
		return flag;
		
		
	}
	
	
	/**
	 * 参数日期是否等于或者小于当前日期
	 * @param validate yymm
	 * @return  true: 参数有效期大于当前年月
	 *          false:参数有效期时间小于等于当前年月
	 */
	public static boolean  isActiveValidate(String validate){
		boolean flag =  true;
		try{
			
			if(StringUtils.isBlank(validate)){
				return false;
			}
			int storeDate = NumberUtils.toInt(validate, 0);
			if(storeDate!=0){
				int now = NumberUtils.toInt(DateUtil.dateFormat(new Date(), "yyMM"),-1);
				if(now >= storeDate ){
					flag = false;
					return flag;
				}else{
					flag = true;
					return flag;
				}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
		return flag;
	}
	public static String getWeekOfDate(Date dt) { 
        String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"}; 
        Calendar cal = Calendar.getInstance(); 
        cal.setTime(dt); 

        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; 
        if (w < 0) 
            w = 0; 

        return weekDays[w]; 
    } 
	
	/**
	 * 增加分钟时间 返回data类型
	 * @param date
	 * @param minute
	 * @return
	 */
	public static Date addMinute(Date date, int minute) {
		Calendar c = Calendar.getInstance();
        c.setTime(date);   //设置当前日期
        c.add(Calendar.MINUTE, minute); //日期增加或减少时间
       return c.getTime(); //结果
	}
	
	public static String addMinuteReStr(Date date,int minute,String dateFormat){
		String nowDateStr = "";
		try{
			Date nowDate = addMinute(date, minute);
			nowDateStr = dateToStr(nowDate, dateFormat);
		}catch(Exception e){
			e.printStackTrace();
		}
		return nowDateStr;
	}

	/**
	 * If the given date are same day
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Boolean isEqualDay(Date d1, Date d2) {
		if (d1 != null && d2 != null) {
			SimpleDateFormat sdf = new SimpleDateFormat(FORMAT_DATE);
			return StringUtils.equals(sdf.format(d1), sdf.format(d2));
		} else {
			return false;
		}
	}

	/** 
     * 比较两个日期之间的大小 
     *  
     * @param d1 
     * @param d2 
     * @return 前者大于后者返回true 反之false 
     */  
    public static boolean compareDate(Date d1, Date d2) {  
		if (d1 != null && d2 != null) {
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(d1);
			c2.setTime(d2);

			int result = c1.compareTo(c2);
			if (result >= 0)
				return true;
			else
				return false;
		} else {
			return false;
		}
    }


    public static String toShowDay(Date date) {
    	if (date == null) {
    		return "";
		}
		return toShowDay(date.getTime());

	}
    public static String toShowDay(long timemill) {
    	long nowMill = System.currentTimeMillis();
		long todayLong = (nowMill/ONE_DAY_MILL)*ONE_DAY_MILL-EIGHT_MILL;
		long m = timemill - todayLong;
		long daycount = m/ONE_DAY_MILL;

		if (m < 0 ) {
			daycount-=1;
		}

		if (daycount == 0) {
			return "今天";
		}else if(daycount == 1) {
			return "明天";
		}else if(daycount == 2) {
			return "后天";
		}else if(daycount == -1) {
			return "昨天";
		}else if(daycount == -2) {
			return "前天";
		}

		return dateFormat(new Date(timemill),FORMAT_TIME);
	}

	public static String dateToShow(Date date) {
		if (date == null) return "";
		return dateToShow(date.getTime());
	}

	public static String dateToShow(long mill) {
		long nowMill = System.currentTimeMillis();

		long timeLong = nowMill - mill;
		long count;

		String ba = "前";
		if (timeLong < 0) {
			timeLong = -timeLong;
			ba = "后";
		}

		if (timeLong > ONE_MONTH_MILL* 3) {
			return dateFormat(new Date(mill),FORMAT_DATE);
		} else if (timeLong > ONE_MONTH_MILL) {
			count = timeLong / ONE_MONTH_MILL;
			return count + "个月"+ba;
		}else if (timeLong > ONE_HALF_MONTH_MILL) {
			return "半个月"+ba;
		}else if (timeLong > ONE_WEEK_MILL) {
			count = timeLong / ONE_WEEK_MILL;
			return count +"周"+ba;
		} else if (timeLong > ONE_DAY_MILL) {
			count = timeLong / ONE_DAY_MILL;
			return count +"天"+ba;
		} else if (timeLong > ONE_HOUR_MILL) {
			count = timeLong / ONE_HOUR_MILL;
			return count +"小时"+ba;
		} else if (timeLong > ONE_MINUTE_MILL) {
			count = timeLong / ONE_MINUTE_MILL;
			return count +"分钟"+ba;
		} else if (timeLong >= ONE_SECOND_MILL) {
			count = timeLong / ONE_SECOND_MILL;
			return count +"秒"+ba;
		} else {
			double d = (double)timeLong / ONE_SECOND_MILL;
			if(d < 0.1) {
				return "现在";
			}
			return  String.format("%.1f",d) +"秒"+ba;
		}

	}


	/**
	 * 检测2个日期是否在同一周
	 */
	public static boolean isSameWeek(Date targetDate, Date sourceDate) {

		if (sourceDate == null || targetDate == null) {
			return false;
		}

		// 0.先把Date类型的对象转换Calendar类型的对象
		Calendar targetCal = Calendar.getInstance();
		Calendar sourceCal = Calendar.getInstance();

		targetCal.setTime(targetDate);
		sourceCal.setTime(sourceDate);

		targetCal.setFirstDayOfWeek(Calendar.MONDAY);
		sourceCal.setFirstDayOfWeek(Calendar.MONDAY);

		//比较当前日期在年份中的周数是否相同
		if (targetCal.get(Calendar.WEEK_OF_YEAR) == sourceCal.get(Calendar.WEEK_OF_YEAR)) {
			return true;
		} else {
			return false;
		}
	}

	public static Date getWeekStartTime() {
		Calendar currentDate = new GregorianCalendar();
		currentDate.setFirstDayOfWeek(Calendar.MONDAY);

		currentDate.set(Calendar.HOUR_OF_DAY, 0);
		currentDate.set(Calendar.MINUTE, 0);
		currentDate.set(Calendar.SECOND, 0);
		currentDate.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		return (Date)currentDate.getTime().clone();
	}

	public static Date getWeekEndTime() {
		Calendar currentDate = new GregorianCalendar();
		currentDate.setFirstDayOfWeek(Calendar.MONDAY);
		currentDate.set(Calendar.HOUR_OF_DAY, 23);
		currentDate.set(Calendar.MINUTE, 59);
		currentDate.set(Calendar.SECOND, 59);
		currentDate.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return (Date)currentDate.getTime().clone();
	}

	public static void main(String[] args) {
//		try {
////			System.out.println(DateUtil.dateToStr(new Date(), "yyyy-MM-dd HH:mm:ss.S"));
//			//System.out.println(DateUtil.dateFormat(DateUtil.computeHour(new Date(), -2), DateUtil.FORMAT_TIME));
//			/*Date d=dateFormat("2012-12-12 12:12:12", "yyyy-MM-dd HH:mm:ss");
//			System.out.println(d);*/
//			//System.out.println(DateUtil.isActiveValidate("1311"));
//			System.out.println(DateUtil.getWeekOfDate(new Date()));
//			//System.out.println(DateUtil.isActiveValidate("1311"));
//			/*Date d1 = new Date();
//			System.out.println(d1);
//			String dateStr = addMinuteReStr(d1, 1, FORMAT_TIME_SHORT);
//			System.out.println(dateStr);*/
//			String payExpireTimeStr = "10";
//			if(StringUtils.isNotBlank(payExpireTimeStr) && (Integer.parseInt(payExpireTimeStr) > 1)){
//				System.out.println(111);
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		long m = System.currentTimeMillis();
//		System.out.println(dateFormat(new Date(m),FORMAT_TIME)+":"+toShowDay(m));
//		System.out.println(dateFormat(new Date(m-ONE_DAY_MILL  ),FORMAT_TIME_MILL)+":"+toShowDay(m-ONE_DAY_MILL  ));
//		System.out.println(dateFormat(new Date(m-ONE_DAY_MILL*2),FORMAT_TIME_MILL)+":"+toShowDay(m-ONE_DAY_MILL*2));
//		System.out.println(dateFormat(new Date(m-ONE_DAY_MILL*3),FORMAT_TIME_MILL)+":"+toShowDay(m-ONE_DAY_MILL*3));
//		System.out.println(dateFormat(new Date(m-ONE_DAY_MILL*4),FORMAT_TIME_MILL)+":"+toShowDay(m-ONE_DAY_MILL*4));
//		System.out.println(dateFormat(new Date(m+ONE_DAY_MILL  ),FORMAT_TIME_MILL)+":"+toShowDay(m+ONE_DAY_MILL  ));
//		System.out.println(dateFormat(new Date(m+ONE_DAY_MILL*2),FORMAT_TIME)+":"+toShowDay(m+ONE_DAY_MILL*2));
//		System.out.println(dateFormat(new Date(m+ONE_DAY_MILL*3),FORMAT_TIME)+":"+toShowDay(m+ONE_DAY_MILL*3));
//		System.out.println(dateFormat(new Date(m+ONE_DAY_MILL*4),FORMAT_TIME)+":"+toShowDay(m+ONE_DAY_MILL*4));
//
//
//		System.out.println("---------------------------------");
//		String last = "";
//		long current = System.currentTimeMillis();
//		System.out.println("当前时间:"+dateFormat(new Date(current),FORMAT_TIME_MILL));
//		for (long i = 0; i < 10000000l;i++) {
//			long mm = current-i*100l;
//
//			String result = dateToShow(mm);
//			if (!result.equals(last)) {
//				System.out.println(dateFormat(new Date(mm),FORMAT_TIME_MILL)+":"+result);
//				last = result;
//			}
//		}
//		System.out.println("-----------------------------------");
//		current = System.currentTimeMillis();
//		System.out.println("当前时间:"+dateFormat(new Date(current),FORMAT_TIME_MILL));
//		for (long i = 0; i < 10000000l;i++) {
//			long mm = current+i*100l;
//
//			String result = dateToShow(mm);
//			if (!result.equals(last)) {
//				System.out.println(dateFormat(new Date(mm),FORMAT_TIME_MILL)+":"+result);
//				last = result;
//			}
//		}

		Date beginDate = new Date();
		Date endDate = computeHour(beginDate, 8);

		for (int i = 0; i < 20; i++) {
			System.out.println(randomDate(beginDate, endDate));
		}
	}

	/**
	 * 指定时间内获取随机日期
	 * @param beginDate 起始日期，格式为：yyyy-MM-dd
	 * @param endDate 结束日期，格式为：yyyy-MM-dd
	 * @return
	 */
	public static Date randomDate(Date beginDate, Date endDate){
		try {

			if (beginDate == null || endDate == null) {
				return null;
			}

			if(beginDate.getTime() >= endDate.getTime()){
				return null;
			}

			long date = random(beginDate.getTime(), endDate.getTime());

			return new Date(date);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static long random(long begin, long end){
		long rtn = begin + (long)(Math.random() * (end - begin));
		if(rtn == begin || rtn == end){
			return random(begin,end);
		}
		return rtn;
	}
}
