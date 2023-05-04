package com.bonc.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiush
 * @description
 * @create 2022-12-20 9:14
 */
@Slf4j
@RestController
public class HelloController {



    //方法权限认证,hasAnyAuthority权限数组,数据库用户信息只有有其中一个权限就能访问
    //@PreAuthorize("hasAnyAuthority('admin','test','sys:dept:list')")

    //方法权限认证,hasAnyRole权限数组,数据库用户信息只有有其中一个角色就能访问
    //@PreAuthorize("hasAnyRole('admin','system:dept:list')")

    //自定义注解
    //@PreAuthorize("@ex.hasAuthority('system:dept:list')")
    @RequestMapping("/hello")
    @PreAuthorize("hasAnyAuthority('sys:dept:list')")
    public String hello(){
        return "hello";
    }

    @RequestMapping("/word")
    @PreAuthorize("hasAnyAuthority('sys:test:list')")
    public String word(){
        return "word";
    }

    //不写@PreAuthorize就所有用户都能访问
    @RequestMapping("/java")
    public String java(){
        return "java";
    }

    //127.0.0.1:8080/getPerson?id=1 以前的写法 get请求
//    @RequestMapping(value = { "/getPerson" }, method = { RequestMethod.GET, RequestMethod.POST })
//    public String getPerson(HttpServletRequest request){
//        String id = request.getParameter("id");
//        return person.getBirth()+id;
//    }

    //127.0.0.1:8080/getUserInfo/1
//    @GetMapping("/getUserInfo/{id}")
//    public UserDetail getUserInfo(@PathVariable("id") long id){
//        UserDetail userDetail = dataCRUDService.getUserById(id);
//        return userDetail;
//    }

    //post请求,用对象来接页面数据
//    @PostMapping("/insertUser")
//    public int insertUser(@RequestBody UserDetail userDetail){
//        int i = dataCRUDService.insertUserInfo(userDetail);
//        return i;
//    }
}
