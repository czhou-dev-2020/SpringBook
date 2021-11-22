package com.rillsoft.springbookadmin.Controller.Admin;

import com.rillsoft.springbookadmin.Service.AuthRolesService;
import com.rillsoft.springbookadmin.model.AuthUsers;
import com.rillsoft.springbookadmin.model.ExtendedAuthUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//@RestController
@Controller
public class RolesController {

    private static final Logger m_objLogger = LoggerFactory.getLogger(RolesController.class);

    public RolesController(AuthRolesService m_objAuthRolesService) {
        this.m_objAuthRolesService = m_objAuthRolesService;
    }

    @Autowired
    protected AuthRolesService m_objAuthRolesService;

    @RequestMapping(value = {"/admin/roles"}, method= RequestMethod.GET)
    public ModelAndView showAuthRoles() {
        ModelAndView modelAndView = new ModelAndView("admin/roles");
        modelAndView.addObject("rolesList", m_objAuthRolesService.getAllAuthRolesList());

//        AuthUsers objLoginUser=(AuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());
        ExtendedAuthUsers objExtendedAuthUsers = (ExtendedAuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthUsers objLoginUser = objExtendedAuthUsers.getAuthUsers();
        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());

        return modelAndView;
    }

//    @RequestMapping(value = {"/admin/roles"}, method= RequestMethod.GET)
//    public String showAuthRoles() throws JsonProcessingException {
//
//        ObjectMapper objMapper = new ObjectMapper();
//
////        objMapper.writeValueAsString(m_objAuthRolesService.getAllAuthRolesList());
//
////        m_objLogger.info("==============================");
////        m_objLogger.info("Check Data Here:");
////        m_objLogger.info(objMapper.writeValueAsString(m_objAuthRolesService.getAllAuthRolesList()));
//
//        return objMapper.writeValueAsString(m_objAuthRolesService.getAllAuthRolesList());
//    }
}
