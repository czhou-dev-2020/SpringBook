package com.rillsoft.springbookadmin.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // defined in WebSecurityConfig.java (line 18)
    // comments added by crane zhou on 2021.10.13
//    @GetMapping("/")
//    public String index() {
//        return "Greetings from Spring Boot!";
//    }
}

/*
 *
 * mvn test -Dtest=HelloControllerTest
 * mvn test -Dtest=HelloControllerIT
 * mvn test
 *
 * */