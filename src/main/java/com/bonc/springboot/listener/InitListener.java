package com.bonc.springboot.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author qiush
 * @description 系统初始化执行代码块
 * @create 2023-02-08 11:39
 */
@Slf4j
@Component
public class InitListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("-------初始化");
    }
}
