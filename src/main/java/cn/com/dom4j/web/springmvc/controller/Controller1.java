package cn.com.dom4j.web.springmvc.controller;

import cn.com.dom4j.base.common.util.QiniuUtils;
import cn.com.dom4j.base.model.po.City;
import cn.com.dom4j.base.model.pojo.User;
import cn.com.dom4j.base.service.db.ICityService;
import cn.com.dom4j.base.service.db.IReadTableService;
import cn.com.dom4j.base.service.db.IUserService;
//import cn.com.dom4j.config.QiNiuConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    @Resource
    private ICityService cityService;

    @Resource
    private IReadTableService readTableService;

    @RequestMapping("/upload")
    public ModelAndView upload() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/test/qiniuUpload");
        return mv;
    }

    @RequestMapping("register")
    public ModelAndView register(HttpServletRequest request, ModelMap modelMap) {

        String contextPath = request.getContextPath();
        System.out.println(contextPath);

        City city = cityService.getCityById(20);

        System.out.println(city);

        return new ModelAndView("/web/user/register", modelMap);
    }


    /*@RequestMapping("/upload-x")
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
*/


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

        User user = users.get(2);
        String name = user.getName();
        String password = user.getPassword();

        name = filter(name);


        ModelAndView mv = new ModelAndView();
        mv.addObject("users", users);
        mv.addObject("name", name);

        mv.setViewName("/test/testmsql");

        return mv;

    }

    private String filter(String str) {

        str = StringUtils.replaceChars(str, "\'", "");

        return StringUtils.replaceChars(str, "\"", "");


    }



}
