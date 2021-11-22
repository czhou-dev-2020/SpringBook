package com.rillsoft.springbookadmin.Handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

//public class CustomAuthenticationFailureHandler
//        implements AuthenticationFailureHandler {
//
//    private ObjectMapper m_objectMapper = new ObjectMapper();
//
//    @Override
//    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
//                                        HttpServletResponse httpServletResponse,
//                                        AuthenticationException e) throws IOException, ServletException {
//
//            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
//            Map<String, Object> data = new HashMap<>();
//            data.put(
//                    "timestamp",
//                    Calendar.getInstance().getTime());
//            data.put(
//                    "exception",
//                    e.getMessage());
//
//            httpServletResponse.getOutputStream()
//                    .println(m_objectMapper.writeValueAsString(data));
//    }
//}

// Refer to:
// https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/
//      web/authentication/SimpleUrlAuthenticationFailureHandler.html
//

/**
 *
 */

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private ObjectMapper m_objectMapper = new ObjectMapper();

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        AuthenticationException e) throws IOException, ServletException {

            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            Map<String, Object> data = new HashMap<>();
            data.put(
                    "timestamp",
                    Calendar.getInstance().getTime());
            data.put(
                    "exception",
                    e.getMessage());

            httpServletResponse.getOutputStream()
                    .println(m_objectMapper.writeValueAsString(data));
    }
}