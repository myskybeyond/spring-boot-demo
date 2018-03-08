package com.example.demo;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication
public class ExitCodeApplicationDemo {

	@Bean
	public ExitCodeGenerator exitCode(){
		return new ExitCodeGenerator() {
			
			@Override
			public int getExitCode() {
				// TODO Auto-generated method stub
				return 400;
			}
		};
	}
	
	/*public static void main(String[] args) {
		int exitCode = SpringApplication
				.exit(SpringApplication.run(ExitCodeApplicationDemo.class, args));
		System.out.println("我的退出code被重写了:"+exitCode);
		System.exit(exitCode);
	}*/
}
