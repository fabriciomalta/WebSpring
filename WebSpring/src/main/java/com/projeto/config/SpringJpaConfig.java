package com.projeto.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.projeto.model.Usuario;
import com.projeto.repository.UsuarioRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses = UsuarioRepository.class)
@ComponentScan(basePackageClasses = UsuarioRepository.class)
@EnableTransactionManagement
public class SpringJpaConfig {
	
	@Autowired
	private Environment env;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		return dataSource;
	}
	
	@Bean
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource);
		factory.setPackagesToScan(Usuario.class.getPackage().getName());
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setJpaProperties(jpaProperties());
		factory.afterPropertiesSet();
		return factory.getObject();
	}

    @Bean
	public JpaVendorAdapter jpaVendorAdapter() {
    	HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
    	adapter.setDatabase(Database.MYSQL);
    	adapter.setDatabasePlatform(env.getProperty("spring.jpa.database-platform"));
    	adapter.setGenerateDdl(true);
    	return adapter;
	}
    
    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
    	JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
    	jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
    	return jpaTransactionManager;
    }
    
    
    private Properties jpaProperties() {
    	Properties props = new Properties();
    	props.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
    	props.setProperty("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
    	props.setProperty("hibernate.current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
		props.setProperty("hibernate.jdbc.lob.non_contextual_creation", env.getProperty("spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation"));
		props.setProperty("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
		props.setProperty("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
    	return props;
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
