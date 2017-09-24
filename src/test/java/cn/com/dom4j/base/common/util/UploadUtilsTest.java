package cn.com.dom4j.base.common.util;

import cn.com.dom4j.config.QiNiuConfig;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年09月09日
 * @desc
 */
public class UploadUtilsTest {

    @Test
    public void uploadQiNiu() throws Exception {

        // 准备本地文件
        String filePath = "C:\\software\\data\\image\\116765-106.jpg";

        File file = new File(filePath);





        // 上传到服务器后的文件名
        String key = "aaa.jpg";

        // 秘钥配置
        Auth auth = Auth.create(QiNiuConfig.ACCESS_KEY, QiNiuConfig.SECRET_KEY);

        // 创建上传对象
        UploadManager uploadManager = new UploadManager(new Configuration());

        // 简单上传, 使用默认策略, 只需要设置上传的空间名就可以了
        String upToken = auth.uploadToken(QiNiuConfig.BUCKET_DOM4J);

        try {
            Response response = uploadManager.put(filePath, key, upToken);
            System.out.println(response.isOK() + " ... " + response.bodyString());
        } catch (QiniuException e) {
            e.printStackTrace();
        }


    }

}