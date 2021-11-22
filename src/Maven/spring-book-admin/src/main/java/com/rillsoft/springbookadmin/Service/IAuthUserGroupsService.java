package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.Exception.UnkownIdentifierException;
import com.rillsoft.springbookadmin.model.AuthUserGroups;
import com.rillsoft.springbookadmin.model.AuthUserRoles;
import com.rillsoft.springbookadmin.model.AuthUsers;

import java.util.List;

public interface IAuthUserGroupsService {
    List<AuthUserGroups> selectAuthUserGroupsByUserId(Integer Id) throws UnkownIdentifierException;

    List<AuthUserGroups> selectAuthUserGroupsByGroupId(Integer Id) throws UnkownIdentifierException;

    AuthUsers selectAuthGroupsByUserId(Integer Id) throws UnkownIdentifierException;
}
