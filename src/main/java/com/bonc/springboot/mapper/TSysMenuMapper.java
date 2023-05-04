package com.bonc.springboot.mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* @author qiushuai
* @description 针对表【T_SYS_MENU(系统菜单表)】的数据库操作Mapper
* @createDate 2022-12-21 15:40:32
* @Entity com.bonc.springboot.entity.TSysMenu
*/
@Repository
public interface TSysMenuMapper {
    List<String> selectPermsByUserId(long userId);
}




