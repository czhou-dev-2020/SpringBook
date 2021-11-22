package com.rillsoft.springbookadmin.Service.Impl;

import com.rillsoft.springbookadmin.Exception.UnkownIdentifierException;
import com.rillsoft.springbookadmin.Service.CustomDetailUserService;
import com.rillsoft.springbookadmin.Service.IAuthUserRolesService;
import com.rillsoft.springbookadmin.Service.IAuthUsersService;
import com.rillsoft.springbookadmin.mapper.AuthUserRolesMapper;
import com.rillsoft.springbookadmin.mapper.AuthUsersMapper;
import com.rillsoft.springbookadmin.model.AuthRoles;
import com.rillsoft.springbookadmin.model.AuthUserRoles;
import com.rillsoft.springbookadmin.model.AuthUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class AuthUserRolesServiceImpl implements IAuthUserRolesService {

//    private static final Logger m_objLogger = LoggerFactory.getLogger(AuthUserRolesServiceImpl.class);

    @Autowired
    private AuthUserRolesMapper m_objAuthUserRolesMapper;

    @Autowired
    private AuthUsersMapper m_objAuthUsersMapper;

    @Override
    public List<AuthUserRoles> selectAuthUserRolesByUserId(Integer Id) throws UnkownIdentifierException {
        List<AuthUserRoles> objTheUserRoles = m_objAuthUserRolesMapper.selectAuthUserRolesByUserId(Id);
        return objTheUserRoles;
    }

    @Override
    public List<AuthUserRoles> selectAuthUserRolesByRoleId(Integer Id) throws UnkownIdentifierException {
        List<AuthUserRoles> objTheUserRoles = m_objAuthUserRolesMapper.selectAuthUserRolesByRoleId(Id);
        return objTheUserRoles;
    }

    @Override
    public AuthUsers selectAuthRolesByUserId(Integer Id) throws UnkownIdentifierException {
        AuthUsers objTheAuthUser = m_objAuthUsersMapper.selectByPrimaryKey(Id);

        List<AuthRoles> objTheRoles = m_objAuthUserRolesMapper.selectAuthRolesByUserId(Id);

        objTheAuthUser.setAuthRoles(objTheRoles);

        return objTheAuthUser;
    }
}
