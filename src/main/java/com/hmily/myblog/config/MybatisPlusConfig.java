package com.hmily.myblog.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by zyzhmily on 2018/8/21.
 * Mybatis配置
 */
//扫描dao或者是Mapper接口
@Configuration
@MapperScan("com.hmily.myblog.service.mapper.mapper*")
public class MybatisPlusConfig {

    /**
     * mybatis-plus 分页插件
     */

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }

}
