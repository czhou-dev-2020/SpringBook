package com.rillsoft.springbookadmin.Service;

import com.rillsoft.springbookadmin.model.*;
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
public class IAuthUserGroupsServiceTest {

    private static final Logger m_objLogger = LoggerFactory.getLogger(IAuthUserGroupsServiceTest.class);

    private static final int UNITTEST_AUTH_USER_ID = 2002;

    private static final int UNITTEST_AUTH_GROUP_ID = 102;

    @Autowired
    private IAuthUserGroupsService m_objAuthUserGroupsService;

//    public IAuthUserGroupsServiceTest(IAuthUserGroupsService objAuthUserGroupsService) {
//        this.m_objAuthUserGroupsService = objAuthUserGroupsService;
//    }

    @BeforeAll
    static void setupBeforeAll() {
    }
    @AfterAll
    static void cleanupAfterAll() {
    }

    @Test
    public void testSelectUserGroupsByUserId() throws Exception {

//        Assert.assertNotNull(m_objAuthUserGroupsService);
        List<AuthUserGroups> objTheUserGroups = m_objAuthUserGroupsService.selectAuthUserGroupsByUserId(UNITTEST_AUTH_USER_ID);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUserGroupsService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        Assert.assertNotNull(objTheUserGroups);

        for(AuthUserGroups objTheUserGroup : objTheUserGroups) {
            m_objLogger.info("AuthUser ID: " + objTheUserGroup.getUserId().toString());
            m_objLogger.info("AuthGroup ID: " + objTheUserGroup.getGroupId().toString());
            m_objLogger.info("-------------------------------------------------");

            Assert.assertTrue(objTheUserGroup.getUserId().equals(UNITTEST_AUTH_USER_ID));
        }
    }

    @Test
    public void testSelectUserGroupsByGroupId() throws Exception {

        List<AuthUserGroups> objTheUserGroups = m_objAuthUserGroupsService.selectAuthUserGroupsByGroupId(UNITTEST_AUTH_GROUP_ID);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUserGroupsService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        Assert.assertNotNull(objTheUserGroups);

        for(AuthUserGroups objTheUserGroup : objTheUserGroups) {
            m_objLogger.info("AuthUser ID: " + objTheUserGroup.getUserId().toString());
            m_objLogger.info("AuthGroup ID: " + objTheUserGroup.getGroupId().toString());
            m_objLogger.info("-------------------------------------------------");

            Assert.assertTrue(objTheUserGroup.getGroupId().equals(UNITTEST_AUTH_GROUP_ID));
        }
    }

    @Test
    public void testSelectAuthGroupsByUserId() throws Exception {

        AuthUsers objTheAuthUser = m_objAuthUserGroupsService.selectAuthGroupsByUserId(UNITTEST_AUTH_USER_ID);

        m_objLogger.info("=================================================");
        m_objLogger.info(m_objAuthUserGroupsService.getClass().getName());
        m_objLogger.info(Thread.currentThread().getStackTrace()[1].getMethodName());

        Assert.assertNotNull(objTheAuthUser);
        Assert.assertTrue(objTheAuthUser.getId().equals(UNITTEST_AUTH_USER_ID));

        List <AuthGroups> objTheAuthGroups = objTheAuthUser.getAuthGroups();

        Assert.assertNotNull(objTheAuthGroups);
        Assert.assertTrue(objTheAuthGroups.size() > 0);

        for(AuthGroups objTheUserGroup : objTheAuthGroups) {

            m_objLogger.info("AuthGroup ID: " + objTheUserGroup.getId().toString());
            m_objLogger.info("AuthGroup Name: " + objTheUserGroup.getGroupName());
            m_objLogger.info("AuthGroup Code: " + objTheUserGroup.getGroupCode());

            m_objLogger.info("-------------------------------------------------");
        }
    }

}

/*
 *
 * mvn test -Dtest=IAuthUserGroupsServiceTest
 * mvn test -Dtest=IAuthUserGroupsServiceTest -Dmybatis.generator.skip=true
 * mvn test -Dmybatis.generator.skip=true
 *
 * */