package com.rillsoft.springbookadmin.Config;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.fastjson.JSON;

import com.rillsoft.springbookadmin.JUnit.JavaProjectWorker;
import com.rillsoft.springbookadmin.JUnit.MemoryAppender;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

// import org.junit.Test;
// import org.junit.runner.RunWith;

// @RunWith(SpringRunner.class)
@SpringBootTest
public class DataSourceConfigTests {

    private static org.slf4j.Logger m_objLogger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

    @Autowired
    ApplicationContext m_objApplicationContext;

    @Autowired
    DruidDataSourceConfig m_objDruidDataSourceConfig;

    @BeforeAll
    static void setupBeforeAll() {
    }

    @AfterAll
    static void cleanupAfterAll() {
    }

    @Test
    public void testDataSource() throws Exception {
        // Get configured data source
        DruidDataSource dataSource = m_objApplicationContext.getBean(DruidDataSource.class);
        // View Configuration Data Source Information
        m_objLogger.info("=================================================");
        m_objLogger.info(dataSource.getClass().getName());
        m_objLogger.info("-------------------------------------------------");
//        m_objLogger.info(JSON.toJSONString(druidDataSourceConfig));
        m_objLogger.info(m_objDruidDataSourceConfig.getDataSource().getDriverClassName());
        m_objLogger.info("-------------------------------------------------");
/*
        System.out.println("=================================================");
        System.out.println(dataSource.getClass().getName());
        System.out.println("-------------------------------------------------");
//        System.out.println(JSON.toJSONString(druidDataSourceConfig));
        System.out.println(druidDataSourceConfig.getDataSource().getDriverClassName());
        System.out.println("-------------------------------------------------");
*/
    }


    @Test
    public void testJDBCConnection() throws Exception {
        DruidDataSource objDruidDataSource = m_objDruidDataSourceConfig.getDataSource();

        m_objLogger.info("=================================================");
        m_objLogger.info(JSON.toJSONString(objDruidDataSource.getDriverClassName()));
        m_objLogger.info("-------------------------------------------------");

        Connection objConnection = objDruidDataSource.getConnection();

        String strSQL = "SELECT id, city_name, city_code, city_status, remark FROM tbl_sites_city"
                + " WHERE city_name='Shanghai'";
        PreparedStatement objPS = objConnection.prepareStatement(strSQL);
        ResultSet objRS = objPS.executeQuery();
        List<String> objDataList = new ArrayList<String>();
        while (objRS.next())
        {
            objDataList.add(objRS.getInt("id") + "," +
                    objRS.getString("city_name") + "," +
                    objRS.getString("city_code"));
        }

        // Get DataSource and Connection (Bean) from Application Context (Project: Spring Book Admin)
        // Don't need to close manually.
        // commented by crane zhou on 2021.11.17

//        objPS.close();
//        objConnection.close();
//        objDruidDataSource.close();

        Assert.assertTrue(objDataList.size() == 1);
        Assert.assertTrue(objDataList.get(0).equals("1001,Shanghai,021"));

        m_objLogger.info("========================================");
        m_objLogger.info(objDataList.get(0).toString());
        m_objLogger.info("----------------------------------------");
    }
}

/*
 *
 * mvn test -Dtest=DataSourceConfigTests
 *
 * */