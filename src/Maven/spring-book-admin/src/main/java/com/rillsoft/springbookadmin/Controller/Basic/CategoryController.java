package com.rillsoft.springbookadmin.Controller.Basic;

import com.rillsoft.springbookadmin.Service.AuthGroupsService;
import com.rillsoft.springbookadmin.Service.GoodsCategoryService;
import com.rillsoft.springbookadmin.model.AuthUsers;
import com.rillsoft.springbookadmin.model.ExtendedAuthUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
//    public CategoryController() {
//    }

    @Autowired
    protected GoodsCategoryService m_objGoodsCategoryService;

    @RequestMapping(value = {"/basic/category"}, method= RequestMethod.GET)
    public ModelAndView showGoodsCategory() {
        ModelAndView modelAndView = new ModelAndView("basic/category");
        modelAndView.addObject("categoryList", m_objGoodsCategoryService.getAllGoodsCategoryList());

//        AuthUsers objLoginUser=(AuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());
        ExtendedAuthUsers objExtendedAuthUsers = (ExtendedAuthUsers) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        AuthUsers objLoginUser = objExtendedAuthUsers.getAuthUsers();
        modelAndView.addObject("loginUserFullname", objLoginUser.getFullname());

        return modelAndView;
    }
}
