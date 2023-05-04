package com.bonc.springboot.service;

import com.bonc.springboot.entity.ResponseResult;
import com.bonc.springboot.entity.TSysUser;

/**
 * @author qiush
 * @description
 * @create 2022-12-20 15:18
 */
public interface LoginServcie {
    ResponseResult login(TSysUser user);

    ResponseResult logout();
}
