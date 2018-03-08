package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.data.TestEntity;
public interface TTestRepository extends CrudRepository<TestEntity, Long>,JpaSpecificationExecutor<TestEntity>{

	TestEntity findByUserName(String userName);
	
	Page<TestEntity> queryByUserName(String userName,Pageable pageable);
	
	Slice<TestEntity> queryById(Long Id,Pageable pageable);
	
	List<TestEntity> findBypassWord(String passWord,Sort sort);
}
