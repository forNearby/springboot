package com.bonc.springboot.utils;

import com.bonc.springboot.entity.LoginUser;
import com.bonc.springboot.entity.TSysUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author qiush
 * @description
 * @create 2023-02-08 16:01
 */
public class CommonUtil {
    public static TSysUser getUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        TSysUser user = loginUser.getUser();
        return user;
    }
}
