package com.rillsoft.springbookadmin.Service.Impl;

import com.rillsoft.springbookadmin.Exception.InvalidTokenException;
import com.rillsoft.springbookadmin.Exception.UnkownIdentifierException;
import com.rillsoft.springbookadmin.Exception.UserAlreadyExistException;
import com.rillsoft.springbookadmin.Service.IAuthUsersService;
import com.rillsoft.springbookadmin.Service.IRegisterAuthUsersService;
import com.rillsoft.springbookadmin.mapper.*;
import com.rillsoft.springbookadmin.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

// import org.apache.commons.lang3.BooleanUtils;

@Component
@Service
public class RegisterAuthUsersServiceImpl implements IRegisterAuthUsersService {

    @Autowired
    private AuthUsersMapper m_objAuthUsersMapper;

    @Autowired
    private AuthUserRolesMapper m_objAuthUserRolesMapper;

    @Autowired
    private AuthUserGroupsMapper m_objAuthUserGroupsMapper;

    // added by crane zhou on 2021.11.17
    @Autowired
    protected AuthRolesMapper m_objAuthRolesMapper;
    @Autowired
    protected AuthGroupsMapper m_objAuthGroupsMapper;

    @Override
    public int registerAuthUser(AuthUsers objAuthUser) throws UserAlreadyExistException {
        return 0;
    }

    // added by crane zhou on 2021.11.20
    @Override
    public int deleteAuthUser(AuthUsers objAuthUser) throws UnkownIdentifierException {
        return 0;
    }

    @Override
    public boolean checkIfUsernameExist(String strUsername) {
        return m_objAuthUsersMapper.selectByUsername(strUsername) != null ? true : false;
    }

    // added by crane zhou on 2021.11.20
    @Override
    public boolean checkIfUserIdExist(Integer nUserId) {
        return m_objAuthUsersMapper.selectByPrimaryKey(nUserId) != null ? true : false;
    }

    @Override
    public void sendRegistrationConfirmationEmail(AuthUsers objAuthUser) {

    }

    @Override
    public void sendRegistrationConfirmationPhone(AuthUsers objAuthUser) {

    }

    @Override
    public boolean verifyAuthUser(String strToken) throws InvalidTokenException {
        return false;
    }

    @Override
    public AuthUsers selectAuthUserById(Integer Id) throws UnkownIdentifierException {
        AuthUsers objAuthUser = m_objAuthUsersMapper.selectByPrimaryKey(Id);

//        if (objAuthUser == null || BooleanUtils.isFalse(objAuthUser.isAccountVerified())){
        if (objAuthUser == null || !objAuthUser.isAccountVerified()) {
            // we will ignore in case account is not verified or account does not exists
            throw new UnkownIdentifierException("Unable to find account or user account is not Active.");
        }

        return objAuthUser;
    }

    // copied from IAuthUsersService.java temporarily
    // by crane zhou on 2021.11.15

    /**
     *
     * @param objAuthUser
     * @return
     */
    @Override
    public int insertAuthUser(AuthUsers objAuthUser) {

        AuthUsers objTheUser = objAuthUser;

        int nResult = 0;

        nResult = m_objAuthUsersMapper.insert(objTheUser);

        return nResult;
    }

    /**
     *
     * @param objAuthUser
     * @return
     */
    @Override
    public int updateAuthUser(AuthUsers objAuthUser) {

        AuthUsers objTheUser = objAuthUser;

        int nResult = 0;

        nResult = m_objAuthUsersMapper.updateByPrimaryKey(objTheUser);

        return nResult;
    }

    /**
     *
     * @param Id
     * @return
     */
    @Override
    public int deleteUserById(Integer Id) {

        int nResult = 0;

        nResult = m_objAuthUsersMapper.deleteByPrimaryKey(Id);

        return nResult;
    }

    // added by crane zhou on 2021.11.17
    @Override
    public int insertAuthUserRoles(AuthUsers objAuthUser) {

        List<AuthRoles> objTheAuthRoles = objAuthUser.getAuthRoles();

        int nResult = 0;
        AuthUserRoles objAuthUserRoles = new AuthUserRoles();
        objAuthUserRoles.setUserId(objAuthUser.getId());

        for (AuthRoles objTheRole : objTheAuthRoles) {
            objAuthUserRoles.setRoleId(objTheRole.getId());
            nResult = m_objAuthUserRolesMapper.insert(objAuthUserRoles);
        }

        return nResult;
    }

    @Override
    public int insertAuthUserGroups(AuthUsers objAuthUser) {
        List<AuthGroups> objTheAuthGroups = objAuthUser.getAuthGroups();

        int nResult = 0;
        AuthUserGroups objAuthUserGroups = new AuthUserGroups();
        objAuthUserGroups.setUserId(objAuthUser.getId());

        for (AuthGroups objTheGroup : objTheAuthGroups) {
            objAuthUserGroups.setGroupId(objTheGroup.getId());
            nResult = m_objAuthUserGroupsMapper.insert(objAuthUserGroups);
        }

        return nResult;
    }

    // added by crane zhou on 2021.11.20
    @Override
    public int deleteAuthUserRoles(AuthUsers objAuthUser) {

//        List<AuthRoles> objTheAuthRoles = objAuthUser.getAuthRoles();

        int nResult = 0;

        List<AuthRoles> objTheAuthRoles = m_objAuthUserRolesMapper.selectAuthRolesByUserId(objAuthUser.getId());

        nResult = objTheAuthRoles.size();

        if (nResult > 0)
        {
            m_objAuthUserRolesMapper.deleteAuthUserRolesByUserId(objAuthUser.getId());
        }

        return nResult;
    }

    @Override
    public int deleteAuthUserGroups(AuthUsers objAuthUser) {
//        List<AuthGroups> objTheAuthGroups = objAuthUser.getAuthGroups();

        int nResult = 0;

        List<AuthGroups> objTheAuthGroups = m_objAuthUserGroupsMapper.selectAuthGroupsByUserId(objAuthUser.getId());

        nResult = objTheAuthGroups.size();

        if (nResult > 0) {
            nResult = m_objAuthUserGroupsMapper.deleteAuthUserGroupsByUserId(objAuthUser.getId());
        }

        return nResult;
    }
}
