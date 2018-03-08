package com.example.demo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.data.TestEntity;

/**
 * 已知实现+自定义接口实现
* Title:   <br/>
* Description: 
* @ClassName: CustomRepository
* @author ljt
* @date 2018年3月7日 上午11:13:03
*
 */
public interface CustomRepository extends CrudRepository<TestEntity, Long>,JpaSpecificationExecutor<TestEntity>,Custom{

	Page<TestEntity> queryByUserName(String userName,Pageable pageable);
}
