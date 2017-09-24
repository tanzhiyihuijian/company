package cn.com.dom4j.base.common.util;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;

/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年09月09日
 * @desc
 */
public class CommonUtils {

    /**
     * MultipartFile 转换成File
     * @param multfile 原文件类型
     * @return File
     */
    public File multipartToFile(MultipartFile multfile) {

        CommonsMultipartFile cf = (CommonsMultipartFile)multfile;
        //这个myfile是MultipartFile的
        DiskFileItem fi = (DiskFileItem) cf.getFileItem();
        return fi.getStoreLocation();
    }

}
