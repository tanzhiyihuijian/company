package cc.laowantong.util;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

/**
 * ValidateUtil
 * <p>Title: 校验电话号码等工具类</p>
 * <p>Description: </p>
 * <p>Date: 2011-4-12</p>
 * <p>Copyright: Copyright (c) 2011</p>
 * <p>Company: qunar.com</p>
 * @author shi.yan
 * @version 1.0
 */
public class ValidateUtil {
	public final static String MOBILE_REGEXP = "^1[34578][0-9]{9}$";
	public final static String INTER_MOBILE_REGEXP="^\\d{6,15}$";
    public final static String USERNAME_LOGIN_REGEXP = "^[0-9a-zA-Z_]{2,50}$";
	public final static String USERNAME_REGEXP = "^[0-9a-zA-Z]{2,16}$";
	public final static String PASSWORD_REGEXP = "^[0-9a-zA-Z~\\!\\@\\#\\$%\\^&\\*\\(\\)\\-\\_\\=\\+\\;\\:\\'\\\"\\,\\<\\.\\>\\/\\?\\\\]{4,30}$";
	public final static String EMAIL_REGEXP = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$";
	public final static String IS_9IGCW_DOMAIN = "^http[s]?://[\\.\\w-]+\\.9igcw\\.com[:]?\\d*(\\/?|\\/.*)$";
	public final static String IS_92WUDAO_DOMAIN = "^http[s]?://[\\.\\w-]+\\.92wudao\\.com[:]?\\d*(\\/?|\\/.*)$";
	public final static String IS_TOUCH_DOMAIN = "^/[h5]?[/]?[\\w-]*(\\/?|\\/.*)$";
	public final static String ZIPCODE_REGEXP = "^\\d{6}$";
	public final static String URL_REGEXP = "((http|ftp|https)://)?(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-#]*)?";


    public final static String VCODE_NUMBER_REGEXP = "^\\d{4,6}$";

    public static final Pattern NEW_MOBILE_PATTERN = Pattern.compile("^1\\d{2}.+");
    public static final Pattern NEW_EMAIL_PATTERN = Pattern
            .compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?).*$");
    /**
	 * 验证码
	 */
	public final static String VCODE_REGEXP = "^[0-9a-zA-Z]{2,4}$";
	/**
	 * 15 18 身份证
	 */	
	public final static String ID_CARD = "(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)";
	/**
	 * 英文名称  名和姓以/分割
	 */
	public final static String ENGLISH_NAME = "^[a-zA-Z]+/[a-zA-Z]+$";
	/**
	 * 大小写字母
	 */
	public final static String ABC_U_L = "^[a-zA-Z]+$";
	public static final String TOUCH_UA = ".*(iPhone|iPad|iPod|Android|UCWEB8|UCWEB9|UCWEB10|Windows).*";
	/**
	 * 校验密码格式
	 * @param src
	 * @return
	 */
	public static boolean validatePassword(String src) {
		if (src == null || src.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(PASSWORD_REGEXP, src);
	}

	/**
	 * 校验登录使用的用户名格式，可为手机号、邮箱、用户名
	 * @param src
	 * @return
	 */
	public static boolean validateUsernameLogin(String src) {
		if (src == null || src.trim().length() == 0) {
			return false;
		}
		if(src.indexOf("@") > -1){
			return Pattern.matches(EMAIL_REGEXP, src);
		}
		return Pattern.matches(USERNAME_LOGIN_REGEXP, src);
	}

	/**
	 * 校验用户名格式
	 * @param src
	 * @return
	 */
	public static boolean validateUsername(String src) {
		if (src == null || src.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(USERNAME_REGEXP, src);
	}

	/**
	 * 校验手机号格式
	 * @param src
	 * @return
	 */
	public static boolean validateMobile(String src) {
		if (src == null || src.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(MOBILE_REGEXP, src);
	}
  
	/**
	 * 校验国际手机号格式
	 * @param src
	 * @return
	 */
	public static boolean validateInterMobile(String src) {
        if (src == null || src.trim().length() == 0) {
            return false;
        }
        return Pattern.matches(INTER_MOBILE_REGEXP, src);
    }
	
    public static boolean validateEncryptedMobile(String src) {
        if (src == null || src.trim().length() == 0) {
            return false;
        }
        return NEW_MOBILE_PATTERN.matcher(src).find();
    }

	public static boolean isEmail(String mail) {
		if (mail == null || mail.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(EMAIL_REGEXP, mail);
	}

    public static boolean isEncryptedEmail(String mail) {
        if (mail == null || mail.trim().length() == 0) {
            return false;
        }
        return NEW_EMAIL_PATTERN.matcher(mail).find();
    }
	
	/**
	 * 校验验证码格式
	 * @param src
	 * @return
	 */
	public static boolean isVCode(String src){
		if (src == null || src.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(VCODE_REGEXP, src);
	}
	
	/**
	 * 校验身份证格式
	 * @param src
	 * @return
	 */
	public static boolean isIDCard(String src) {
		if (src == null || src.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(ID_CARD, src);
	}
	
	public static boolean validateEnglishName(String src) {
		if (src == null || src.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(ENGLISH_NAME, src);
	}
	
	public static boolean isAbcUL(String src) {
		if (src == null || src.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(ABC_U_L, src);
	}
	
	/**
	 * 校验是否是9i域名
	 * @param url
	 * @return
	 */
	public static boolean is9iDomain(String url) {
		if (url == null || url.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(IS_9IGCW_DOMAIN, url) || Pattern.matches(IS_92WUDAO_DOMAIN, url)  ;
	}
	
	/**
	 * 判断touch 或者 wap <br />
	 *  v : 1 强制wap， auto 根据ua判断 <br />
	 *  ua 为空时默认wap <br />
	 *  其余的touch
	 * @param request 
	 * @return true touch ,false  wap
	 */
	public static boolean validateTouchWap(HttpServletRequest request) {
		if(request == null) {
			return false;
		}
		String v = request.getParameter("v");
		if ("1".equals(v)) {
			return false;
		}else if("auto".equals(v)){
			String uaString = request.getHeader("user-agent");
			if (uaString == null) {
				return false;
			}
			return Pattern.matches(TOUCH_UA, uaString);
		}else{
				return true;
		}
	}
	
	public static boolean validateZipCode(String zipCode) {
		if (zipCode == null || zipCode.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(ZIPCODE_REGEXP, zipCode);
	}

	public static boolean validateUrl(String url) {
		if (url == null || url.trim().length() == 0) {
			return false;
		}
		return Pattern.matches(URL_REGEXP, url);
	}

	public static void main(String[] args) {

	}
	
}
