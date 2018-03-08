package com.example.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.TestEntity;
import com.example.demo.repository.TTestRepository;

//@RestController
public class TestInterfaceImpl {

	@Autowired
	TTestRepository itestRepository;
	
	/*@RequestMapping("/findById")
	public String testRep(){
		TestEntity entity = itestRepository.findById(1L);
		return entity.toString();
	}*/

	@RequestMapping("/add")
	public String testAdd(){
		TestEntity entity = new TestEntity("ZhangSan","123456");
		itestRepository.save(entity);
		return entity.toString();
	}
}
