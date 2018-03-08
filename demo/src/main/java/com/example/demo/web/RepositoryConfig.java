package com.example.demo.web;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.repository.BaseDaoFactoryBean;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactoryTest", transactionManagerRef = "transactionManagerTest", basePackages = {"com.example.demo.data","com.example.demo.repository"},repositoryFactoryBeanClass=BaseDaoFactoryBean.class)
public class RepositoryConfig {

	@Autowired
	@Qualifier("testDs")
	private DataSource testDs;

	@Autowired
	private JpaProperties jpaProperties;

	private Map<String, String> getVendorProperties(DataSource dataSource) {
		return jpaProperties.getHibernateProperties(dataSource);

	}

	@Bean(name = "entityManagerFactoryTest")
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryPrimary(EntityManagerFactoryBuilder builder) {
		return builder.dataSource(testDs).properties(getVendorProperties(testDs)).packages("com.example.demo.data").persistenceUnit("testPersistenceUnit").build();
	}

	@Bean(name = "transactionManagerTest")
	@Primary
	public PlatformTransactionManager transcationManagerPrimary(EntityManagerFactoryBuilder builder) {
		return new JpaTransactionManager(entityManagerFactoryPrimary(builder).getObject());
	}
}
