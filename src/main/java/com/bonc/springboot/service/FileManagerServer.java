package com.bonc.springboot.service;

import com.bonc.springboot.entity.ResponseResult;

/**
 * @author qiush
 * @description
 * @create 2023-02-13 13:43
 */
public interface FileManagerServer {

    ResponseResult createDir(String path, Long pId);

    ResponseResult deleteDir();

    ResponseResult editDir();
}
