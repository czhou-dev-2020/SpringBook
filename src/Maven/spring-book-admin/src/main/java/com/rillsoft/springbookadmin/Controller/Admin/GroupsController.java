package com.rillsoft.springbookadmin.Controller.Admin;

import com.rillsoft.springbookadmin.Service.AuthGroupsService;
import com.rillsoft.springbookadmin.Service.AuthRolesService;
import com.rillsoft.springbookadmin.model.AuthUsers;
import com.rillsoft.springbookadmin.model.ExtendedAuthUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GroupsController {

    public GroupsController(AuthGroupsService m_objAuthGroupsService) {
        this.m_objAuthGroupsService = m_objAuthGroupsService;
    }

    @Autowired
    protected AuthGroupsService m_objAuthGroupsService;

    @RequestMapping(value = {"/admin/groups"}, method= RequestMethod.GET)
    public ModelAndView showAuthGroups() {
        ModelAndView modelAndView = new ModelAndView("admin/groups");
        modelAndView.addObject("groupsList", m_objAuthGroupsService.getAllAuthGroupsList());

//        AuthUsers objLoginUser=(AuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());
        ExtendedAuthUsers objExtendedAuthUsers = (ExtendedAuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthUsers objLoginUser = objExtendedAuthUsers.getAuthUsers();
        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());

        return modelAndView;
    }
}
