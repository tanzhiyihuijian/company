package cc.laowantong.utils;

import cc.laowantong.utils.security.md5.MD5Object;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* @ClassName: StringUtil   
* @Description: 自定义字符串工具类
* @author bangqi.zheng
* @date 2014-8-1 下午3:33:19     
*/ 
public class GCWStringUtil {
	
	private static final String RANDOM_SEED = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";// 初始化种子
	private static final String RANDOM_NUMBER_SEED = "0123456789";// 初始化种子

	private static final String ZONE_URL = "https://m.9igcw.com/user/zone-%s.html?sign=%s";

	private static final String ALBUM_URL = "https://m.9igcw.com/alb-%s.html";

	/**
	 * 判断字符中是否含有表情
	 */
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
	/**
	 * 手机号打码
	 * @param phone
	 * @return
     */
	public static String maskMobile(String phone) {

		if (StringUtils.isNotBlank(phone) && isMobileNumber(phone)) {
			return StringUtils.overlay(phone, "*****", 3, phone.length()-4);
		}

		return null;
	}
	/**
	* @Title: random   
	* @Description: 随即生成指定位数的含验证码字符串 
	* @param @param bit
	* @param @return
	* @return String   
	* @throws
	*/
	public static String random(int bit) {
		if (bit <= 0)
			bit = 10; 
		return RandomStringUtils.random(bit, RANDOM_SEED);
	}
	public static String randomNum(int bit) {
		if (bit <= 0)
			bit = 10; 
		return RandomStringUtils.random(bit, RANDOM_NUMBER_SEED);
	}

	/**
	* @Title: subStr   
	* @Description: 截取指定长度字符串 
	* @param @param subject
	* @param @param size
	* @param @return
	* @return String   
	* @throws
	*/
	public static String subStr(String subject, int size) {
		if (subject.length() > size) {
			subject = subject.substring(0, size);
		}
		return subject;
	}
	
	public static String numToStr(String str, int number) {
		String str_m = String.valueOf(number); 
		str_m=str.substring(0, str.length()-str_m.length())+str_m;
		
		return str_m;
	}

	/**
	 * Check if given String is a valid mobile number
	 * @param mobileNumber
	 * @return
	 */
	public static boolean isMobileNumber(String mobileNumber) {
		
		if (StringUtils.isEmpty(mobileNumber)) {
			return false;
		}
		
		Pattern pattern = Pattern.compile("^1[0-9]{10}$");
		Matcher matcher = pattern.matcher(mobileNumber);
		return matcher.matches();
	}

	/**
	 * Fiter in number 
	 * @param number
	 * @return
	*/
	public static String filterNumber(String number) {
		if (number == null) return number;
	    number = number.replaceAll("[^(0-9)]", "");
	    return number;
	}
	
	/**
	 * Filter in Alphabet
	 * @param alph
	 * @return
	 */
	public static String filterAlphabet(String alph) {
		if (alph == null) return alph;
	    alph = alph.replaceAll("[^(A-Za-z)]", "");
	    return alph;
	}
	
	/**
	 * Filter in Chinese
	 * @param chinese
	 * @return
	*/
	public static String filterChinese(String chinese) {
		if (chinese == null) return chinese;
	    chinese = chinese.replaceAll("[^(\\u4e00-\\u9fa5)]", "");
	    return chinese;
	}
	
	/**
	 * Filter in Number, Alphabet and Chinese
	 * @param character
	 * @return
	 */
	public static String filter(String character) {
		if (character == null) return character;
	    character = character.replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "");
	    return character;
	}
	
	public static String getFileExtension(String fileName) {
		String ext = "";
		if (StringUtils.isNotEmpty(fileName)) {
			ext = fileName.substring(fileName.lastIndexOf("."));
		}
		return ext;
	}
	
	public static String getFileName(String fileName) {
		String ext = "";
		if (StringUtils.isNotEmpty(fileName)) {
			ext = fileName.substring(0, fileName.lastIndexOf("."));
		}
		return ext;
	}

	public static boolean isMatchRegExp(String regExp, String target) {
		
		if (StringUtils.isEmpty(target) || StringUtils.isEmpty(regExp)) {
			return false;
		}
		
		Pattern pattern = Pattern.compile(regExp);
		Matcher matcher = pattern.matcher(target);
		return matcher.matches();
	}


	public static String generateNickname(String source ) {
        if (StringUtils.isBlank(source)) {
            source = RandomUtils.random(4);
        }else if (ValidateUtil.validateMobile(source)) {
			source = source.substring(7,11);
		}

		return "爱舞_" + source;

	}

	public static String getSchema(String schema, String url){
		String jumpSchemaUrl;
		try {
			String signKey = "9ijump";
			String trueSign = new MD5Object().MD5Sum(signKey + schema + url);

			jumpSchemaUrl = "http://i.9igcw.com/client/jump.html?s="
					+ URLEncoder.encode(schema, "UTF-8") + "&u=" + URLEncoder.encode(url, "UTF-8")
					+ "&sign=" +trueSign;

		} catch (Exception e) {
			return null;
		}
		return jumpSchemaUrl;
	}


	public static String removeNotChinese(String word) {
		if (word == null) {
			return null;
		}

		return word.replaceAll("[^\\u4e00-\\u9fa5]*","");
	}

	public static void main(String[] args) {
//		System.out.println("  ass  m  sss ss是工sz资微信 捡钱".replaceAll("[^\\u4e00-\\u9fa5]*",""));
		System.out.println("600001".compareTo("600000"));
		System.out.println("600001".compareTo("600001"));
		System.out.println("60001031".compareTo("60001033"));
		System.out.println("60001032".compareTo("60001033"));
		System.out.println("60001033".compareTo("60001033"));
	}


	public static boolean isDecimal(String orginal){
		return isMatch("[-+]{0,1}\\d+\\.\\d*|[-+]{0,1}\\d*\\.\\d+", orginal);
	}

	private static boolean isMatch(String regex, String orginal){
		if (orginal == null || orginal.trim().equals("")) {
			return false;
		}
		Pattern pattern = Pattern.compile(regex);
		Matcher isNum = pattern.matcher(orginal);
		return isNum.matches();
	}

	public static String prepareCount(int count) {
		if (count < 1000) {
			return count + "";
		} else if (count >= 1000 && count < 10000) {
			Double d = count/1000.0;
			BigDecimal bd = new BigDecimal(d);
			bd = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
			return bd + "千";
		} else if (count >= 10000) {
			Double d = count/10000.0;
			BigDecimal bd = new BigDecimal(d);
			bd = bd.setScale(1, BigDecimal.ROUND_HALF_UP);
			return bd + "万";
		}
		return "";
	}

    public static String trimAll(String str) {
		if(str == null) {
			return null;
		}
		return str.replaceAll(" ","");

    }
}