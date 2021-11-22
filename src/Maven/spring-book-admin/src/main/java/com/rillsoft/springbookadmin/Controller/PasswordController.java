package com.rillsoft.springbookadmin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("")
public class PasswordController {
    @RequestMapping(value = {"/password", "/passwordPage"}, method= RequestMethod.GET)
    public String password() {
        return "password";
    }
}
