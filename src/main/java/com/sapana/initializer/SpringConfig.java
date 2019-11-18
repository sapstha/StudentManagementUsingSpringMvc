package com.sapana.initializer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.sapana")
public class SpringConfig  extends WebMvcConfigurerAdapter{
	 @Autowired
	 DataSource dataSource;
	//<!-- adding view resolver to show jsp's on browser -->
	@Bean
	public InternalResourceViewResolver viewResolver() 
	{
		
		InternalResourceViewResolver vr= new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/views/");
		vr.setSuffix(".jsp");
		return vr;
	}
	//!-- adding	extra resources like css,images,jquery   -->
	 @Override
	 public void addResourceHandlers(ResourceHandlerRegistry registry) {
	  registry.addResourceHandler("/theme/**").addResourceLocations("/theme/**");
	 }
	
	 @Bean
	    public JdbcTemplate jdbcTemplate() {
	        JdbcTemplate jdbcTemplate = new JdbcTemplate();
	        jdbcTemplate.setDataSource(dataSource());

	        return jdbcTemplate;
	    }

	 //<!-- declare datasource bean -->
	    @Bean
	    public DriverManagerDataSource dataSource() {
	        DriverManagerDataSource dataSource = new DriverManagerDataSource();
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	        dataSource.setUrl("jdbc:mysql://localhost:3306/mydatabase?serverTimezone=UTC");
	        dataSource.setUsername("root");
	        dataSource.setPassword("");

	        return dataSource;
	    }
	    
	

}
