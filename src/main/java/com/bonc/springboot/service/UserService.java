package com.bonc.springboot.service;

import com.bonc.springboot.entity.ResponseResult;
import com.bonc.springboot.entity.TSysUser;
import com.bonc.springboot.entity.UpdateUserPWDRO;

/**
 * @author qiush
 * @create 2023-01-27 23:24
 */
public interface UserService {
    ResponseResult updateUserInfo(TSysUser user);

    ResponseResult updateUserPWD(UpdateUserPWDRO updateUserPWDRO);

    TSysUser getUserInfoById();
}
