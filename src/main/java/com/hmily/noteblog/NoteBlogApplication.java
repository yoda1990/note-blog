package com.hmily.noteblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.hmily.noteblog.service.mapper")  //配置mapper扫描
@SpringBootApplication
public class NoteBlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteBlogApplication.class, args);
	}
}
