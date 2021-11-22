package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.Exception.UnkownIdentifierException;
import com.rillsoft.springbookadmin.model.AuthUserRoles;
import com.rillsoft.springbookadmin.model.AuthUsers;

import java.util.List;

public interface IAuthUserRolesService {

    List<AuthUserRoles> selectAuthUserRolesByUserId(Integer Id) throws UnkownIdentifierException;

    List<AuthUserRoles> selectAuthUserRolesByRoleId(Integer Id) throws UnkownIdentifierException;

    AuthUsers selectAuthRolesByUserId(Integer Id) throws UnkownIdentifierException;
}
