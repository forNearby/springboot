package com.bonc.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author qiush
 * @description 常见配置类
 * @create 2023-01-18 11:25
 */
@Component
@ConfigurationProperties(prefix = "common-config")
@Data //get set
@ToString  //toString
@NoArgsConstructor //无参构造
@AllArgsConstructor //有参构造
public class CommonConfig {
    private String fileUploadPath;  //文件上传路径
    private String loginExpire;       //登陆超时,单位分钟
}
