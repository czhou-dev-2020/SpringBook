package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.model.AuthRoles;
import com.rillsoft.springbookadmin.model.AuthUserRoles;
import com.rillsoft.springbookadmin.model.AuthUsers;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IAuthUserRolesServiceTest {
    private static final Logger m_objLogger = LoggerFactory.getLogger(IAuthUserRolesServiceTest.class);

    private static final int UNITTEST_AUTH_USER_ID = 2001;

    private static final int UNITTEST_AUTH_ROLE_ID = 101;

    @Autowired
    private IAuthUserRolesService m_objAuthUserRolesService;

//    public IAuthUserRolesServiceTest(IAuthUserRolesService objAuthUserRolesService) {
//        this.m_objAuthUserRolesService = objAuthUserRolesService;
//    }

    @BeforeAll
    static void setupBeforeAll() {
    }
    @AfterAll
    static void cleanupAfterAll() {
    }

    @Test
    public void testSelectAuthUserRolesByUserId() throws Exception {

//        Assert.assertNotNull(m_objAuthUserRolesService);
        List<AuthUserRoles> objTheUserRoles = m_objAuthUserRolesService.selectAuthUserRolesByUserId(UNITTEST_AUTH_USER_ID);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUserRolesService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        Assert.assertNotNull(objTheUserRoles);

        for(AuthUserRoles objTheUserRole : objTheUserRoles) {
            m_objLogger.info("AuthUser ID: " + objTheUserRole.getUserId().toString());
            m_objLogger.info("AuthRole ID: " + objTheUserRole.getRoleId().toString());
            m_objLogger.info("-------------------------------------------------");

            Assert.assertTrue(objTheUserRole.getUserId().equals(UNITTEST_AUTH_USER_ID));
        }
    }

    @Test
    public void testSelectAuthUserRolesByRoleId() throws Exception {

       List<AuthUserRoles> objTheUserRoles = m_objAuthUserRolesService.selectAuthUserRolesByRoleId(UNITTEST_AUTH_ROLE_ID);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUserRolesService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        Assert.assertNotNull(objTheUserRoles);

        for(AuthUserRoles objTheUserRole : objTheUserRoles) {
            m_objLogger.info("AuthUser ID: " + objTheUserRole.getUserId().toString());
            m_objLogger.info("AuthRole ID: " + objTheUserRole.getRoleId().toString());
            m_objLogger.info("-------------------------------------------------");

            Assert.assertTrue(objTheUserRole.getRoleId().equals(UNITTEST_AUTH_ROLE_ID));
        }
    }

    @Test
    public void testSelectAuthRolesByUserId() throws Exception {

        AuthUsers objTheAuthUser = m_objAuthUserRolesService.selectAuthRolesByUserId(UNITTEST_AUTH_USER_ID);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUserRolesService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        Assert.assertNotNull(objTheAuthUser);
        Assert.assertTrue(objTheAuthUser.getId().equals(UNITTEST_AUTH_USER_ID));

        List <AuthRoles> objTheAuthRoles = objTheAuthUser.getAuthRoles();

        Assert.assertNotNull(objTheAuthRoles);
        Assert.assertTrue(objTheAuthRoles.size() > 0);

        for(AuthRoles objTheUserRole : objTheAuthRoles) {

            m_objLogger.info("AuthRole ID: " + objTheUserRole.getId().toString());
            m_objLogger.info("AuthRole Name: " + objTheUserRole.getRoleName());
            m_objLogger.info("AuthRole Code: " + objTheUserRole.getRoleCode());

            m_objLogger.info("-------------------------------------------------");
        }
    }
}

/*
 *
 * mvn test -Dtest=IAuthUserRolesServiceTest
 * mvn test -Dtest=IAuthUserRolesServiceTest -Dmybatis.generator.skip=true
 * mvn test -Dmybatis.generator.skip=true
 *
 * */