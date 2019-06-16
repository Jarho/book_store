package cn.vaf714.shop.controller;

import cn.vaf714.shop.entity.UserVo;
import cn.vaf714.shop.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    final Logger logger = LoggerFactory.getLogger("myLogger");

    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @RequestMapping("login")
    @ResponseBody
    public Map<String, Object> userLogin(HttpServletResponse response, HttpSession session, UserVo userVo) {

        int status = userService.userLogin(userVo, session, response);

        Map<String, Object> result = new HashMap<>();
        result.put("loginStatus", status);
        return result;
    }

    /**
     * 注册
     */
    @RequestMapping("userRegister")
    @ResponseBody
    public Map<String, Object> userRegister(HttpSession session, HttpServletResponse response, UserVo userVo) {

        int status = userService.userRegister(userVo, session, response);

        Map<String, Object> result = new HashMap<>();
        result.put("registerStatus", status);
        return result;
    }

    /**
     * 普通用户注销
     */
    @RequestMapping("userLogout")
    @ResponseBody
    public Map<String, Object> userLogout(HttpSession session) {

        int status = userService.userLogout(session);

        Map<String, Object> result = new HashMap<>();
        result.put("logoutStatus", status);
        return result;
    }

    /**
     * 管理员注销
     */
    @RequestMapping("adminLogout")
    public void adminLogout() {

    }
}
