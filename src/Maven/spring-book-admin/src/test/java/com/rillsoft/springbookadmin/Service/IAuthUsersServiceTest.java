package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.Config.DruidDataSourceConfig;
import com.rillsoft.springbookadmin.model.AuthUsers;
import org.junit.Assert;
// import org.junit.Test;
// org.junit.Test is using Maven junit:junit 4.13.2
// this will lead to following error:
// [ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.22.2:test (default-test)
// on project spring-book-admin: No tests were executed!
// (Set -DfailIfNoTests=false to ignore this error.) -> [Help 1]

import org.junit.jupiter.api.Test;
// org.junit.jupiter.api.Test is using Maven org.junit.jupiter:junit-jupiter-api:5.7.2

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import java.time.LocalTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IAuthUsersServiceTest {
    private static final Logger m_objLogger = LoggerFactory.getLogger(IAuthUsersServiceTest.class);

    private static final int UNITTEST_AUTH_USER_ID = 2001;

    private static final String UNITTEST_AUTH_USER_NAME = "Normal";

    private static final String UNITTEST_AUTH_USERS_FULLNAME = "Normal User Name";

    private static final int UNITTEST_AUTH_USER_ID_INSERT = 4031;
    private static final int UNITTEST_AUTH_USER_ID_DELETE = 4002;

    private static final int UNITTEST_AUTH_USER_ID_UPDATE = 4003;

    @Autowired
    private IAuthUsersService m_objAuthUsersService;

//    public IAuthUsersServiceTest(IAuthUsersService objAuthUsersService) {
//        this.m_objAuthUsersService = objAuthUsersService;
//    }

    @BeforeAll
    static void setupBeforeAll() {
    }
    @AfterAll
    static void cleanupAfterAll() {
    }

    @Test
    public void testSelectUserById() throws Exception {

        AuthUsers objTheUser = m_objAuthUsersService.selectUserById(UNITTEST_AUTH_USER_ID);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        m_objLogger.info("AuthUser ID: " + objTheUser.getId().toString());
        m_objLogger.info("-------------------------------------------------");

        Assert.assertNotNull(objTheUser);
        Assert.assertTrue(objTheUser.getId().equals(UNITTEST_AUTH_USER_ID));
    }

    @Test
    public void testSelectByUsername() throws Exception {

        AuthUsers objTheUser = m_objAuthUsersService.selectByUsername(UNITTEST_AUTH_USER_NAME);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        m_objLogger.info("AuthUser ID: " + objTheUser.getId().toString());
        m_objLogger.info("AuthUser Username: " + objTheUser.getUsername());
        m_objLogger.info("-------------------------------------------------");

        Assert.assertNotNull(objTheUser);
        Assert.assertTrue(objTheUser.getUsername().equalsIgnoreCase(UNITTEST_AUTH_USER_NAME));
    }

    @Test
    public void testSelectByFullname() throws Exception {

        String strFullnameFilter = "%" + UNITTEST_AUTH_USERS_FULLNAME + "%";
        List<AuthUsers> objAuthUsersList = m_objAuthUsersService.selectByFullname(strFullnameFilter);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        int nCount = objAuthUsersList.size();
        m_objLogger.info("AuthUser List Count: " + nCount);
        m_objLogger.info("-------------------------------------------------");

        for (int i = 0; i < nCount; i ++)
        {
            AuthUsers objAuthUser = objAuthUsersList.get(i);

            Assert.assertNotNull(objAuthUser);
            Assert.assertTrue(objAuthUser.getFullname().contains(UNITTEST_AUTH_USERS_FULLNAME));

            m_objLogger.info("AuthUser ID: " + objAuthUser.getId());
            m_objLogger.info("AuthUser Name: " + objAuthUser.getFullname());
        }
    }

    @Test
    public void testInsertAuthUser() throws Exception {

        AuthUsers objTheUser = new AuthUsers();

        Date dtNow = new Date();

        objTheUser.setId(UNITTEST_AUTH_USER_ID_INSERT);
//        objTheUser.setId(0);
        objTheUser.setUsername("user" + UNITTEST_AUTH_USER_ID_INSERT);
        objTheUser.setFullname("User Name " + UNITTEST_AUTH_USER_ID_INSERT);
        objTheUser.setPassword("password");
        objTheUser.setUserEmail("user" + UNITTEST_AUTH_USER_ID_INSERT + "@rillsoft.net");
        objTheUser.setDateJoined(dtNow);
        objTheUser.setLastLogin(dtNow);
        objTheUser.setUserStatus(1);
        objTheUser.setRoleId(102);

        int nResult = 0;

//        nResult = m_objAuthUsersService.insertAuthUser(objTheUser);
//        Assert.assertTrue(nResult > 0);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        m_objLogger.info("AuthUser Inserted User ID: " + objTheUser.getId().toString());
        m_objLogger.info("-------------------------------------------------");

    }

    @Test
    public void testDeleteUserById() throws Exception {

        int nResult = 0;

//        nResult = m_objAuthUsersService.deleteUserById(UNITTEST_AUTH_USER_ID_DELETE);
//        Assert.assertTrue(nResult > 0);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        m_objLogger.info("AuthUser Deleted User ID: " + UNITTEST_AUTH_USER_ID_DELETE);
        m_objLogger.info("-------------------------------------------------");
    }

    @Test
    public void testUpdateAuthUser() throws Exception {

        AuthUsers objTheUser = new AuthUsers();

        Date dtNow = new Date();
        SimpleDateFormat objDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        objTheUser = m_objAuthUsersService.selectUserById(UNITTEST_AUTH_USER_ID_UPDATE);

        Assert.assertNotNull(objTheUser);
        Assert.assertTrue(objTheUser.getId().equals(UNITTEST_AUTH_USER_ID_UPDATE));

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUsersService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        m_objLogger.info("AuthUser ID: " + objTheUser.getId().toString());
        m_objLogger.info("-------------------------------------------------");

//        objTheUser.setId(UNITTEST_AUTH_USER_ID_UPDATE);
//        objTheUser.setUsername("user" + UNITTEST_AUTH_USER_ID_UPDATE);
        objTheUser.setFullname("User Name " + objDateFormat.format(dtNow));
        objTheUser.setPassword("password" + objDateFormat.format(dtNow));
//        objTheUser.setUserEmail("user" + UNITTEST_AUTH_USER_ID_UPDATE + "@rillsoft.net");
//        objTheUser.setDateJoined(dtNow);
//        objTheUser.setLastLogin(dtNow);
//        objTheUser.setUserStatus(1);
//        objTheUser.setRoleId(102);

        int nResult = 0;

//        nResult = m_objAuthUsersService.updateAuthUser(objTheUser);
//        Assert.assertTrue(nResult > 0);

        m_objLogger.info("AuthUser Updated User ID: " + objTheUser.getId().toString());
        m_objLogger.info("-------------------------------------------------");

    }
}

/*
 *
 * mvn test -Dtest=IAuthUsersServiceTest
 * mvn test -Dtest=IAuthUsersServiceTest -Dmybatis.generator.skip=true
 * mvn test -Dmybatis.generator.skip=true
 *
 * */
