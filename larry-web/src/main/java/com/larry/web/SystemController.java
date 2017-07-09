package com.larry.web;

import com.larry.enums.ResultCode;
import com.larry.model.Result;
import com.larry.model.UserInfo;
import com.larry.service.UserInfoService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Larry on 2017/6/6.
 */
@Controller
public class SystemController {

    private final static Logger logger = LogManager.getLogger(SystemController.class);

    @Autowired
    private UserInfoService userService;

    @RequestMapping("/")
    public String index(){
        return "/index/index";
    }

    /**
     * 跳转到登录页面
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/register")
    public String register(){
        return "/mobile/register";
    }

    /**
     * 跳转到注册页面
     * @return
     */
    @RequestMapping("/registeruser")
    public String registerUser(UserInfo user){
        Result rs = userService.save(user);
        if(rs.getCode()== ResultCode.ERROR){
            return "/mobile/register";
        }
        return "/mobile/login";
    }
}
