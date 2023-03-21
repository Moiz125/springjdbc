package com.springjdbc.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages={"com.springjdbc.dao"})
public class Config {

	@Bean(name={"ds"})
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/mydb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	
	@Bean(name={"jdbcTemplate"})
	public JdbcTemplate getTemplate() {
		JdbcTemplate template =  new JdbcTemplate();
		template.setDataSource(getDataSource());	
		return template;
	}
	
	//If we use set the person class as @Component and use @Autowired then
	//we don't need to write the below code
	
//	@Bean(name={"personDaoImpl"})
//	public PersonDao personDao() {
//		PersonDaoImpl person = new PersonDaoImpl();
//		person.setJdbcTemplate(getTemplate());
//		return person;
//		
//	}
}
