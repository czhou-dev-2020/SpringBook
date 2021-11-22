package com.rillsoft.springbookadmin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 */
@Controller
public class HomeController {
    /**
     *
     */
    public HomeController() {
    }

    @RequestMapping(value = {"/", "/hello"}, method= RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = {"/home", "/homePage"}, method= RequestMethod.GET)
    public String home() {
        return "home";
    }

    @RequestMapping(value = {"/summary/dashboard"}, method= RequestMethod.GET)
    public String dashboard() {
        return "summary/dashboard";
    }

//    @RequestMapping("/403")
//    public String forbidden(){
//        return "403";
//    }
}
