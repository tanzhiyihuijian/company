package cn.com.dom4j.base.common.util;

import cn.com.dom4j.config.QiNiuConfig;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.util.Auth;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年09月09日
 * @desc 七牛工具类
 */
public class QiniuUtils {

    /**
     * 通过文件名来上传文件
     * @param fileName 要上传文件的路径 (绝对路径)
     * @param key 在服务器上的名称 (路径加名称, 相对于空间根路径)
     * @param bucket 七牛空间名称
     * @return 外链地址
     */
    public static String uploadFile(String fileName, String key, String bucket) {
        PutRet ret = IoApi.putFile(getUpToken(bucket), key, fileName, new PutExtra());
        return ret.ok() ? QiNiuConfig.DOMAIN + ret.getKey() : null;
    }

     public static String uploadFile(File file, String key, String bucket) {
        PutRet ret = IoApi.putFile(getUpToken(bucket), key, file, new PutExtra());
        return ret.ok() ? QiNiuConfig.DOMAIN + ret.getKey() : null;
    }

    public static String uploadFile(MultipartFile multipartFile, String key, String bucket) {
        PutRet ret = IoApi.putFile(getUpToken(bucket), key, toFile(multipartFile), new PutExtra());
        return ret.ok() ? QiNiuConfig.DOMAIN + ret.getKey() : null;
    }

    public static File toFile(MultipartFile multipartFile) {
        CommonsMultipartFile cf = (CommonsMultipartFile) multipartFile;
        DiskFileItem fileItem = (DiskFileItem) cf.getFileItem();
        return fileItem.getStoreLocation();
    }

    private static String getUpToken(String bucket) {
        return getAuth().uploadToken(bucket);
    }

    private static Auth getAuth() {
        return Auth.create(QiNiuConfig.ACCESS_KEY, QiNiuConfig.SECRET_KEY);
    }

















    public static void main(String[] args) {


        String s = uploadFile("C:\\software\\data\\image\\283088-106.jpg",
                QiNiuConfig.CHROME_DEFAULT_IMAGE_PATH + "dom4j-4.jpg", QiNiuConfig.BUCKET_QINIU_CHROME);

        System.out.println(s);

    }


}