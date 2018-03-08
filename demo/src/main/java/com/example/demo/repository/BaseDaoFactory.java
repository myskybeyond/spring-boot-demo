package com.example.demo.repository;

import java.io.Serializable;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.core.RepositoryInformation;
import org.springframework.data.repository.core.RepositoryMetadata;

public class BaseDaoFactory<S,ID extends Serializable> extends JpaRepositoryFactory {

	public BaseDaoFactory(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

	
	
	/* (非 Javadoc) 
	* <p>Title: getTargetRepository</p> 
	* <p>Description: </p> 
	* @param information
	* @param entityManager
	* @return 
	* @see org.springframework.data.jpa.repository.support.JpaRepositoryFactory#getTargetRepository(org.springframework.data.repository.core.RepositoryInformation, javax.persistence.EntityManager) 
	*/ 
	@Override
	protected <T, ID extends Serializable> SimpleJpaRepository<?, ?> getTargetRepository(RepositoryInformation information, EntityManager entityManager) {
		// TODO Auto-generated method stub
		//return super.getTargetRepository(information, entityManager);
		return new BaseDaoImpl<>(information.getDomainType(), entityManager);
	}



	/* (非 Javadoc) 
	* <p>Title: getRepositoryBaseClass</p> 
	* <p>Description: </p> 
	* @param metadata
	* @return 
	* @see org.springframework.data.jpa.repository.support.JpaRepositoryFactory#getRepositoryBaseClass(org.springframework.data.repository.core.RepositoryMetadata) 
	*/ 
	@Override
	protected Class<?> getRepositoryBaseClass(RepositoryMetadata metadata) {
		// TODO Auto-generated method stub
		//return super.getRepositoryBaseClass(metadata);
		return BaseDao.class;
	}
	
	

}
