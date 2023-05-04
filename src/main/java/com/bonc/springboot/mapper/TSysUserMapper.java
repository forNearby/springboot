package com.bonc.springboot.mapper;
import org.apache.ibatis.annotations.Param;
import com.bonc.springboot.entity.TSysUser;

import org.springframework.stereotype.Repository;

/**
* @author qiushuai
* @description 针对表【T_SYS_USER(系统用户表)】的数据库操作Mapper
* @createDate 2022-12-20 11:01:11
* @Entity com.bonc.springboot.entity.TSysUser
*/
@Repository
public interface TSysUserMapper {

    TSysUser selectOneById(@Param("id") Long id);

    TSysUser selectOneByUserName(@Param("userName") String userName);

    int updateSelective(TSysUser tSysUser);
}




