package com.rillsoft.springbookadmin.Controller;

import com.rillsoft.springbookadmin.Exception.UserAlreadyExistException;
import com.rillsoft.springbookadmin.Service.CustomDetailUserService;
import com.rillsoft.springbookadmin.Service.Impl.AuthUsersServiceImpl;
import com.rillsoft.springbookadmin.Service.RegisterAuthUsersService;
import com.rillsoft.springbookadmin.model.AuthUsers;
import com.rillsoft.springbookadmin.model.AuthUsersForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

@Controller
// @RequestMapping("/register")
// @ControllerAdvice
// @Validated
public class RegisterController {
//    @RequestMapping(value = {"/register", "/registerPage"}, method= RequestMethod.GET)
//    public String register() {
//        return "register";
//    }

    private static final Logger m_objLogger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private MessageSource m_objMessageSource;

    @Autowired
    private RegisterAuthUsersService m_objRegisterAuthUserService;

    @RequestMapping(value = {"/register", "/registerPage"}, method= RequestMethod.GET)
    public ModelAndView showRegisterForm(AuthUsers objAuthUser) {
//        final
        ModelAndView modelAndView = new ModelAndView("/register");

//        AuthUsers objAuthUser = new AuthUsers();
//        m_objLogger.info("objAuthUser.getUsername() = " + objAuthUser.getUsername());

        modelAndView.addObject("objAuthUser", new AuthUsers());

        return modelAndView;
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public ModelAndView registerAuthUsers(final @Valid AuthUsers theAuthUser, final BindingResult bindingResult,
//                                          HttpServletRequest request, HttpServletResponse response) {
    public ModelAndView registerAuthUsers(final @Valid AuthUsers theAuthUser, final BindingResult bindingResult) {
//        final
        ModelAndView modelAndView = new ModelAndView("/register");

        if (bindingResult.hasErrors()) {

            modelAndView.addObject("objAuthUser", theAuthUser);

//            m_objLogger.info("bindingResult.count=" + bindingResult.getFieldErrorCount());
////            m_objLogger.info("bindingResult.fieldError=" + bindingResult.getAllErrors().toString());
//            m_objLogger.info("theAuthUser.getUsername()=" + theAuthUser.getUsername());
//            m_objLogger.info("theAuthUser.getFullname()=" + theAuthUser.getFullname());

            return modelAndView;
        }
//        else
//        {
//            m_objLogger.info("bindingResult.hasErrors is false (no errors)");
//        }

//        m_objLogger.info("theAuthUser.getUsername()=" + theAuthUser.getUsername());
//        m_objLogger.info("theAuthUser.getFullname()=" + theAuthUser.getFullname());
//
//        m_objLogger.info("theAuthUser.getPassword()=" + theAuthUser.getPassword());

//        try {
//
//            m_objRegisterAuthUserService.registerAuthUser(theAuthUser);
//
//        } catch (UserAlreadyExistException e){
//            bindingResult.rejectValue("username", "theAuthUser.username","A user account already exists for this user name.");
//
//            modelAndView.addObject("objAuthUser", theAuthUser);
//            modelAndView.addObject("registrationErrorMessage", "A user account already exists for this user name.");
//
//            return modelAndView;
//        }

        modelAndView.addObject("objAuthUser", theAuthUser);
//        modelAndView.addObject("registrationMessage", m_objMessageSource.getMessage("registration.verification.email.msg", null, LocaleContextHolder.getLocale()));
        modelAndView.addObject("registrationMessage", m_objMessageSource.getMessage("registration.verification.email.msg.notready", null, LocaleContextHolder.getLocale()));
        return modelAndView;
    }
}

// Refer to:
//      https://docs.spring.io/spring-framework/docs/current/reference/html/core.html#validation
//      http://hibernate.org/validator/releases/
//      https://beanvalidation.org/
//      https://jcp.org/en/jsr/all
//      https://www.thymeleaf.org/doc/tutorials/3.0/thymeleafspring.html
//      https://docs.jboss.org/hibernate/beanvalidation/spec/2.0/api/overview-summary.html
//      some sample code for testing : (will debug later if we have more time)
//      https://howtodoinjava.com/spring-rest/request-body-parameter-validation/
//      https://stackoverflow.com/questions/34728144/spring-boot-binding-and-validation-error-handling-in-rest-controller
//
//      <form action="#" th:action="@{/register}" th:object="${theAuthUserData}" method="post">
//          <div class="alert alert-danger" th:if="${#fields.hasErrors('*')}">
//              <p th:each="err : ${#fields.errors('*')}" th:text="${err}"></p>
//          </div>
//          <span th:text="${testRegister}"></span>
//
//      Since we could not get the data from th:if="${#fields.hasErrors('*')}" and ${#fields.errors('*')},
//      currently we are using Bootstrap to validate the user input on the web page:register.html
//      (thymeleaf templates)
//      we will fix this bug later if we have more time and resource.
//      by crane zhou on 2021.11.12
//
//      This bug has been found and fixed.
//      added and commented by crane zhou on 2021.11.19 & 22
//      see more details in /model/AuthUsersForm.java
//
