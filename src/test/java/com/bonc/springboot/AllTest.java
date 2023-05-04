package com.bonc.springboot;

import com.bonc.springboot.entity.TSysUser;
import com.bonc.springboot.mapper.TSysMenuMapper;
import com.bonc.springboot.mapper.TSysUserMapper;
import com.bonc.springboot.service.FileManagerServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
public class AllTest {

    @Autowired
    private TSysUserMapper userMapper;

    @Autowired
    private TSysMenuMapper menuMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private FileManagerServer fileManagerServer;

    @Test
    public void TestBCryptPasswordEncoder(){
        //密码加密,每次加密会随机生成盐与密码进行加密,所以每次加密的密码会不一样,
        // 两个不一样密文与密码进行校验时都会匹配上
        String admin = passwordEncoder.encode("admin");
        System.out.println(admin);
//      $2a$10$0pQ/aammUrZOebmvmcCzeeWglat9MccWHoJ2ZriyUktlfTqepL9XC

        //密文校验
        boolean lisi1 = passwordEncoder.matches("admin", admin);
        System.out.println(lisi1);
    }

    @Test
    public void testUserMapper(){
        //TSysUser users = userMapper.selectOneByUserName("lisi");
        TSysUser tSysUser = new TSysUser();
        tSysUser.setId(2L);
        tSysUser.setNickName("maomao");
        int i = userMapper.updateSelective(tSysUser);
        System.out.println("---------------"+i);
    }

    @Test
    public void testMenuMapper(){
        List<String> strings = menuMapper.selectPermsByUserId(2);
        System.out.println(strings);
    }
    @Test
    public void testcreateDir(){
        fileManagerServer.createDir("aaa",1L);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//        String time = "2020-03-03 15:20:21.111";
//        try {
//            Date date =  format.parse(time);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
