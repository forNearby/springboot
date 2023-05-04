package com.bonc.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author qiush
 * @description 更新用户密码接口的请求参数对象
 * @create 2023-01-31 11:54
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserPWDRO {
    /**
     * 老密码
     */
    private String oldPwd;

    /**
     * 新密码
     */
    private String newPwd;

}
