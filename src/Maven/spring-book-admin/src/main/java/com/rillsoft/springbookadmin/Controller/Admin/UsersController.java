package com.rillsoft.springbookadmin.Controller.Admin;

import com.rillsoft.springbookadmin.Service.AuthRolesService;
import com.rillsoft.springbookadmin.Service.CustomDetailUserService;
import com.rillsoft.springbookadmin.mapper.AuthRolesMapper;
import com.rillsoft.springbookadmin.model.AuthUsers;
import com.rillsoft.springbookadmin.model.ExtendedAuthUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {

    /**
     *
     */
    public UsersController() {
    }

    /**
     *
     * @param m_objCustomDetailUserService
     */
    public UsersController(CustomDetailUserService m_objCustomDetailUserService) {
        this.m_objCustomDetailUserService = m_objCustomDetailUserService;
    }

//    @RequestMapping(value = {"/admin/users"}, method= RequestMethod.GET)
//    public String users(){
//        return "admin/users";
//    }

//    @RequestMapping(value = {"/admin/roles"}, method= RequestMethod.GET)
//    public String roles(){
//        return "admin/roles";
//    }

//    @RequestMapping(value = {"/admin/groups"}, method= RequestMethod.GET)
//    public String groups(){
//        return "admin/groups";
//    }

    @Autowired
    protected CustomDetailUserService m_objCustomDetailUserService;

    @RequestMapping(value = {"/admin/users"}, method= RequestMethod.GET)
    public ModelAndView showAuthUsers() {
        ModelAndView modelAndView = new ModelAndView("admin/users");
        modelAndView.addObject("usersList", m_objCustomDetailUserService.getAllAuthUsersList());

        ExtendedAuthUsers objExtendedAuthUsers = (ExtendedAuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthUsers objLoginUser = objExtendedAuthUsers.getAuthUsers();
        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());

        return modelAndView;
    }

//    @RequestMapping(value = {"/basic/category"}, method= RequestMethod.GET)
//    public String category(){
//        return "basic/category";
//    }
}
