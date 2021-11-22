package com.rillsoft.springbookadmin.Controller;

import com.rillsoft.springbookadmin.model.AuthUsers;
import com.rillsoft.springbookadmin.model.ExtendedAuthUsers;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("")
public class LoginController {

    /**
     *
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

//    @RequestMapping(value = "/login", method=RequestMethod.GET)
//    public String login(){
//        return "login";
//    }

    @RequestMapping(value = "/login", method= RequestMethod.GET)
    public ModelAndView showAuthUsers() {
        ModelAndView modelAndView = new ModelAndView("/login");
//        modelAndView.addObject("usersList", m_objCustomDetailUserService.getAllAuthUsersList());
//
//        ExtendedAuthUsers objExtendedAuthUsers = (ExtendedAuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        AuthUsers objLoginUser = objExtendedAuthUsers.getAuthUsers();
//        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());

        return modelAndView;
    }

    // Login form with error
    //  @GetMapping("/login-error")		        // entry defined in WebSecurityConfig.java
    //  @GetMapping was supported in Spring 4.3 later version
    //  @GetMapping = @RequestMapping + RequestMethod.GET

//    @RequestMapping(value = "/login-error", method= RequestMethod.GET)
//    public String loginError(Model model) {
//        model.addAttribute("loginError", true);
//        return "login";
//    }
}
