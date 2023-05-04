package com.bonc.springboot.service.impl;

import com.bonc.springboot.entity.LoginUser;
import com.bonc.springboot.entity.TSysUser;
import com.bonc.springboot.mapper.TSysMenuMapper;
import com.bonc.springboot.mapper.TSysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * 重新实现UserDetailsService接口,springsecurity默认的类是InMemoryUserDetailsManager
 * 是从内存获取用户名密码,所以需要重写从数据库获取
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TSysUserMapper userMapper;

    @Autowired
    private TSysMenuMapper menuMapper;
    //TODO 查询对应权限

    //通过数据库查询用户和权限信息封装到UserDetails里面,
    // UserDetails是接口,创建LoginUser去实现UserDetails
    //这一步只是查询用户信息并没有开始校验
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //查询用户信息
        TSysUser user = userMapper.selectOneByUserName(username);
        //如果没有查询到用户就抛出异常
        if(Objects.isNull(user)){
            throw new RuntimeException("用户名或者密码错误");
        }

        //查询权限信息
        List<String> permissions = menuMapper.selectPermsByUserId(user.getId());
        //把数据封装成UserDetails返回Authention实现的对象中
        return new LoginUser(user,permissions);
    }
}
