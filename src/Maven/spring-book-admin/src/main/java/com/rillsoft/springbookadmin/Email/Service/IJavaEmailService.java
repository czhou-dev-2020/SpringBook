package com.rillsoft.springbookadmin.Email.Service;

import com.rillsoft.springbookadmin.Email.Context.AbstractJavaEmailContext;

import javax.mail.MessagingException;

public interface IJavaEmailService {
    void sendMail(final AbstractJavaEmailContext objEmail) throws MessagingException;
}
