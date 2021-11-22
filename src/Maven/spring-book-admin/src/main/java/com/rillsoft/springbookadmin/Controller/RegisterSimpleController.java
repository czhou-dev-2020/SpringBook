package com.rillsoft.springbookadmin.Controller;

//import com.rillsoft.springbookadmin.model.AuthUsersForm;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//
//@Controller
//public class RegisterSimpleController {
//
//    private static final Logger m_objLogger = LoggerFactory.getLogger(RegisterController.class);
//
//    @GetMapping("/register")
//    public String showForm(AuthUsersForm theAuthUser) {
//        return "form";
//    }
//
//    @PostMapping("/register")
//    public String checkPersonInfo(@Valid AuthUsersForm theAuthUser, BindingResult bindingResult) {
//
//        if (bindingResult.hasErrors()) {
//
//            m_objLogger.info("bindingResult.count=" + bindingResult.getFieldErrorCount());
//            m_objLogger.info("theAuthUser.getName()=" + theAuthUser.getName());
//            m_objLogger.info("theAuthUser.getAge()=" + theAuthUser.getAge());
////            System.out.println("theAuthUser.getName()=" + theAuthUser.getName());
////            System.out.println("theAuthUser.getAge()=" + theAuthUser.getAge());
//
//            return "form";
//        }
//
//        m_objLogger.info("theAuthUser.getName()=" + theAuthUser.getName());
//        m_objLogger.info("theAuthUser.getAge()=" + theAuthUser.getAge());
////        System.out.println("theAuthUser.getName()=" + theAuthUser.getName());
////        System.out.println("theAuthUser.getAge()=" + theAuthUser.getAge());
//
//        return "redirect:/results";
//    }
//}
