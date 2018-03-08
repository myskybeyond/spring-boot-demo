package com.example.demo.web;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@ComponentScan
@ConfigurationProperties(prefix="spring.datasource")
public class DataSourceConfig {

	private String url;
    private String username;
    private String password;

    @Bean(name = "testDs")
    @Primary
    public DataSource getDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);// 用户名
        dataSource.setPassword(password);// 密码
        dataSource.setValidationQuery("SELECT 'x' from dual");
        dataSource.setTestOnBorrow(false);
        dataSource.setTestWhileIdle(true);
        try {
			dataSource.setFilters("stat, wall");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return dataSource;
    }

    public String getUrl() {
     return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
