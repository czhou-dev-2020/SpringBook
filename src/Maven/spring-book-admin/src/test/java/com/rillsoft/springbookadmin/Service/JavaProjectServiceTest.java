package com.rillsoft.springbookadmin.Service;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JavaProjectServiceTest {
    private static org.slf4j.Logger m_objLogger = LoggerFactory.getLogger(JavaProjectServiceTest.class);

//  @Rule
//  public ExpectedException throw = ExpectedException.none();

//    @Test(expected=IndexOutOfBoundsException.class)
    @Test
    public void TestServiceMethod ()
    {
        m_objLogger.info("========================================");
        m_objLogger.info(JavaProjectServiceTest.class.getName());
        m_objLogger.info("----------------------------------------");

        boolean bResult = true;
        Assert.assertTrue(bResult);

//        Assert.assertTrue(false);
    }

}

/*

mvn test -Dtest=JavaProjectServiceTest
 */