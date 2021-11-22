package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.Exception.InvalidTokenException;
import com.rillsoft.springbookadmin.Exception.UnkownIdentifierException;
import com.rillsoft.springbookadmin.Exception.UserAlreadyExistException;
import com.rillsoft.springbookadmin.model.*;

import javax.persistence.criteria.CriteriaBuilder;

public interface IRegisterAuthUsersService {
    int registerAuthUser(AuthUsers objAuthUser) throws UserAlreadyExistException;
    // by crane zhou on 2021.11.20
    int deleteAuthUser(AuthUsers objAuthUser) throws UnkownIdentifierException;

    boolean checkIfUsernameExist(final String strUsername);
//    boolean checkIfUserEmailExist(final String strUserEmail);
//    boolean checkIfUserPhoneExist(final String strUserPhone);

    boolean checkIfUserIdExist(final Integer nUserId);

    void sendRegistrationConfirmationEmail(final AuthUsers objAuthUser);
    void sendRegistrationConfirmationPhone(final AuthUsers objAuthUser);

    boolean verifyAuthUser(final String strToken) throws InvalidTokenException;
    AuthUsers selectAuthUserById(Integer Id) throws UnkownIdentifierException;

    // copied from IAuthUsersService.java temporarily
    // by crane zhou on 2021.11.15
    int insertAuthUser(AuthUsers objAuthUser);
    int updateAuthUser(AuthUsers objAuthUser);

    int deleteUserById(Integer Id);

    // by crane zhou on 2021.11.17
    int insertAuthUserRoles(AuthUsers objAuthUser);
    int insertAuthUserGroups(AuthUsers objAuthUser);

    // by crane zhou on 2021.11.20
    int deleteAuthUserRoles(AuthUsers objAuthUser);
    int deleteAuthUserGroups(AuthUsers objAuthUser);

//    int addAuthUserRoles();
//    int addAuthUserGroups();

//    int updateAuthUserRoles(AuthUserRoles objAuthUserRoles);
//    int updateAuthUserGroups(AuthUserGroups objAuthUserGroups);

}
