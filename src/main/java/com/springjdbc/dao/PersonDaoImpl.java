package com.springjdbc.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.springjdbc.entities.Person;
@Component
public class PersonDaoImpl implements PersonDao{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
//insert query
	public int insert(Person person) {
		// TODO Auto-generated method stub
		
        String query = "Insert INTO person(age,name) VALUES(?,?)";
        int result = this.jdbcTemplate.update(query,person.getAge(),person.getName());
		return result;
	}
//update query
	public int change(Person person) {
		String query ="UPDATE person set age=? ,name=? WHERE age=?";
		int result = jdbcTemplate.update(query,person.getAge(),person.getName(),person.getAge());
		return result;
	}
//delete query	
	public int delete(int age) {
		String query = "DELETE FROM person WHERE age=?";
		int result = jdbcTemplate.update(query,age);
		return result;
	}
//select one query
	public Person getPerson(int age) {
		String query ="SELECT * FROM person WHERE age=?";
		RowMapper<Person> rowMapper = new RowMapperImpl();
		Person person = this.jdbcTemplate.queryForObject(query,rowMapper,age);
		return person;
	}
//select all query
	public List<Person> getAllPersons() {
		String query = "SELECT * FROM person";
		List<Person> person = this.jdbcTemplate.query(query,new RowMapperImpl());
		return person;
	}
	
	
}
