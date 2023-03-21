package com.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springjdbc.entities.Person;

public class RowMapperImpl implements RowMapper<Person> {

	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Person person = new Person();
		person.setAge(rs.getInt(1));
		person.setName(rs.getString(2));
		return person;
	}
	
	
}
