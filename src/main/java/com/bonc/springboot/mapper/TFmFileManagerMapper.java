package com.bonc.springboot.mapper;
import com.bonc.springboot.entity.TFmFileManager;
import org.springframework.stereotype.Repository;

/**
* @author qiushuai
* @description 针对表【t_fm_file_manager(文件管理表)】的数据库操作Mapper
* @createDate 2023-02-13 13:33:54
* @Entity com.bonc.springboot.entity.TFmFileManager
*/
@Repository
public interface TFmFileManagerMapper {

    int insertSelective(TFmFileManager tFmFileManager);
}




