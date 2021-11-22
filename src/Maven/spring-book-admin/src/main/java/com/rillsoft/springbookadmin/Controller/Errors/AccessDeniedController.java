package com.rillsoft.springbookadmin.Controller.Errors;

import com.rillsoft.springbookadmin.model.AuthUsers;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccessDeniedController {

////    @GetMapping("/access-denied")
//    @RequestMapping(value = {"/errors/access-denied"}, method= RequestMethod.GET)
//    public String getAccessDenied() {
//        return "/errors/403";
//    }

    @RequestMapping(value = {"/errors/access-denied"}, method= RequestMethod.GET)
    public ModelAndView showAccessDenied() {
        ModelAndView modelAndView = new ModelAndView("errors/403");
//        modelAndView.addObject("categoryList", m_objGoodsCategoryService.getAllGoodsCategoryList());
//
//        AuthUsers objLoginUser=(AuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());

        return modelAndView;
    }
}

