package com.gdyx.dbo.conf;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * mybatis配置类
 * @author Niu Li
 * @date 2016/8/12
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig implements TransactionManagementConfigurer,EnvironmentAware{
    @Resource(name = "dataSource")
    DataSource dataSource;
    Logger log = LoggerFactory.getLogger(MybatisConfig.class);
    /**
     * 可以通过这个类,详细配置mybatis
     * @return
     */
//    @Bean
//    public org.apache.ibatis.session.Configuration mybatisSetting(){
//        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
//        return configuration;
//    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {

        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        log.debug("Package："+property.getProperty("type-aliases-package"));
        log.debug("Mapper："+property.getProperty("type-aliases-package"));
        bean.setTypeAliasesPackage(property.getProperty("type-aliases-package"));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(evn.getProperty("mybatis.mapper-locations")));
        /*
        //分页插件,插件无非是设置mybatis的拦截器
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        bean.setPlugins(new Interceptor[]{pageHelper});*/

        return bean.getObject();
    }

    /**
     * 用于实际查询的sql工具,传统dao开发形式可以使用这个,基于mapper代理则不需要注入
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    /**
     * 事务管理,具体使用在service层加入@Transactional注解
     */
    @Bean(name = "transactionManager")
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }
    private Environment evn;
    private RelaxedPropertyResolver property;
    @Override
    public void setEnvironment(Environment environment) {
        this.evn=environment;
        this.property=new RelaxedPropertyResolver(evn,"spring.datasource.");
    }
}
