package com.rillsoft.springbookadmin.Controller.Master;

import com.rillsoft.springbookadmin.Controller.RegisterController;
import com.rillsoft.springbookadmin.Service.CustomDetailUserService;
import com.rillsoft.springbookadmin.Service.Impl.AuthUsersServiceImpl;
import com.rillsoft.springbookadmin.Service.RegisterAuthUsersService;
import com.rillsoft.springbookadmin.model.AuthUsers;
import com.rillsoft.springbookadmin.model.ExtendedAuthUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ProfileController {

    private static final Logger m_objLogger = LoggerFactory.getLogger(ProfileController.class);

    @Autowired
//    private RegisterAuthUsersService m_objRegisterAuthUserService;
//    private CustomDetailUserService m_objCustomDetailUserService;
    private AuthUsersServiceImpl m_objAuthUsersServiceImpl;


    @RequestMapping(value = {"/master/profile"}, method= RequestMethod.GET)
    public ModelAndView showProfileForm(AuthUsers objAuthUser) {
        ModelAndView modelAndView = new ModelAndView("/master/profile");
//        modelAndView.addObject("rolesList", m_objAuthRolesService.getAllAuthRolesList());

//        AuthUsers objLoginUser=(AuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());
        ExtendedAuthUsers objExtendedAuthUsers = (ExtendedAuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthUsers objLoginUser = objExtendedAuthUsers.getAuthUsers();
        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());

        AuthUsers objTheAuthUser = m_objAuthUsersServiceImpl.selectUserById(objLoginUser.getId());

        modelAndView.addObject("objAuthUser", objTheAuthUser);

        modelAndView.addObject("id", objLoginUser.getId());
        modelAndView.addObject("username", objLoginUser.getUsername());
        modelAndView.addObject("fullname", objLoginUser.getFullname());
        modelAndView.addObject("userEmail", objLoginUser.getUserEmail());
        modelAndView.addObject("userPhone", objLoginUser.getUserPhone());

        m_objLogger.info("GET:objAuthUser.getFullname():" + objTheAuthUser.getFullname());

        return modelAndView;
    }


    @RequestMapping(value = {"/master/profile"}, method= RequestMethod.POST)
//    public ModelAndView updateAuthUsers(HttpServletRequest request, @Validated(AuthUsers.ValidationUpdate.class) User userView,
//                                        BindingResult bindingResult) throws Exception {
    public ModelAndView updateAuthUsers(@ModelAttribute AuthUsers theAuthUser, Model objModel, BindingResult bindingResult) {

        ModelAndView modelAndView = new ModelAndView("/master/profile");
////        modelAndView.addObject("rolesList", m_objAuthRolesService.getAllAuthRolesList());
//
////        AuthUsers objLoginUser=(AuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
////        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());
        ExtendedAuthUsers objExtendedAuthUsers = (ExtendedAuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthUsers objLoginUser = objExtendedAuthUsers.getAuthUsers();
//        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());

//        modelAndView.addObject("theAuthUser", objLoginUser);

        AuthUsers objTheAuthUser = m_objAuthUsersServiceImpl.selectUserById(objLoginUser.getId());
//
//        if (user == null) {
//            throw new NotFoundException("Not found user with ID " + userId);
//        }
//
//        ModelAndView modelAndView = new ModelAndView();
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("user.edit");
//            modelAndView.addObject("user", userView);
//
//            return modelAndView;
//        }
//
//        Form.bind(request, userView, user);
//
//        this.userService.update(user);
//
//        modelAndView.setViewName("redirect:/admin/user");
//
//        return modelAndView;
//        modelAndView.addObject("objAuthUser", objTheAuthUser);

        objModel.addAttribute("objAuthUser", objTheAuthUser);

        m_objLogger.info("POST:objAuthUser.getFullname():" + objTheAuthUser.getFullname());

        return modelAndView;
    }
}
