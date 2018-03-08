package com.example.demo.web;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.example.demo.filter.LogFilter;

@Configuration
@EnableWebMvc
public class WebConfig {

	/**
	 * 字符集过滤器 Title: <br/>
	 * Description:
	 * @return
	 */
	@Bean
	public FilterRegistrationBean characterFilter() {
		FilterRegistrationBean characterFilter = new FilterRegistrationBean();
		characterFilter.setFilter(new CharacterEncodingFilter("utf-8"));
		characterFilter.addUrlPatterns("/*");
		return characterFilter;
	}

	/**
	 * 日志过滤器 Title: <br/>
	 * Description:
	 * @return
	 */
	@Bean
	public FilterRegistrationBean logFilter() {
		FilterRegistrationBean logFilter = new FilterRegistrationBean();
		logFilter.setFilter(new LogFilter());
		logFilter.addUrlPatterns("/*");
		return logFilter;
	}

	/**
	 * 回话过期重定向 Title: <br/>
	 * Description:
	 * @return
	 */
	/*
	 * @Bean public FilterRegistrationBean securityFilter(){ FilterRegistrationBean securityFilter = new FilterRegistrationBean(); securityFilter.setFilter(new SecurityFilter()); securityFilter.addInitParameter("ignoreUrls","/toLogin, /login,/index"); securityFilter.addUrlPatterns("/*"); return securityFilter; }
	 */

	/**
	 * 
	 * Title: <br/>
	 * Description:
	 * @return
	 */
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {

			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				// TODO Auto-generated method stub
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/error404"));
				container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error500"));
				container.addErrorPages(new ErrorPage(java.lang.Throwable.class, "/error500"));
			}
		};
	}
}
