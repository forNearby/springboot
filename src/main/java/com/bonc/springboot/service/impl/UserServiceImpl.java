package com.bonc.springboot.service.impl;

import com.bonc.springboot.entity.ResponseResult;
import com.bonc.springboot.entity.TSysUser;
import com.bonc.springboot.entity.UpdateUserPWDRO;
import com.bonc.springboot.mapper.TSysUserMapper;
import com.bonc.springboot.service.UserService;
import com.bonc.springboot.utils.CommonUtil;
import com.bonc.springboot.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author qiush
 * @create 2023-01-27 23:26
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private TSysUserMapper tSysUserMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RedisCache redisCache;

    @Override
    public ResponseResult updateUserInfo(TSysUser user) {

        user.setId(CommonUtil.getUser().getId());
        int i = tSysUserMapper.updateSelective(user);
        if(i!=0){
            return new ResponseResult(200,"更新用户信息成功");
        }
        return new ResponseResult(500,"更新用户信息失败");
    }

    @Override
    public ResponseResult updateUserPWD(UpdateUserPWDRO updateUserPWDRO) {
        TSysUser user =  CommonUtil.getUser();
        //密码校验
        boolean isPWD = passwordEncoder.matches(updateUserPWDRO.getOldPwd(), user.getPassword());
        if(isPWD){
            String newPWD = passwordEncoder.encode(updateUserPWDRO.getNewPwd());
            user.setPassword(newPWD);
            tSysUserMapper.updateSelective(user);
            redisCache.deleteObject("login:"+user.getId());
            return new ResponseResult(205,"密码更新成功,请重新登录");
        }else {
            return new ResponseResult(500,"密码更新失败");
        }
    }

    @Override
    public TSysUser getUserInfoById() {
        TSysUser user =  CommonUtil.getUser();
        TSysUser tSysUser = tSysUserMapper.selectOneById(user.getId());
        return tSysUser;
    }
}
