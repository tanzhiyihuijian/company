package cc.laowantong.hawail;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by 王波 on 2017/7/12 0012.
 */
public class MD5Test {

    public static void main(String[] args) {

    }


    public static String getMD5(String str) {

        try {
            // 生成一个 MDS加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");

            // 计算 MD5函数
            md.update(str.getBytes());

            // digest()最后确定 md5 hash值, 返回值为8位字符串,因为 md5 hash值是 16位的 hex值, 实际上就是8位的字符
            // BigInteger函数则将8位的字符串转成16韦德 hex值, 用字符串来表示, 得到字符串形式的hash值
            return new BigInteger(1, md.digest()).toString(16);

        } catch (Exception e) {
            throw new RuntimeException("MD5加密出错");
        }
    }

    /**利用MD5进行加密
     * @param str  待加密的字符串
     * @return  加密后的字符串
     * @throws NoSuchAlgorithmException  没有这种产生消息摘要的算法
     * @throws UnsupportedEncodingException
     */
    public static String encoderByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        //确定计算方法
        MessageDigest md5=MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        return base64en.encode(md5.digest(str.getBytes("utf-8")));
    }



}
