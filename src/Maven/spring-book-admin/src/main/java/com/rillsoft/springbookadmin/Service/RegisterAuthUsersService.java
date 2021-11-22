package com.rillsoft.springbookadmin.Service;

import com.fasterxml.jackson.databind.util.BeanUtil;
// import com.rillsoft.springbookadmin.Config.WebSecurityConfig;
import com.rillsoft.springbookadmin.Exception.UnkownIdentifierException;
import com.rillsoft.springbookadmin.Exception.UserAlreadyExistException;
import com.rillsoft.springbookadmin.Service.Impl.AuthUsersServiceImpl;
import com.rillsoft.springbookadmin.Service.Impl.RegisterAuthUsersServiceImpl;
import com.rillsoft.springbookadmin.model.AuthGroups;
import com.rillsoft.springbookadmin.model.AuthRoles;
import com.rillsoft.springbookadmin.model.AuthUserRoles;
import com.rillsoft.springbookadmin.model.AuthUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.beans.BeanUtils;

import java.util.List;

// @Service("AuthUsersServiceImpl")
@Service
public class RegisterAuthUsersService extends RegisterAuthUsersServiceImpl {

    private static final Logger m_objLogger = LoggerFactory.getLogger(RegisterAuthUsersService.class);

    private static final int AUTH_USER_ROLES_NORMAL_ROLE_ID = 102;
    private static final int AUTH_USER_GROUPS_NORMAL_GROUP_ID = 102;

    private static final String AUTH_USER_ROLES_NORMAL_ROLE_CODE = "NORMAL";
    private static final String AUTH_USER_GROUPS_NORMAL_GROUP_CODE = "NORMAL";

    // commented by crane zhou on 2021.11.18
    @Autowired
    private PasswordEncoder m_objSpringSecurity_PasswordEncoder;

    @Override
    public int registerAuthUser(AuthUsers objAuthUser) throws UserAlreadyExistException {

        int nResult = 0;

//        if(checkIfUserExist(user.getEmail())){
//            throw new UserAlreadyExistException("User already exists for this email");
//        }
//        UserEntity userEntity = new UserEntity();
//        BeanUtils.copyProperties(user, userEntity);
//        encodePassword(user, userEntity);
//        updateCustomerGroup(userEntity);
//        userRepository.save(userEntity);
//        sendRegistrationConfirmationEmail(userEntity);

        // User Registration Step 1: check username duplicated
        if (checkIfUsernameExist(objAuthUser.getUsername())) {
            throw new UserAlreadyExistException("User already exists for this username");
        }

        // User Registration Step 2: Get Properties from Web Page input ??
//        AuthUsers objTheNewAuthUser = new AuthUsers();
//        BeanUtils.copyProperties(objAuthUser, objTheNewAuthUser);

        // User Registration Step 3: Setup Password for New User (AuthUsers object)
//        SpringSecurity_EncodePassword(objAuthUser, objTheNewAuthUser);
        String strPassword = objAuthUser.getPassword();
        // commented by crane zhou on 2021.11.18
        objAuthUser.setPassword(m_objSpringSecurity_PasswordEncoder.encode(strPassword));

        // User Registration Step 4: Save the New User in Database (AuthUsers object)
        // m_objAuthUsersMapper.insert(objTheNewAuthUser);
        nResult = insertAuthUser(objAuthUser);
//        objAuthUser.setId(objTheNewAuthUser.getId());

        // User Registration Step 5: Update (Add) Roles for New User (AuthUsers object)
//        updateAuthUserRoles(objTheNewAuthUser);
        updateAuthUserRoles(objAuthUser);

        // User Registration Step 6: Update (Add) Groups for New User (AuthUsers object)
//        updateAuthUserGroups(objTheNewAuthUser);
        updateAuthUserGroups(objAuthUser);

        // User Registration Step 7: Save the New User's Roles in Database
//        insertAuthUserRoles(objTheNewAuthUser);
        insertAuthUserRoles(objAuthUser);

        // User Registration Step 8: Save the New User's Groups in Database
//        insertAuthUserGroups(objTheNewAuthUser);
        insertAuthUserGroups(objAuthUser);

        // User Registration Step 9: Send the Email for user confirmation  (AuthUsers object)
//        sendRegistrationConfirmationEmail(objTheNewAuthUser);

        // User Registration Step 10: Send the Phone (Short Message) for user confirmation  (AuthUsers object)
        // This is Optional.
//        sendRegistrationConfirmationPhone(objTheNewAuthUser);

        return nResult;
    }

    private void updateAuthUserRoles(AuthUsers objAuthUser){
//        AuthRoles objRoles = m_objAuthRolesMapper.selectByPrimaryKey(AUTH_USER_ROLES_NORMAL_ROLE_ID);
        AuthRoles objRoles = m_objAuthRolesMapper.selectByRoleCode(AUTH_USER_ROLES_NORMAL_ROLE_CODE);

        objAuthUser.addAuthRoles(objRoles);
    }

    private void updateAuthUserGroups(AuthUsers objAuthUser){
//        AuthGroups objGroups = m_objAuthGroupsMapper.selectByPrimaryKey(AUTH_USER_GROUPS_NORMAL_GROUP_ID);
        AuthGroups objGroups = m_objAuthGroupsMapper.selectByGroupCode(AUTH_USER_GROUPS_NORMAL_GROUP_CODE);

        objAuthUser.addAuthGroups(objGroups);
    }

    // added by crane zhou on 2021.11.20
    @Override
    public int deleteAuthUser(AuthUsers objAuthUser) throws UnkownIdentifierException {

        int nResult = 0;

        // User Delete Step 1: check user id exist (valid user id)
        if (!checkIfUserIdExist(objAuthUser.getId())) {
            throw new UnkownIdentifierException("User Id not exist for this user id");
        }
        else {
            nResult = 1;
        }

        // User Delete Step 2: Get Properties from Web Page input ??
        // User Delete Step 3: validate password for deleting Auth User

        // User Delete Step 4: delete Auth User Groups
        deleteAuthUserRoles(objAuthUser);

        // User Delete Step 5: delete Auth User Roles
        deleteAuthUserGroups(objAuthUser);

        // User Delete Step 6: delete Auth User
        nResult = deleteUserById(objAuthUser.getId());

        // User Delete Step 7: send out the mail after the deleting operations.

        // sendDeletingInformationEmail(objGuestAuthUser);
        // or leave a message ...

        return nResult;
    }

    // added by crane zhou on 2021.11.15
    // Refer to:
    // https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/crypto/bcrypt/BCryptPasswordEncoder.html
    //
//    private void SpringSecurity_EncodePassword(AuthUsers objSourceUserData, AuthUsers objTargetUserDataEntity){
//
//        objTargetUserDataEntity.setPassword(m_objSpringSecurity_PasswordEncoder.encode(objSourceUserData.getPassword()));
//
////        m_objLogger.info("m_objSpringSecurity_PasswordEncoder.getClass().getName()=" + m_objSpringSecurity_PasswordEncoder.getClass().getName());
////        BCryptPasswordEncoder objPasswordEncoder = (BCryptPasswordEncoder) m_objSpringSecurity_PasswordEncoder;
//        // which is the default version of BCryptPasswordEncoder.BCryptVersion for the using objPasswordEncoder ?
//        // commented by crane zhou on 2021.11.15
//        // ... ...
////        m_objLogger.info("BCryptPasswordEncoder.BCryptVersion.values:" + BCryptPasswordEncoder.BCryptVersion.values().toString());
//
////        m_objLogger.info("objSourceUserData(AuthUsers).getPassword()=" + objSourceUserData.getPassword());
////        m_objLogger.info("objTargetUserDataEntity(AuthUsers).getPassword()=" + objTargetUserDataEntity.getPassword());
//    }

}
