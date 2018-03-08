package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner{

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("我被执行了。。。");
	}

	/*@Autowired
	public MyBean(ApplicationArguments args){
		boolean debug = args.containsOption("debug");
		//List<String> files = args.getNonOptionArgs();
		System.out.println("是否是调试模式"+debug);
		
	}*/
}
