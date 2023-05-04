package com.bonc.springboot.service.impl;

import com.bonc.springboot.entity.ResponseResult;
import com.bonc.springboot.entity.TFmFileManager;
import com.bonc.springboot.mapper.TFmFileManagerMapper;
import com.bonc.springboot.service.FileManagerServer;
import com.bonc.springboot.utils.CommonUtil;
import com.bonc.springboot.utils.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author qiush
 * @description
 * @create 2023-02-13 15:08
 */
@Service
public class FileManagerServiceImpl implements FileManagerServer {

    @Autowired
    TFmFileManagerMapper tFmFileManagerMapper;

    @Override
    public ResponseResult createDir(String path, Long pId) {
        FileUtil.makeDirOrFile(path);
        TFmFileManager tFmFileManager = new TFmFileManager();
        tFmFileManager.setFileName(path);
        tFmFileManager.setFileTypeId(0L);
        tFmFileManager.setFileTypeName("文件夹");
        tFmFileManager.setPId(pId);
        tFmFileManager.setCreateBy(CommonUtil.getUser().getId());
        tFmFileManager.setCreateTime(new Date());
        tFmFileManagerMapper.insertSelective(tFmFileManager);
        return null;
    }

    @Override
    public ResponseResult deleteDir() {
        return null;
    }

    @Override
    public ResponseResult editDir() {
        return null;
    }
}
