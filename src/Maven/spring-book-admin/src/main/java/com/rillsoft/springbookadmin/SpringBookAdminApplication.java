package com.rillsoft.springbookadmin;

import com.rillsoft.springbookadmin.JUnit.JavaProjectWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*
 *  Project was initialed by crane zhou on 2021.07.27
 *
 *  by using:
 *  https://start.spring.io/
 *  Code copied from:
 *  https://spring.io/guides/gs/spring-boot/
 *  https://spring.io/guides/gs/serving-web-content/
 *
 * */

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.rillsoft.springbookadmin.mapper")
public class SpringBookAdminApplication {

	private static final JavaProjectWorker objTheWorker = new JavaProjectWorker();

	public static void main(String[] args) {
		SpringApplication.run(SpringBookAdminApplication.class, args);

		objTheWorker.generateLogs("Spring-Book-Admin:Hello World!");
	}
}
