package cc.laowantong.controller;

import cc.laowantong.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * @author bobo (bo.wang@laowantong.cc)
 * @date 2017年07月16日
 * @desc
 */

@Controller
@RequestMapping("/test")
public class Controller1 {

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
    public @ResponseBody User jsonSource(@RequestBody User user) {
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
        String username = user.getUsername();
        String password = user.getPassword();
        user.setUsername(username.toLowerCase());
        user.setPassword(password.toUpperCase());
        return user;
    }

    @ResponseBody
    @RequestMapping("/sendForm_KV")
    public User sendForm_KV(User user) {
        return user;
    }


}
