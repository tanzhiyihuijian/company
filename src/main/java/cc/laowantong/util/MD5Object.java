package cc.laowantong.utils.security.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Object {
	private MessageDigest md = null;
	private MessageDigest sha = null;
	private long jishu[] = new long[8];
	
	public MD5Object(){
		try {
			md = MessageDigest.getInstance("MD5");
			sha = MessageDigest.getInstance("SHA-1");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		jishu[0] = 1;
		for ( int i = 1; i < 8; i++) {
			jishu[i] = jishu[i-1]*256;
		}		
	}
	
	public String SHASum(String input) {
		if (sha == null || input == null) {
			return null;
		}
		sha.reset();
		sha.update(input.getBytes());
		byte[] sign = sha.digest();
		
		return bytes2Hex(sign);
	}
	
	public String MD5Sum(String input) {
		if ( md == null ) {
			return null;
		}
		if ( input == null) {
			return null;
		}
		
		md.reset();
		md.update(input.getBytes());
		byte[] sign = md.digest();
		
		return bytes2Hex(sign);
	}	
	
	
	public Long MD5To64Bit(String input) {
		if ( md == null ) {
			return null;
		}
		if ( input == null) {
			return null;
		}
		
		md.reset();
		md.update(input.getBytes());
		byte[] sign = md.digest();
		long fst = transfer64bitsTolong(sign, 0);
		long second = transfer64bitsTolong(sign, 8);
		
		return Long.valueOf(fst + second);
	}
	
	private long transfer64bitsTolong(byte[] input, int start) {
		long result = 0;

		if (start + 8 <= input.length) {
			int tmp = 0;
			for ( int i = 0; i < 7 ; i++ ) {
				tmp = Byte.valueOf(input[start + i]).intValue();
				if ( tmp < 0) {
					tmp = tmp & 0x7f + 0x80;
				}	
				result = result + tmp*jishu[i];
			}
			int last = Byte.valueOf(input[start + 7]).intValue();
			if ( last < 0 ) {
				last = last & 0x7f;
				result = last * jishu[7] + result;
				result = Long.MIN_VALUE + result;
			} else {
				result = last * jishu[7] + result; 
			}
		}
		
		return result;
	}	
	
	/**
	 * 将字节数组转换成16进制的字符串
	 * @param bts
	 * @return
	 */
	private String bytes2Hex(byte[] bts) {
		String des = "";
		String tmp = null;

		for (int i = 0; i < bts.length; i++) {
			tmp = (Integer.toHexString(bts[i] & 0xFF));
			if (tmp.length() == 1) {
				des += "0";
			}
			des += tmp;
		}
		return des;
	}

	public static void main(String[] args) {
		MD5Object md5 = new MD5Object();
		System.out.println(md5.SHASum(""));
	}
}