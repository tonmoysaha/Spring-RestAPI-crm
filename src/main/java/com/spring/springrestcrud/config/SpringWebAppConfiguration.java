package com.spring.springrestcrud.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@ComponentScan("com.spring.springrestcrud")
@PropertySource("classpath:persistence-mysql.properties")
public class SpringWebAppConfiguration {
	
	@Autowired
	private Environment env;
	
	Logger logger = Logger.getLogger(getClass().getName()); 
	
	@Bean
	public ViewResolver viewResolverApp() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		try {
			dataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger.info(">>jdbc url: "+env.getProperty("jdbc.url"));
		
		dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		dataSource.setUser(env.getProperty("jdbc.user"));
		dataSource.setPassword(env.getProperty("jdbc.password"));
		dataSource.setMaxIdleTime(helperClass(env.getProperty("connection.pool.maxIdleTime")));
		dataSource.setMinPoolSize(helperClass(env.getProperty("connection.pool.minPoolSize")));
		dataSource.setMaxPoolSize(helperClass(env.getProperty("connection.pool.maxPoolSize")));
		dataSource.setInitialPoolSize(helperClass(env.getProperty("connection.pool.initialPoolSize")));
		
		logger.info(">>maxpool: "+helperClass(env.getProperty("connection.pool.maxPoolSize")) );
		return dataSource;
		
		
	}
	
	private int helperClass(String property) {
		
	     int value = Integer.parseInt(property);
		return value;
		
	}
	
	private Properties getHibernetProperties() {
		
		Properties properties = new Properties();
		
		properties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return properties;
		
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(env.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernetProperties());
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}

}
