/**
 * 
 */
package cc.laowantong.utils;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.Random;

/**
 * @author Fermi(fermi@youleyu.com)
 * @date Mar 14, 2015
 * @desc
 */
public class RandomUtils {
	private static final Log GCW_LOG = LogFactory.getLog(RandomUtils.class.getName());


	private static final String RANDOM_SEED = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";// 初始化种子
	private static final String NUMBER_RANDOM_SEED = "0123456789";	// 初始化种子

	public static int miserRandom(int limit) {

		int intRandom = new Random().nextInt(limit);
		if (intRandom >= limit / 2 - 1) {
			intRandom = new Random().nextInt(limit);
			if (intRandom >= limit / 2) {
				intRandom = new Random().nextInt(limit);
				if (intRandom >= limit - 2) {
					intRandom = new Random().nextInt(limit);
					if (intRandom >= limit - 1) {
						intRandom = new Random().nextInt(limit);
					}
				}
			}
		}
		return intRandom;
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

	public static String randomNumber(int bit) {
		if (bit <= 0)
			bit = 10;
		return RandomStringUtils.random(bit, NUMBER_RANDOM_SEED);
	}


}
