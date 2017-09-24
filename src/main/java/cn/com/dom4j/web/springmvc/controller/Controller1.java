package cn.com.dom4j.web.springmvc.controller;

import cn.com.dom4j.base.common.util.QiniuUtils;
import cn.com.dom4j.base.model.pojo.User;
import cn.com.dom4j.base.service.IUserService;
import cn.com.dom4j.config.QiNiuConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;


/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年07月16日
 * @desc
 */

@Controller
@RequestMapping("/test")
public class Controller1 {

    @Resource
    private IUserService userService;

    @RequestMapping("/upload")
    public ModelAndView upload() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/test/qiniuUpload");
        return mv;
    }

    @RequestMapping("/upload-x")
    public String uploadX(String name, @RequestParam("file") MultipartFile file) {



        String s = QiniuUtils.uploadFile(file, QiNiuConfig.CHROME_DEFAULT_IMAGE_PATH + file.getOriginalFilename(), QiNiuConfig.BUCKET_QINIU_CHROME);

        System.out.println(s);

        return null;
    }

    @RequestMapping("/upload-y")
    public String uploadY(String name, @RequestParam("file") MultipartFile file) {



        String s = QiniuUtils.uploadFile(file, QiNiuConfig.CHROME_DEFAULT_IMAGE_PATH + file.getOriginalFilename(), QiNiuConfig.BUCKET_QINIU_CHROME);

        System.out.println(s);

        return null;
    }



    @RequestMapping("/test1")
    public ModelAndView test1() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/test/test1");
        return mv;
    }

    @RequestMapping("/vueTest_1")
    public ModelAndView vueTest_1() {

        ModelAndView mv = new ModelAndView();
        mv.setViewName("/test/vueTest_1");
        return mv;
    }


    // @RequestBody: 将 Json对象转成 Java对象
    // @ResponseBody: 表示返回的是 Json对象
    @RequestMapping("/jsonSource")
    public @ResponseBody
    User jsonSource(@RequestBody User user) {
        return user;
    }

    @ResponseBody
    @RequestMapping("/kvSource")
    public User kvSource(User user) {
        return user;
    }

    @ResponseBody
    @RequestMapping("/sendForm")
    public User sendForm(@RequestBody User user) {
        String name = user.getName();
        String password = user.getPassword();
        user.setName(name.toLowerCase());
        user.setPassword(password.toUpperCase());
        return user;
    }

    @ResponseBody
    @RequestMapping("/sendForm_KV")
    public User sendForm_KV(User user) {
        return user;
    }


    @RequestMapping("/jsfunction")
    public ModelAndView jsFunction() {

        ModelAndView mv = new ModelAndView();

        mv.setViewName("/test/jsfunction");

        return mv;
    }

    @RequestMapping("/testmysql")
    public ModelAndView testMysql() {

        List<User> users = userService.listUser();

        ModelAndView mv = new ModelAndView();
        mv.addObject("users", users);

        mv.setViewName("/test/testmsql");

        return mv;

    }



}
