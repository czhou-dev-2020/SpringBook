package com.rillsoft.springbookadmin.Config;

import com.rillsoft.springbookadmin.Handler.CustomAccessDeniedHandler;
import com.rillsoft.springbookadmin.Handler.CustomAuthenticationFailureHandler;
import com.rillsoft.springbookadmin.Handler.CustomAuthenticationSuccessHandler;
import com.rillsoft.springbookadmin.Service.CustomDetailUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
// import org.springframework.security.web.reactive.result.view.CsrfRequestDataValueProcessor;
import org.springframework.security.web.servlet.support.csrf.CsrfRequestDataValueProcessor;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

// Refer to:
// https://github.com/spring-projects/spring-security/blob/main/config/src/main/java/org/springframework/security/
//      config/annotation/web/configuration/WebSecurityConfigurerAdapter.java
// comment added by crane zhou on 2021.10.13
// https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/
//      config/annotation/web/configuration/WebSecurityConfigurerAdapter.html
// comment added by crane zhou on 2021.11.01
// https://github.com/spring-projects/spring-security/blob/main/core/src/main/java/org/springframework/security/
//      access/AccessDecisionManager.java

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger m_objLogger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Autowired
    private CustomDetailUserService m_objCustomUserDetailService;
    @Autowired
    private BCryptPasswordEncoder m_objBCryptPasswordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/hello", "/login", "/register", "/password")
                .permitAll()
                .antMatchers("/admin/**").hasAuthority("ADMIN")
//                .antMatchers("/basic/**").hasAnyAuthority("ADMIN", "NORMAL")
//                .anyRequest().authenticated()
                .antMatchers("/home", "/summary/**").authenticated()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
                // csrf Configurations
                .and()
                .csrf().requireCsrfProtectionMatcher(new RequestMatcher() {
                    // allow these request methods
                    private Pattern allowedMethods = Pattern.compile("^(GET|HEAD|TRACE|OPTIONS)$");
                    // allow rest requests, rest and web will be separated, it could be removed then.
                    // 放行rest请求，当然后面rest与web将会分开，到时这里可以删除
                    private RegexRequestMatcher unprotectedMatcher = new RegexRequestMatcher("^/rest/.*", null);

                    @Override
                    public boolean matches(HttpServletRequest request) {
                        if (allowedMethods.matcher(request.getMethod()).matches()) {
                            return false;
                        }
                        String servletPath = request.getServletPath();
                        if (servletPath.contains("/druid")) {
                            return false;
                        }
                        return !unprotectedMatcher.matches(request);
                    }
                })

                // Login configurations
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home", true)
                .failureHandler(authenticationFailureHandler())
                .successHandler(authenticationSuccessHandler())
//                .permitAll()
//                .failureUrl("/login-error")

                // Logout configurations
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/hello");
//                .permitAll();

                // csrf protection
//                .and()
//                .csrf(csrf -> csrf.disable());
//                .csrf().disable()   // added by crane zhou on 2021.11.12

//        http.authorizeRequests().antMatchers("/admim/**").hasAuthority("ADMIN");
//        http.authorizeRequests().accessDecisionManager(customAccessDecisionManager);

//        http.authenticationProvider(customAuthentication);

        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .sessionFixation().migrateSession();

    }
    // .deleteCookies("JSESSIONID")

    // Refer to:
    // https://www.baeldung.com/spring-security-custom-authentication-failure-handler
    //
    @Bean
    public CustomAuthenticationFailureHandler authenticationFailureHandler() {
        CustomAuthenticationFailureHandler objFailureHandler = new CustomAuthenticationFailureHandler();
        objFailureHandler.setDefaultFailureUrl("/login?error=true");

        return objFailureHandler;
    }

    @Bean
    public CustomAuthenticationSuccessHandler authenticationSuccessHandler() {
        CustomAuthenticationSuccessHandler objSuccessHandler = new CustomAuthenticationSuccessHandler();
        objSuccessHandler.setDefaultTargetUrl("/home");

        return objSuccessHandler;
    }

//    Refer to:
//    https://www.javadevjournal.com/spring-security/spring-security-custom-403-access-denied-page/
//
//    .antMatchers("/account/**").hasAuthority("ADMIN")
//            .and()
//            .exceptionHandling().accessDeniedHandler(accessDeniedHandler())
    @Bean
    public AccessDeniedHandler accessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers("/resources/**", "/static/**");
//                        "/css/**", "/js/**", "/assets/**");     // ??? is it necessary to added this line ?
                                                                // http.authorizeRequests().anyRequest().authenticated()
                                                                // added by crane zhou on 2021.11.03
    }

    //  Refer to:
//  https://github.com/spring-projects/spring-security/blob/main/core/src/main/java/org/springframework/security/
//      authentication/dao/DaoAuthenticationProvider.java
//  https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/
//      config/annotation/authentication/builders/AuthenticationManagerBuilder.html
//  comment added by crane zhou on 2021.10.13
//
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        BCryptPasswordEncoder objPasswordEncoder = new BCryptPasswordEncoder();
//        m_objLogger.info("objPasswordEncoder.encode:" + objPasswordEncoder.encode("password"));
        return objPasswordEncoder;
//        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider DaoAuthProvider() {
        final DaoAuthenticationProvider theAuthProvider = new DaoAuthenticationProvider();
        theAuthProvider.setUserDetailsService(m_objCustomUserDetailService);
        theAuthProvider.setPasswordEncoder(m_objBCryptPasswordEncoder);
        return theAuthProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(DaoAuthProvider());
    }

//    @Bean
//    public RequestDataValueProcessor requestDataValueProcessor() {
//        return new CsrfRequestDataValueProcessor();
//    }

}
