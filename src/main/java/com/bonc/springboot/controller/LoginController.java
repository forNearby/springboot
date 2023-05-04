package com.bonc.springboot.controller;

import com.bonc.springboot.entity.ResponseResult;
import com.bonc.springboot.entity.TSysUser;
import com.bonc.springboot.service.LoginServcie;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginServcie loginServcie;

    @PostMapping("/login/login")
    public ResponseResult login(@RequestBody TSysUser user){
        //登录
        return loginServcie.login(user);
    }

    @RequestMapping("/login/logout")
    public ResponseResult logout(){
        return loginServcie.logout();
    }
}
