package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.model.AuthGroups;
import com.rillsoft.springbookadmin.model.AuthRoles;
import com.rillsoft.springbookadmin.model.AuthUsers;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

// added by crane zhou on 2021.11.15
// Refer to:
//      https://docs.spring.io/spring-data/jpa/docs/current/api/org/springframework/data/
//          jpa/repository/JpaRepository.html
//

@RunWith(SpringRunner.class)
@SpringBootTest
public class RegisterAuthUsersServiceTest {

    private static final Logger m_objLogger = LoggerFactory.getLogger(RegisterAuthUsersServiceTest.class);

    private static final int UNITTEST_AUTH_USER_ID = 2002;

    private static final String UNITTEST_AUTH_USER_NAME = "Normal";

    private static final int UNITTEST_AUTH_USER_ID_REGISTER = 4011;
    private static final int UNITTEST_AUTH_USER_ID_TODELETE = 4042;
    private static final String UNITTEST_AUTH_USER_NAME_REGISTER = "Normal";

    @Autowired
    private RegisterAuthUsersService m_objRegisterAuthUsersService;

    @Test
    public void testRegisterAuthUser() throws Exception {
        AuthUsers objTheAuthUser = new AuthUsers();

        Date dtNow = new Date();

//        objTheAuthUser.setId(UNITTEST_AUTH_USER_ID_REGISTER);
        objTheAuthUser.setId(0);
        objTheAuthUser.setUsername("Test" + UNITTEST_AUTH_USER_NAME_REGISTER);
        objTheAuthUser.setFullname("Test User Name " + UNITTEST_AUTH_USER_NAME_REGISTER);
        objTheAuthUser.setPassword("password");
        objTheAuthUser.setUserEmail("test" + UNITTEST_AUTH_USER_NAME_REGISTER + "@rillsoft.net");
        objTheAuthUser.setDateJoined(dtNow);
        objTheAuthUser.setLastLogin(dtNow);

        objTheAuthUser.setUserStatus(1);
        objTheAuthUser.setRoleId(102);

        int nResult = 0;

//        nResult = m_objRegisterAuthUsersService.registerAuthUser(objTheAuthUser);
//        Assert.assertTrue(nResult > 0);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objRegisterAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        m_objLogger.info("AuthUser Registered User ID: " + objTheAuthUser.getId().toString());
        m_objLogger.info("-------------------------------------------------");
    }

    @Test
    public void testCheckIfUsernameExist() {
//        m_objRegisterAuthUsersService.checkIfUsernameExist(UNITTEST_AUTH_USER_NAME);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objRegisterAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

//        m_objLogger.info("AuthUser ID: " + objTheUser.getId().toString());
        m_objLogger.info("AuthUser Username: " + UNITTEST_AUTH_USER_NAME);
        m_objLogger.info("-------------------------------------------------");

        Assert.assertTrue(m_objRegisterAuthUsersService.checkIfUsernameExist(UNITTEST_AUTH_USER_NAME));
    }

    @Test
    public void testCheckIfUserIdExist() {
//        m_objRegisterAuthUsersService.checkIfUserIdExist(UNITTEST_AUTH_USER_ID);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objRegisterAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        m_objLogger.info("AuthUser ID: " + UNITTEST_AUTH_USER_ID);
//        m_objLogger.info("AuthUser ID: " + UNITTEST_AUTH_USER_ID_TODELETE);
        m_objLogger.info("-------------------------------------------------");

        Assert.assertTrue(m_objRegisterAuthUsersService.checkIfUserIdExist(UNITTEST_AUTH_USER_ID));
//        Assert.assertTrue(m_objRegisterAuthUsersService.checkIfUserIdExist(UNITTEST_AUTH_USER_ID_TODELETE));
    }

    @Test
    public void testDeleteAuthUser() throws Exception {
        AuthUsers objTheAuthUser = new AuthUsers();

        Date dtNow = new Date();

        int nResult = 0;

        objTheAuthUser.setId(UNITTEST_AUTH_USER_ID_TODELETE);

        nResult = m_objRegisterAuthUsersService.deleteAuthUser(objTheAuthUser);
        Assert.assertTrue(nResult > 0);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objRegisterAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        m_objLogger.info("AuthUser Deleted User ID: " + objTheAuthUser.getId().toString());
        m_objLogger.info("-------------------------------------------------");
    }
}

/*
 *
 * mvn test -Dtest=RegisterAuthUsersServiceTest
 * mvn test -Dtest=RegisterAuthUsersServiceTest -Dmybatis.generator.skip=true
 * mvn test -Dmybatis.generator.skip=true
 *
 * */
