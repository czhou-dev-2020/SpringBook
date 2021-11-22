package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.Exception.UnkownIdentifierException;
import com.rillsoft.springbookadmin.model.AuthUsers;

import java.util.List;

public interface IAuthUsersService {

    AuthUsers selectUserById(Integer Id) throws UnkownIdentifierException;

    AuthUsers selectByUsername(String strUsername);

    List<AuthUsers> selectByFullname(String strFullname);

    int insertAuthUser(AuthUsers objAuthUser);
    int updateAuthUser(AuthUsers objAuthUser);

    int deleteUserById(Integer Id);

//    boolean checkIfUsernameExist(final String strUsername);
//    boolean checkIfUserEmailExist(final String strUserEmail);
//    boolean checkIfUserPhoneExist(final String strUserPhone);
}
