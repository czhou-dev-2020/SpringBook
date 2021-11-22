package com.rillsoft.springbookadmin.Config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.support.spring.stat.DruidStatInterceptor;
import com.alibaba.druid.util.StringUtils;
import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

// import org.springframework.jdbc.datasource.DataSourceTransactionManager;
// import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import org.springframework.core.env.Environment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author crane zhou on 09.14.2021
 *
 * For more detail information of Druid,
 * Please refer to:
 *   https://github.com/alibaba/druid
 */

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
//@EnableConfigurationProperties(DataSourceProperties.class)
public class DruidDataSourceConfig implements EnvironmentAware {

    // public DruidDataSourceConfig() {
    //// TODO Auto-generated constructor stub
    //}

    private static final Logger m_objLogger = LoggerFactory.getLogger(DruidDataSourceConfig.class);

//      @Value("${spring.datasource.url}")
//      private String url;

    //	  @Autowired
    private Environment m_objEnvironment;

    // Note:
    // https://github.com/spring-projects/spring-boot/wiki/Spring-Boot-2.0-Migration-Guide
    // RelaxedPropertyResolver is no longer available as the Environment takes care of that automatically:
    // env.getProperty("com.foo.my-bar") will find a com.foo.myBar property.
    //
    @Override
    public void setEnvironment(Environment environment) {
        String strProjectName = environment.getProperty("spring.datasource.project");
        m_objLogger.info("init Druid Servlet Configuration ");
        m_objLogger.info(strProjectName);

        m_objEnvironment = environment;
    }

    /*
    @Bean
    public JdbcTemplate JdbcTemplate(){
        return new JdbcTemplate(druidDataSource());
    }
    */

    @Bean(initMethod = "init", destroyMethod = "close")
    public DruidDataSource getDataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();

        if (StringUtils.isEmpty(m_objEnvironment.getProperty("spring.datasource.url"))) {
            m_objLogger.error("Your database connection pool configuration is incorrect!"
                    + " Please check your Spring profile, current profiles are:"
                    + Arrays.toString(m_objEnvironment.getActiveProfiles()));
            throw new ApplicationContextException(
                    "Database connection pool is not configured correctly");
        }

        druidDataSource.setUrl(m_objEnvironment.getProperty("spring.datasource.url"));
        druidDataSource.setDriverClassName(m_objEnvironment.getProperty("spring.datasource.driverClassName"));
        druidDataSource.setUsername(m_objEnvironment.getProperty("spring.datasource.username"));
        druidDataSource.setPassword(m_objEnvironment.getProperty("spring.datasource.password"));

        druidDataSource.setInitialSize(Integer.valueOf(m_objEnvironment.getProperty("spring.datasource.initial-size")));
        druidDataSource.setMinIdle(Integer.valueOf(m_objEnvironment.getProperty("spring.datasource.min-idle")));
//	      druidDataSource.setMaxIdle(Integer.valueOf(m_objEnvironment.getProperty("spring.datasource.max-idle")));

        druidDataSource.setMaxActive(Integer.valueOf(m_objEnvironment.getProperty("spring.datasource.max-active")));
        druidDataSource.setMaxWait(Long.valueOf(m_objEnvironment.getProperty("spring.datasource.max-wait-millis")));
        druidDataSource.setValidationQuery(m_objEnvironment.getProperty("spring.datasource.validation-query"));

        druidDataSource.setTestWhileIdle(Boolean.parseBoolean(m_objEnvironment.getProperty("spring.datasource.test-while-idle")));
        druidDataSource.setTestOnBorrow(Boolean.parseBoolean(m_objEnvironment.getProperty("spring.datasource.test-on-borrow")));
        druidDataSource.setTestOnReturn(Boolean.parseBoolean(m_objEnvironment.getProperty("spring.datasource.test-on-return")));

        druidDataSource.setMinEvictableIdleTimeMillis(
                Long.valueOf(m_objEnvironment.getProperty("spring.datasource.min-evictable-idle-time-millis")));
        druidDataSource.setTimeBetweenEvictionRunsMillis(
                Long.parseLong(m_objEnvironment.getProperty("spring.datasource.time-between-eviction-runs-millis")));

        druidDataSource.setPoolPreparedStatements(
                Boolean.parseBoolean(m_objEnvironment.getProperty("spring.datasource.poolPreparedStatements")));
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(
                Integer.parseInt(m_objEnvironment.getProperty("spring.datasource.maxPoolPreparedStatementPerConnectionSize")));

        m_objLogger.info(m_objEnvironment.getProperty("spring.datasource.filters"));

        try
        {
            druidDataSource.setFilters(m_objEnvironment.getProperty("spring.datasource.filters"));
        } catch (SQLException e)
        {
            e.printStackTrace();
        }

        return druidDataSource;
    }

    // by crane zhou on 2021.09.15
    // Compile Warning:
    // unchecked call to setServlet(T) as a member of the raw type org.springframework.boot.web.servlet.ServletRegistrationBean
    // use <compilerArgument>-Xlint:unchecked</compilerArgument> to locate the error in the source code
    // Try to generify "DruidDataSourceConfig.java" (Convert Raw Types to Generics)
    // ServletRegistrationBean >> ServletRegistrationBean<StatViewServlet> when declaring
    // FilterRegistrationBean >> FilterRegistrationBean<WebStatFilter> when declaring
    @Bean
    public ServletRegistrationBean<StatViewServlet> druidServlet() {
        m_objLogger.info("init Druid Servlet Configuration ");
        ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>();
        StatViewServlet statViewServlet = new StatViewServlet();
        servletRegistrationBean.setServlet(statViewServlet);
//        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<String, String>();
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "admin");
        initParameters.put("resetEnable", "false");		// disable "Reset All" function on HTML Page
        initParameters.put("allow", ""); 				// IP WhiteList (default allow to access, "" allow to access)
        //initParameters.put("deny", "192.168.20.38");	// IP BlackList (deny has high priority to allow)
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
        WebStatFilter webStatFilter = new WebStatFilter();
        filterRegistrationBean.setFilter(webStatFilter);
//        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/druid/*");
//        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }

    // intercept by bean id to monitor bean
    @Bean(value = "druid-stat-interceptor")
    public DruidStatInterceptor DruidStatInterceptor() {
        DruidStatInterceptor druidStatInterceptor = new DruidStatInterceptor();
        return druidStatInterceptor;
    }

    @Bean
    public BeanNameAutoProxyCreator beanNameAutoProxyCreator() {
        BeanNameAutoProxyCreator beanNameAutoProxyCreator = new BeanNameAutoProxyCreator();
        beanNameAutoProxyCreator.setProxyTargetClass(true);
        // setup bean id which is need to monitor
        // beanNameAutoProxyCreator.setBeanNames("sysRoleMapper","loginController");
        beanNameAutoProxyCreator.setInterceptorNames("druid-stat-interceptor");
        return beanNameAutoProxyCreator;
    }

//	  @Bean
//	  public SqlSessionFactory sqlSessionFactory() throws Exception {
//	      SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//	      sqlSessionFactoryBean.setDataSource(dataSource());
//	      //mybatis分页
//	      PageHelper pageHelper = new PageHelper();
//	      Properties props = new Properties();
//	      props.setProperty("dialect", "mysql");
//	      props.setProperty("reasonable", "true");
//	      props.setProperty("supportMethodsArguments", "true");
//	      props.setProperty("returnPageInfo", "check");
//	      props.setProperty("params", "count=countSql");
//	      pageHelper.setProperties(props); // add property (plugin ?)
//	      sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
//	      PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//	      sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*.xml"));
////	      sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:com/rillsoft/stackpo/sqlmap/*.xml"));
//	      return sqlSessionFactoryBean.getObject();
//	  }

    @Bean
    public PlatformTransactionManager transactionManager() throws SQLException {
        return new DataSourceTransactionManager(getDataSource());
    }
}

