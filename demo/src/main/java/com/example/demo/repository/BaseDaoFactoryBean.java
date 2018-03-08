package com.example.demo.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean;
import org.springframework.data.repository.core.support.RepositoryFactorySupport;

public class BaseDaoFactoryBean<R extends JpaRepository<S, ID>,S,ID extends Serializable> extends JpaRepositoryFactoryBean<R, S, ID>{

	public BaseDaoFactoryBean(Class<? extends R> repositoryInterface) {
		super(repositoryInterface);
		// TODO Auto-generated constructor stub
	}

	/* (非 Javadoc) 
	* <p>Title: createRepositoryFactory</p> 
	* <p>Description: </p> 
	* @param entityManager
	* @return 
	* @see org.springframework.data.jpa.repository.support.JpaRepositoryFactoryBean#createRepositoryFactory(javax.persistence.EntityManager) 
	*/ 
	@SuppressWarnings("rawtypes")
	@Override
	protected RepositoryFactorySupport createRepositoryFactory(EntityManager entityManager) {
		// TODO Auto-generated method stub
		//return super.createRepositoryFactory(entityManager);
		return new BaseDaoFactory(entityManager);
	}

}
