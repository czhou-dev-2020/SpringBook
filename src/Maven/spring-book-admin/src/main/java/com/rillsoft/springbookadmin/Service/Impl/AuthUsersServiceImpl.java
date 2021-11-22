package com.rillsoft.springbookadmin.Service.Impl;

import com.rillsoft.springbookadmin.Service.IAuthUsersService;

import com.rillsoft.springbookadmin.mapper.AuthUsersMapper;
import com.rillsoft.springbookadmin.model.AuthUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Component
@Service
public class AuthUsersServiceImpl implements IAuthUsersService {


    @Autowired
    private AuthUsersMapper m_objAuthUsersMapper;

    /**
     *
     */
    public AuthUsersServiceImpl() {
    }

    /**
     * @param Id
     * @return
     */
    @Override
    public AuthUsers selectUserById(Integer Id) {
        // TODO Auto-generated method stub

        AuthUsers objTheUser = m_objAuthUsersMapper.selectByPrimaryKey(Id);
        return objTheUser;
    }

    /**
     * @param strUsername
     * @return
     */
    @Override
    public AuthUsers selectByUsername(String strUsername) {
        // TODO Auto-generated method stub

        AuthUsers objTheUser = m_objAuthUsersMapper.selectByUsername(strUsername);

        return objTheUser;
    }

    /**
     * @param strFullname
     * @return
     */
    @Override
    public List<AuthUsers> selectByFullname(String strFullname) {
        // TODO Auto-generated method stub

        List<AuthUsers> objTheUserList = m_objAuthUsersMapper.selectByFullname(strFullname);
        if(objTheUserList.size() > 0) {
            return objTheUserList;
        }
        else {
            return null;
        }
    }

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

//    @Override
//    public boolean checkIfUsernameExist(final String strUsername) {
//        return selectByUsername(strUsername) != null ? true : false;
//    }
}
