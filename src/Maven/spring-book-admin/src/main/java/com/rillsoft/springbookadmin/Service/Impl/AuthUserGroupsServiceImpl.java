package com.rillsoft.springbookadmin.Service.Impl;

import com.rillsoft.springbookadmin.Exception.UnkownIdentifierException;
import com.rillsoft.springbookadmin.Service.IAuthUserGroupsService;
import com.rillsoft.springbookadmin.Service.IAuthUserRolesService;
import com.rillsoft.springbookadmin.mapper.AuthUserGroupsMapper;
import com.rillsoft.springbookadmin.mapper.AuthUserRolesMapper;
import com.rillsoft.springbookadmin.mapper.AuthUsersMapper;
import com.rillsoft.springbookadmin.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class AuthUserGroupsServiceImpl implements IAuthUserGroupsService {

//    private static final Logger m_objLogger = LoggerFactory.getLogger(AuthUserRolesServiceImpl.class);

    @Autowired
    private AuthUserGroupsMapper m_objAuthUserGroupsMapper;

    @Autowired
    private AuthUsersMapper m_objAuthUsersMapper;

    @Override
    public List<AuthUserGroups> selectAuthUserGroupsByUserId(Integer Id) throws UnkownIdentifierException {
        List<AuthUserGroups> objTheUserGroups = m_objAuthUserGroupsMapper.selectAuthUserGroupsByUserId(Id);
        return objTheUserGroups;
    }

    @Override
    public List<AuthUserGroups> selectAuthUserGroupsByGroupId(Integer Id) throws UnkownIdentifierException {
        List<AuthUserGroups> objTheUserGroups = m_objAuthUserGroupsMapper.selectAuthUserGroupsByGroupId(Id);
        return objTheUserGroups;
    }

    @Override
    public AuthUsers selectAuthGroupsByUserId(Integer Id) throws UnkownIdentifierException {
        AuthUsers objTheAuthUser = m_objAuthUsersMapper.selectByPrimaryKey(Id);

        List<AuthGroups> objTheGroups = m_objAuthUserGroupsMapper.selectAuthGroupsByUserId(Id);

        objTheAuthUser.setAuthGroups(objTheGroups);

        return objTheAuthUser;
    }
}
