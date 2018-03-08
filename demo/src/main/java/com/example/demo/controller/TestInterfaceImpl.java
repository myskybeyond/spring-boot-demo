package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.TestEntity;
import com.example.demo.repository.CustomRepository;
import com.example.demo.repository.TTestRepository;
import com.example.demo.repository.TestDao;

@RestController
public class TestInterfaceImpl {

	@Autowired
	TTestRepository itestRepository;
	
	@Autowired
	CustomRepository customRepository;
	
	@Autowired
	TestDao testDao;
	
	@RequestMapping("/findById")
	public String testRep(){
		TestEntity entity = itestRepository.findByUserName("ZhangSan");
		return entity.toString();
	}

	@RequestMapping("/add")
	public String testAdd(){
		TestEntity entity = new TestEntity("LiSi","123456");
		itestRepository.save(entity);
		return entity.toString();
	}
	
	@RequestMapping("/queryPage")
	public String queryPage(@PageableDefault(value=20,sort={"id","userName"},direction = Sort.Direction.DESC) Pageable pageable){
		Page<TestEntity> page = itestRepository.queryByUserName("ZhangSan", pageable);
		return page.toString();
	}
	
	@RequestMapping("/querySlice")
	public String querySlice(@PageableDefault(value=20,sort={"id","userName"},direction = Sort.Direction.DESC) Pageable pageable){
		Slice<TestEntity> slice = itestRepository.queryById(1l, pageable);
		return slice.getContent().get(0).toString();
	}
	
	@RequestMapping("/testAdd")
	public String testCustomAdd(){
		TestEntity entity = new TestEntity("WangWu","123456");
		customRepository.save(entity);
		return entity.toString();
	}
	
	@RequestMapping("/testCustom")
	public String testCustomCount(){
		return customRepository.sayHello();
	}
	
	@RequestMapping("/queryPage1")
	public String queryPage1(@PageableDefault(value=20,sort={"id","userName"},direction = Sort.Direction.DESC) Pageable pageable){
		Page<TestEntity> page = customRepository.queryByUserName("ZhangSan", pageable);
		return page.toString();
	}
	
	@RequestMapping("/testDao")
	public String testDao(){
		return testDao.customMethod();
	}
	
	@RequestMapping("/{id}")
	public String showNameById(@PathVariable("id") TestEntity test){
		return "show name :"+test.getUserName();
	}
}
