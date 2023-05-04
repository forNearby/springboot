package com.bonc.springboot.controller;

import com.bonc.springboot.entity.ResponseResult;
import com.bonc.springboot.entity.TSysUser;
import com.bonc.springboot.entity.UpdateUserPWDRO;
import com.bonc.springboot.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiush
 * @description
 * @create 2023-01-13 16:34
 */
@Slf4j
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/getUserInfo")
    public ResponseResult getUserInfo(){
        TSysUser user = userService.getUserInfoById();
        return new ResponseResult(200,"获取用户基本信息成功！",user);
    }

    @PostMapping("/user/updateUserInfo")
    public ResponseResult updateUserInfo(@RequestBody TSysUser user){
        return userService.updateUserInfo(user);
    }

    @PostMapping("/user/updateUserPWD")
    public ResponseResult updateUserPWD(@RequestBody UpdateUserPWDRO updateUserPWDRO){
        return userService.updateUserPWD(updateUserPWDRO);
    }

}
