package com.rillsoft.springbookadmin.Config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Locale;

// Refer to:
// https://github.com/spring-projects/spring-framework/blob/main/spring-webmvc/src/main/java/org/springframework/web/
//      servlet/config/annotation/WebMvcConfigurer.java
// comment added by crane zhou on 2021.10.21
// https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/servlet/config/
//      annotation/WebMvcConfigurer.html

@Configuration
// @EnableWebMvc
// @ComponentScan
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("hello");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/home").setViewName("home");

        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/register").setViewName("register");
        // used for WebSecuritySimpleConfig
        registry.addViewController("/results").setViewName("results");

        registry.addViewController("/summary/dashboard").setViewName("summary/dashboard");

        registry.addViewController("/admin/users").setViewName("admin/users");
        registry.addViewController("/admin/roles").setViewName("admin/roles");
        registry.addViewController("/admin/groups").setViewName("admin/groups");

        registry.addViewController("/basic/category").setViewName("basic/category");
    }

//    @Override
//    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//        configurer.enable();
//    }

    @Bean
    public LocaleResolver localeResolver(){
        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
        localeResolver.setDefaultLocale(Locale.ENGLISH);
        return  localeResolver;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang");
        return localeChangeInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public LocalValidatorFactoryBean validator(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

//    @Bean
//    public InternalResourceViewResolver defaultViewResolver() {
//        return new InternalResourceViewResolver();
//    }

//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter(
//                Charset.forName("UTF-8"));
//        return converter;
//    }

//    @Override
//    public void configureMessageConverters(
//            List<HttpMessageConverter<?>> converters) {
//        super.configureMessageConverters(converters);
//        converters.add(responseBodyConverter());
//    }
//
//    @Override
//    public void configureContentNegotiation(
//            ContentNegotiationConfigurer configurer) {
//        configurer.favorPathExtension(false);
//    }

//    @Bean
//    public ITemplateResolver templateResolver() {
//    ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//        templateResolver.setPrefix("/WEB-INF/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        templateResolver.setCharacterEncoding("utf-8");
//        templateResolver.setCacheable(false);
//        return templateResolver;
//    }

//    /**
//     * STEP 1 - 创建模版解析器
//     */
//    @Bean
//    public ITemplateResolver templateResolver() {
//        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
////        templateResolver.setApplicationContext(applicationContext);
////        templateResolver.setPrefix("/WEB-INF/templates/");
////        templateResolver.setSuffix(".html");
//        templateResolver.setCharacterEncoding("UTF-8");
////        templateResolver.setTemplateMode(TemplateMode.HTML);
//        templateResolver.setCacheable(false);
//        return templateResolver;
//    }
//
//
//    /**
//     * STEP 2 - 创建模版引擎
//     * 并为模板引擎注入模板解析器
//     */
//    @Bean
//    public SpringTemplateEngine templateEngine() {
//        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//        templateEngine.setTemplateResolver(templateResolver());
//        templateEngine.setEnableSpringELCompiler(true);
//
//        return templateEngine;
//    }
//
//    /**
//     * STEP 3 - 注册 Thymeleaf 视图解析器
//     * 并为解析器注入模板引擎
//     */
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//        viewResolver.setTemplateEngine(templateEngine());
//        viewResolver.setCharacterEncoding("UTF-8");
//        registry.viewResolver(viewResolver);
//    }

}